package sdkdemo.kx.come.easypaylibrary.control;

import sdkdemo.kx.come.easypaylibrary.interfaces.CardClient;
import sdkdemo.kx.come.easypaylibrary.interfaces.PaymentResult;
import sdkdemo.kx.come.easypaylibrary.layout.CardWebLayout;
import sdkdemo.kx.come.easypaylibrary.layout.CustomPopupWindow;

public class RequestControl {

    private PaymentResult mPaymentResult;
    private CardClient mCardClient;
    public RequestControl(CustomPopupWindow mCustomPopupWindow, CardWebLayout view, PaymentResult mPaymentResult) {
        this.mPaymentResult = mPaymentResult;
        init(view, mCustomPopupWindow);
    }

    private void init(CardWebLayout view,CustomPopupWindow mCustomPopupWindow) {
        mCardClient = new CardClient(mCustomPopupWindow, mPaymentResult, view);
        view.getWebView().setWebViewClient(mCardClient);
    }

    public void visitWebView(String data) {
        mCardClient.sendUrl(data);
    }

    public void postData(String data) {
        mCardClient.postData(data);
    }
}
