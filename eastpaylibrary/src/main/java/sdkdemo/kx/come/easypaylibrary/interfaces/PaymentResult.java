package sdkdemo.kx.come.easypaylibrary.interfaces;

import android.app.Activity;


import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;


/**
 * Created by xief on 2018/9/3.
 */

public final class PaymentResult {
    public final static int PAY_STATE_CANCEL = 0;
    public final static int PAY_STATE_SUCCESS = 1;
    public final static int PAY_STATE_FAILED = 2;

    private CheckoutCallback paymentCallback;
    private Activity mActivity;

    public PaymentResult(Activity mActivity) {
        this.mActivity = mActivity;
        try {
            this.paymentCallback = Callback.getCheckoutCallback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void failurePayment(String resultMessage) {
        resultInformation(PAY_STATE_FAILED, resultMessage);
    }



    public void successPayment(String resultMessage) {
        resultInformation(PAY_STATE_SUCCESS, resultMessage);
    }

    public void cancelPayment(String resultMessage) {
        resultInformation(PAY_STATE_CANCEL, resultMessage);
    }

    private String getNullResultMessage(int code, String msg, String transactionId) {
        JSONObject resultMessage = new JSONObject();
        try {
            resultMessage.put("message", msg);
            resultMessage.put("responseCode", code);
            resultMessage.put("transactionId", transactionId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultMessage.toString();
    }

    private void resultInformation(int code, String mResultMessage) {
        try {
            switch (code) {
                case PaymentResult.PAY_STATE_CANCEL:
                    paymentCallback.onCancel(mResultMessage);
                    break;
                case PaymentResult.PAY_STATE_FAILED:
                    paymentCallback.onError(mResultMessage);
                    break;
                case PaymentResult.PAY_STATE_SUCCESS:
                    paymentCallback.onSuccess(mResultMessage);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
//            paymentCallback.onError(mResultMessage);
            e.printStackTrace();
        }
    }


    public void activityFinish() {
        mActivity.finish();
        mActivity.overridePendingTransition(0, android.R.anim.fade_out);
    }
}
