package sdkdemo.kx.come.easypaylibrary.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by xief on 2018/9/14.
 */

public class SubWebLayout extends ViewLayout {
    private CardWebLayout mCardWebLayout;
    private TextView mTextView;

    @SuppressLint("NewApi")
    @Override
    protected View initLayout(Context mContext) {
        LinearLayout contentLinearLayout = getMatchParentLinearLayout(mContext);
        contentLinearLayout.setBackgroundColor(Color.parseColor("#40000000"));
        contentLinearLayout.setGravity(Gravity.BOTTOM);

        mTextView = new TextView(mContext);
        LinearLayout.LayoutParams textViewLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (int) dpTurnedToPx(50));
        mTextView.setLayoutParams(textViewLayoutParams);
        mTextView.setTextColor(Color.parseColor("#B50909"));
        mTextView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        mTextView.setText("BACK");
        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, dpTurnedToPx(25));
        mTextView.setPadding((int) dpTurnedToPx(25), 0, (int) dpTurnedToPx(25), 0);
        mTextView.setGravity(Gravity.CENTER);
        mCardWebLayout = new CardWebLayout();

        View mView = new View(mContext);
        LinearLayout.LayoutParams viewLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (int) dpTurnedToPx(1.3f));
        mView.setLayoutParams(viewLayoutParams);
        mView.setBackgroundColor(Color.parseColor("#ebebeb"));


        contentLinearLayout.addView(mCardWebLayout.createView(mContext));
        contentLinearLayout.addView(mView);
        contentLinearLayout.addView(mTextView);
        mCardWebLayout.getLoadingView().setVisibility(View.GONE);
        return contentLinearLayout;
    }

    public WebView getWebView() {
        return mCardWebLayout.getWebView();
    }

    public TextView getTextView() {
        return mTextView;
    }

    public void destroyWebView() {
        mCardWebLayout.destroyWebView();
    }
}
