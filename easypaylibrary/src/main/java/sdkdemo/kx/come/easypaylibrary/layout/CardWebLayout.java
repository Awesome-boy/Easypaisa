package sdkdemo.kx.come.easypaylibrary.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;


/**
 * Created by xief on 2018/9/14.
 */

public class CardWebLayout extends ViewLayout {
    private WebView webView;
    private ProgressBar progressBar;
    private View mView;


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
        setWebView();
        mRelativeLayout.addView(webView);

        progressBar = new ProgressBar(mContext, null, android.R.attr.progressBarStyleHorizontal);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (int) dpTurnedToPx(2.2f));
        progressBar.setLayoutParams(layoutParams);
        mRelativeLayout.addView(progressBar);


        mView = new LoadingLayout().createView(mContext);
        mRelativeLayout.addView(mView);
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
        webView.removeAllViews();
        webView.destroy();
        webView = null;
    }

    private void setWebView() {
        WebSettings webSettings = webView.getSettings();
        // 支持 Js 使用
        webSettings.setJavaScriptEnabled(true);
        // 开启DOM缓存
        webSettings.setDomStorageEnabled(true);
        // 支持缩放
        webSettings.setSupportZoom(true);
        // 允许通过 file url 加载的 Javascript 读取其他的本地文件,Android 4.1 之前默认是true，在 Android 4.1 及以后默认是false,也就是禁止
        webSettings.setAllowFileAccessFromFileURLs(false);
        // 允许通过 file url 加载的 Javascript 可以访问其他的源，包括其他的文件和 http，https 等其他的源，
        // Android 4.1 之前默认是true，在 Android 4.1 及以后默认是false,也就是禁止
        // 如果此设置是允许，则 setAllowFileAccessFromFileURLs 不起做用
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        //将图片调整到适合webview的大小
        webSettings.setUseWideViewPort(true);
        //缩放操作
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        //支持自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格
    }
}
