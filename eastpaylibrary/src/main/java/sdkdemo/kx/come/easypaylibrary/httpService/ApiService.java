package sdkdemo.kx.come.easypaylibrary.httpService;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import sdkdemo.kx.come.easypaylibrary.BuildConfig;

public interface ApiService {
//    String BASE_URL = "http://192.168.0.102:8080//paygwy/";
    String BASE_URL = "http://sd.coshine.com/gateway/";
    //支付
    @FormUrlEncoded
    @POST("gateway/payment")
    Observable<ResponseBody> getOrder(@FieldMap Map<String, String> map);
    //授权
    @FormUrlEncoded
    @POST("gateway/authorization")
    Observable<ResponseBody> setAuthorization(@FieldMap Map<String, String> map);

    //查询
    @FormUrlEncoded
    @POST(BuildConfig.IS_RELEASE ? "gateway/inquiry" : "tests/query_result.jsp")
    Observable<ResponseBody> query(@FieldMap Map<String, String> map);

    //撤销
    @FormUrlEncoded
    @POST(BuildConfig.IS_RELEASE ? "gateway/refund" : "tests/refund_result.jsp")
    Observable<ResponseBody> refund(@FieldMap Map<String, String> map);

    //退回
    @FormUrlEncoded
    @POST(BuildConfig.IS_RELEASE ? "gateway/void" : "tests/void_result.jsp")
    Observable<ResponseBody> reback(@FieldMap Map<String, String> map);

    // TODO: 2019-10-24
    //订单检查
    @FormUrlEncoded
    @POST("tests/order_check_result.jsp")
    Observable<ResponseBody> orderCheck(@FieldMap Map<String, String> map);

    //genQR
    @FormUrlEncoded
    @POST(BuildConfig.IS_RELEASE ? "gateway/genQR" : "tests/genQR_result.jsp")
    Observable<ResponseBody> genQR(@FieldMap Map<String, String> map);

    //genQR
    @FormUrlEncoded
    @POST(BuildConfig.IS_RELEASE ? "gateway/parseQR" : "tests/parseQR_result.jsp")
    Observable<ResponseBody> parseQR(@FieldMap Map<String, String> map);

}

