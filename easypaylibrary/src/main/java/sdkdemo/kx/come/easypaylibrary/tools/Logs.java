package sdkdemo.kx.come.easypaylibrary.tools;

import android.util.Log;

/**
 * Created by xief on 2016/12/6.
 */

public class Logs {

    public final static String TAG = "Checkout Counter";

    public static boolean isDebug = true;

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void d(int msg) {
        if (isDebug)
            Log.d(TAG, msg + "");
    }

    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void e(Object msg) {
        if (isDebug)
            Log.e(TAG, msg.toString());
    }

    public static void w(Object msg) {
        if (isDebug)
            Log.w(TAG, msg.toString());
    }

    public static void v(Object msg) {
        if (isDebug)
            Log.v(TAG, msg.toString());
    }
}
