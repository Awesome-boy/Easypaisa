package sdkdemo.kx.come.easypaylibrary.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.PopupWindow;



/**
 * Created by xief on 2018/5/4.
 */

public class CustomPopupWindow {

    private PopupWindow mPopupWindow;
    private Activity mActivity;
    private boolean viewExistenceKey = false;
    private boolean popupwindowDisplayKey = false;
    private SubWebLayout mSubWebLayout;
    private WebView mWebView;

    public CustomPopupWindow(Activity mActivity) {
        this.mActivity = mActivity;
        mPopupWindow = new PopupWindow(mActivity);
        setPopupWindowSetting(mPopupWindow);
        mSubWebLayout = new SubWebLayout();
        mPopupWindow.setContentView(mSubWebLayout.createView(mActivity));
        mSubWebLayout.getTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissPopupWindow();
            }
        });
        mSubWebLayout.getWebView().setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (Build.VERSION.SDK_INT < 26) {
                    view.loadUrl(url);
                    return true;
                }
                return false;
            }
        });
        View view = mActivity.getWindow().getDecorView();
        judgeViewDisplay(view);
    }


    private void judgeViewDisplay(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                viewExistenceKey = true;
                if (popupwindowDisplayKey) {
                    showPopupWindow();
                    popupwindowDisplayKey = !popupwindowDisplayKey;
                }
            }
        });
    }

    protected void setPopupWindowSetting(PopupWindow mPopupWindow) {
        mPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setFocusable(true);
    }

    public void showPopupWindow() {
        try {
            if (viewExistenceKey) {
                if (!mPopupWindow.isShowing()) {
                    if (!mActivity.isFinishing()) {
                        mPopupWindow.showAtLocation(mActivity.getWindow().getDecorView(), Gravity.CENTER, 0, 0);
                    }
                }
            } else {
                popupwindowDisplayKey = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SubWebLayout getSubWebLayout() {
        return mSubWebLayout;
    }

    public void showPopupWindowAsDropDown(View view) {
        try {
            if (viewExistenceKey) {
                if (!mPopupWindow.isShowing()) {
                    if (!mActivity.isFinishing()) {
                        mPopupWindow.showAsDropDown(view);
                    }
                }
            } else {
                popupwindowDisplayKey = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setWebView(WebView mWebView) {
        this.mWebView = mWebView;
    }

    @SuppressLint("WrongConstant")
    public void dismissPopupWindow() {
        popupwindowDisplayKey = false;
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
        }
    }

    public void setCancelable(boolean cancelable) {
        mPopupWindow.setOutsideTouchable(cancelable);
    }
}
