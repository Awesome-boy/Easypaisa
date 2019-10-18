package sdkdemo.kx.come.easypaylibrary.layout;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xief on 2018/8/8.
 */

public abstract class ViewLayout {
    /**
     * 所得屏幕的像素大小(The pixel size of the screen)
     */
    protected int thisWidthPx;
    protected int thisHeightPx;
    protected static int thisDpi;

    /**
     * 字体大小(Text size)
     */
    public static final int TEXT_SIZE_15 = 15;


    private void initDisplayMetrics(Context context) {
        DisplayMetrics metric = new DisplayMetrics();
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.getDefaultDisplay().getMetrics(metric);
        thisWidthPx = metric.widthPixels; // 屏幕宽度（像素）
        thisHeightPx = metric.heightPixels; // 屏幕宽度（像素）
        thisDpi = metric.densityDpi;// 屏幕DPI
    }

    public View createView(Context mContext) {
        initDisplayMetrics(mContext);
        return initLayout(mContext);
    }

    protected abstract View initLayout(Context mContext);

    protected LinearLayout getMatchParentLinearLayout(Context mContext) {
        LinearLayout mLinearLayout = new LinearLayout(mContext);
        LinearLayout.LayoutParams mLinearLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mLinearLayout.setOrientation(LinearLayout.VERTICAL);
        mLinearLayout.setLayoutParams(mLinearLayoutParams);
        return mLinearLayout;
    }


    /**
     * @return
     */
    protected int getMySelfViewId(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return View.generateViewId();
        } else {
            AtomicInteger sNextGeneratedId = new AtomicInteger(id);
            return sNextGeneratedId.get();
        }

    }

    public static float dpTurnedToPx(float dp) {
        return dp * (thisDpi / 160f);
    }
}
