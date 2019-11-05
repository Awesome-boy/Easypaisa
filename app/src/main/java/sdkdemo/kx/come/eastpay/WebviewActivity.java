package sdkdemo.kx.come.eastpay;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import sdkdemo.kx.come.easypaisa.R;

public class WebviewActivity extends BaseActivity {

    private static final String TAG = WebviewActivity.class.getSimpleName();
    @BindView(R.id.webvieww)
    WebView webView;
    private String htmlUrl="http://www.baidu.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        initWebView();
    }

    private void initWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setJavaScriptEnabled(true);   //设置支持javascript脚本
        webSettings.setAllowFileAccess(true);     // 允许访问文件
        webSettings.setBuiltInZoomControls(true); // 设置显示缩放按钮
        //不显示webview缩放按钮
        webSettings.setDisplayZoomControls(false);
        webSettings.setUseWideViewPort(true);
        //设置是否启用安全浏览。
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            webSettings.setSafeBrowsingEnabled(true);
//        }
        webSettings.setDomStorageEnabled(true);
        //缩放至屏幕的大小
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);     //支持缩放
//        if (Build.VERSION.SDK_INT >= 21) {
//            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            webSettings.setMediaPlaybackRequiresUserGesture(false);
//        }
        webView.loadUrl(htmlUrl);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.d(TAG,"----shouldOverrideUrlLoading--"+view.getUrl());

                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.d(TAG,"----onPageStarted--");
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.d(TAG,"----onPageFinished--");
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Log.d(TAG,"----onReceivedError");
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Log.d(TAG,"----onProgressChanged="+newProgress);
                super.onProgressChanged(view, newProgress);
            }
        });
    }
}
