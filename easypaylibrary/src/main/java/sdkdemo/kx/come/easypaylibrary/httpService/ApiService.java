package sdkdemo.kx.come.easypaylibrary.httpService;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

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
    @POST("tests/query_result.jsp")
    Observable<ResponseBody> query(@FieldMap Map<String, String> map);

    //撤销
    @FormUrlEncoded
    @POST("tests/refund_result.jsp")
    Observable<ResponseBody> refund(@FieldMap Map<String, String> map);

    //退回
    @FormUrlEncoded
    @POST("tests/void.jsp")
    Observable<ResponseBody> revoid(@FieldMap Map<String, String> map);


    //订单检查
    @FormUrlEncoded
    @POST("tests/order_check_result.jsp")
    Observable<ResponseBody> orderCheck(@FieldMap Map<String, String> map);

}

