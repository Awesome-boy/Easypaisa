package sdkdemo.kx.come.easypaylibrary.interfaces;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by xief on 2018/6/12.
 */

public interface CheckoutCallback {
    void onCancel(String mResultMessage);

    void onSuccess(String mResultMessage);

    void onError(String mResultMessage);
}
