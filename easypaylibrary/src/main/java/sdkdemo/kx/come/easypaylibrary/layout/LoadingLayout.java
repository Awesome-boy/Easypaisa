package sdkdemo.kx.come.easypaylibrary.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by xief on 2018/9/3.
 */

public class LoadingLayout extends ViewLayout {
    @Override
    protected View initLayout(Context mContext) {
        LinearLayout contentLinearLayout = getMatchParentLinearLayout(mContext);
        contentLinearLayout.setBackgroundColor(Color.parseColor("#40000000"));
        contentLinearLayout.setGravity(Gravity.CENTER);


        ProgressBar mProgressBar = new ProgressBar(mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) dpTurnedToPx(30),
                (int) dpTurnedToPx(30));
        mProgressBar.setLayoutParams(layoutParams);
        mProgressBar.setBackgroundColor(Color.TRANSPARENT);
        contentLinearLayout.addView(mProgressBar);

        TextView mTextView = new TextView(mContext);
        LinearLayout.LayoutParams mLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mTextView.setLayoutParams(mLayoutParams);
        mTextView.setBackgroundColor(Color.TRANSPARENT);
        mTextView.setTextColor(Color.WHITE);
        mTextView.setText("Loading...");
        contentLinearLayout.addView(mTextView);


        return contentLinearLayout;
    }
}
