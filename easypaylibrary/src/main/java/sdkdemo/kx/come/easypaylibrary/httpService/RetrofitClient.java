package sdkdemo.kx.come.easypaylibrary.httpService;

import android.annotation.SuppressLint;
import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sdkdemo.kx.come.easypaylibrary.tools.SecurityUtil;


public class RetrofitClient {
    private static RetrofitClient instance;
    private ApiService apiService;

    public static RetrofitClient getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitClient(context);
        }
        return instance;
    }

    public static RetrofitClient getInstance() {
        return instance;
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new RetrofitClient(context);
        }
    }


    @SuppressWarnings("deprecation")
    private RetrofitClient(Context context) {
        OkHttpClient.Builder builder =  new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(chain -> {
                        Request req = chain.request();
                        String param;
                        if ("GET".equals(req.method()) || "DELETE".equals(req.method())) {
                            param = req.url().query();
                        } else {
                            Buffer buffer = new Buffer();
                            req.body().writeTo(buffer);
                            param = buffer.clone().readString(Charset.forName("UTF-8"));
                        }
                        return chain.proceed(chain.request().newBuilder()
                                .addHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8")
                                .build());
                    })
//                 .sslSocketFactory(getSSLSocketFactory())
                    .retryOnConnectionFailure(true)
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .hostnameVerifier((hostname, session) -> true);

        OkHttpClient okHttpClient = builder.build();
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())).
                baseUrl(ApiService.BASE_URL).build();
        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }

    private static SSLSocketFactory getSSLSocketFactory() throws Exception {
        // 创建一个不验证证书链的证书信任管理器。
        final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @SuppressLint("TrustAllX509TrustManager")
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] chain, String authType)
                    throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] chain, String authType)
                    throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[0];
            }
        }};

        // Install the all-trusting trust manager
        final SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        // Create an ssl socket factory with our all-trusting manager
        return sslContext.getSocketFactory();
    }
}