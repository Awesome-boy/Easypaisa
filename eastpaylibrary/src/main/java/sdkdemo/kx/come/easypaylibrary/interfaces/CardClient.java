package sdkdemo.kx.come.easypaylibrary.interfaces;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import sdkdemo.kx.come.easypaylibrary.httpService.ApiService;
import sdkdemo.kx.come.easypaylibrary.layout.CardWebLayout;
import sdkdemo.kx.come.easypaylibrary.layout.CustomPopupWindow;

/**
 * Created by xief on 2018/6/13.
 */

public final class CardClient extends WebViewClient {
    private CardWebLayout cardWebLayout;
    private PaymentResult paymentResult;
    private CustomPopupWindow mCustomPopupWindow;
    private AndroidAndJSInterface mAndroidAndJSInterface;
    //    是否是收银台
    private boolean checkoutKey = false;

    public CardClient(CustomPopupWindow mCustomPopupWindow, PaymentResult paymentResult, CardWebLayout cardWebLayout) {
        mAndroidAndJSInterface = new AndroidAndJSInterface();
        this.mCustomPopupWindow = mCustomPopupWindow;
        this.paymentResult = paymentResult;
        this.cardWebLayout = cardWebLayout;
        this.mCustomPopupWindow.setWebView(cardWebLayout.getWebView());
    }

    public void sendUrl(String data) {
        cardWebLayout.getWebView().addJavascriptInterface(mAndroidAndJSInterface, "Android");
        cardWebLayout.getWebView().loadDataWithBaseURL(ApiService.BASE_URL,  data, "text/html", "UTF-8", null);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        //Android8.0以下的需要返回true 并且需要loadUrl；8.0之后效果相反
        if (Build.VERSION.SDK_INT < 26) {
            view.loadUrl(url);
            return true;
        }
        return false;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        cardWebLayout.getLoadingView().setVisibility(View.GONE);
    }

    private static boolean httpKey = true;



    public static void setHttpKey(boolean httpKey) {
        CardClient.httpKey = httpKey;
    }

    public static boolean isHttpKey() {
        return CardClient.httpKey;
    }

    private String testKey(String value) {
        return value != null ? value : "";
    }

    public void postData(String data) {
        cardWebLayout.getWebView().addJavascriptInterface(mAndroidAndJSInterface, "Android");
        cardWebLayout.getWebView().postUrl(ApiService.BASE_URL+"gateway/payment",  data.getBytes());

    }

    public class AndroidAndJSInterface {
        final Handler myHandler = new Handler();

        @SuppressLint("JavascriptInterface")
        @JavascriptInterface
        public void showCustomPopupWindow(final String url) {
            myHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCustomPopupWindow.showPopupWindow();
                    mCustomPopupWindow.getSubWebLayout().getWebView().loadUrl(url);
                }
            });
        }
    }
}


