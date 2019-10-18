package sdkdemo.kx.come.easypaylibrary.httpService;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    String BASE_URL = "http://sd.coshine.com/gateway/";

    @FormUrlEncoded
    @POST("gateway/payment")
    Observable<ResponseBody> getOrder(@FieldMap Map<String, String> map);

}

