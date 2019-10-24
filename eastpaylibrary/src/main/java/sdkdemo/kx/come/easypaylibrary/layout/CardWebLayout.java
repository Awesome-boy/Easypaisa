package sdkdemo.kx.come.easypaylibrary.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import sdkdemo.kx.come.easypaylibrary.httpService.ApiService;


/**
 * Created by xief on 2018/9/14.
 */

public class CardWebLayout extends ViewLayout {
    private WebView webView;
    private ProgressBar progressBar;
    private View mView;
    private WebChromeClient mWebChromeClient;




    @Override
    protected View initLayout(Context mContext) {
        RelativeLayout mRelativeLayout = new RelativeLayout(mContext);
        RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mRelativeLayout.setLayoutParams(relativeLayoutParams);
        mRelativeLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));

        webView = new WebView(mContext);
        RelativeLayout.LayoutParams webLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        webView.setLayoutParams(webLayoutParams);
        mRelativeLayout.addView(webView);

        progressBar = new ProgressBar(mContext, null, android.R.attr.progressBarStyleHorizontal);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (int) dpTurnedToPx(2.2f));
        ClipDrawable drawable = new ClipDrawable(new ColorDrawable(Color.RED), Gravity.LEFT, ClipDrawable.HORIZONTAL);
        progressBar.setProgressDrawable(drawable);//必须先设置到progressbar上再设置level，告诉这个drawable的宽度有多宽，这个level才能生效
        drawable.setLevel(0);
        progressBar.setProgressDrawable(drawable);
        progressBar.setProgress(0);
        progressBar.setLayoutParams(layoutParams);
        mRelativeLayout.addView(progressBar);

        mView = new LoadingLayout().createView(mContext);
        mRelativeLayout.addView(mView);


        setWebView();
        return mRelativeLayout;
    }

    public WebView getWebView() {
        return webView;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public View getLoadingView() {
        return mView;
    }

    public void destroyWebView() {
        if (webView != null) {
            webView.removeAllViews();
            webView.destroy();
            webView = null;
        }
    }

    protected void setWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setSavePassword(false);
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        initWebChromeClient();
        webView.setWebChromeClient(mWebChromeClient);

    }

    private void initWebChromeClient() {
        mWebChromeClient = new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    getProgressBar().setVisibility(View.GONE);
                } else {
                    getProgressBar().setVisibility(View.VISIBLE);
                    getProgressBar().setProgress(newProgress);
                }

            }
        };


    }
}
