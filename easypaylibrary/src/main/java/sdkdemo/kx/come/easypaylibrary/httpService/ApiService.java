package sdkdemo.kx.come.easypaylibrary.httpService;


import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import sdkdemo.kx.come.easypaylibrary.bean.payment.BlAdressBean;

public interface ApiService {

    String BASE_URL = "http://sd.coshine.com/gateway";

    @POST("/gateway/payment")
    Observable<ResponseBody> getOrder(@Body BlAdressBean bean);

}

