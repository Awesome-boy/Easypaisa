package sdkdemo.kx.come.easypaylibrary.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import sdkdemo.kx.come.easypaylibrary.R;
import sdkdemo.kx.come.easypaylibrary.httpService.ApiService;
import sdkdemo.kx.come.easypaylibrary.tools.CheckoutTools;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressDialog progressdialog;
    private String data;
    private String baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_webview);
        initView();
        initData();
    }

    private void initView() {
        webView = findViewById(R.id.webview);
    }
    @SuppressLint("SetJavaScriptEnabled")
    protected void initData() {
        data = getIntent().getStringExtra(CheckoutTools.DATA);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setSavePassword(false);
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    hideProgress();
                } else {
                    showProgress("");
                }

            }
        });
        webView.loadDataWithBaseURL("http://sd.coshine.com/gateway/gateway/",  data, "text/html", "UTF-8", null);

    }

    private void hideProgress() {
        if (progressdialog!=null&&progressdialog.isShowing() && !isFinishing()){
            progressdialog.dismiss();
        }

    }

    private void showProgress(String s) {
        if (progressdialog==null){
            progressdialog = new ProgressDialog(this);
        }
        progressdialog.setMessage(s);
        progressdialog.setCancelable(false);
        progressdialog.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        webView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        webView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        } else {
            onBackPressed();
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
