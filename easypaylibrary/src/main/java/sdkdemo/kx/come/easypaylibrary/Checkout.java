package sdkdemo.kx.come.easypaylibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import sdkdemo.kx.come.easypaylibrary.activity.PaymentActivity;
import sdkdemo.kx.come.easypaylibrary.bean.payment.PaymentBean;
import sdkdemo.kx.come.easypaylibrary.interfaces.Callback;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;
import sdkdemo.kx.come.easypaylibrary.tools.CheckoutTools;


/**
 *
 */

public final class Checkout {

    private static Checkout mCheckout;

    private String md5Key;
    private String mMerchantMID;


    /**
     * 收银台支付
     */
    public static final int CARD_URL_PAYMENT_TPYE = 323;
    /**
     * 收银台支付-预授权
     */
    public static final int CARD_URL_AUTH_PAYMENT_TPYE = 324;
    /**
     * 两方支付
     */
    public static final int CARD_CAMP_PAYMENT_TPYE = 325;
    /**
     * 两方支付-预授权
     */
    public static final int CARD_CAMP_AUTH_PAYMENT_TPYE = 326;
    /**
     * 创建token支付
     */
    public static final int CARD_TOKEN_CREATE_TPYE = 327;
    /**
     * 使用token支付
     */
    public static final int CARD_TOKEN_PAYMENT_TPYE = 328;
    public Intent mGoopayIntent;

    private Checkout() {

    }

    /**
     * @param
     * @param
     * @throws
     */
//    public static void initialize(Context mContext, String md5Key) throws CheckoutException {
//        ApplicationInfo info = null;
//        try {
//            info = mContext.getPackageManager()
//                    .getApplicationInfo(mContext.getPackageName(), PackageManager.GET_META_DATA);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (info != null) {
//            Object merchantMID = info.metaData.get(CheckoutTools.CHECKOUT_MERCHANT);
//            if (merchantMID == null || merchantMID.equals("")) {
//                throw new CheckoutException(CheckoutException.EXCEPTION_NOT_MERCHANT_ID);
//            }
//            if (md5Key == null || md5Key.equals("")) {
//                throw new CheckoutException(CheckoutException.EXCEPTION_NOT_MD5_KEY);
//            }
//            if (mCheckout == null) {
//                mCheckout = new Checkout();
//            }
//            try {
//                String debug = info.metaData.getString(CheckoutTools.CHECKOUT_DEBUG);
//                if (CheckoutTools.FORMAL_ENVIRONMENT.equals(debug)) {
//                    Logs.isDebug = false;
//                } else if (CheckoutTools.SANDBOX_ENVIRONMENT.equals(debug)) {
//                    Logs.isDebug = true;
//                } else {
//                    throw new CheckoutException(CheckoutException.EXCEPTION_NOT_DEBUG_KEY);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                Logs.isDebug = true;
//            }
//            mCheckout.setMerchantMID(merchantMID.toString());
//            Logs.i("MERCHANT ID : " + merchantMID);
//            mCheckout.setMd5Key(md5Key);
//            Logs.i("MD5 KEY : " + md5Key);
//        }
//    }

    public static Checkout getInstance()  {
        if (mCheckout == null) {
            mCheckout=new Checkout();
        }
        return mCheckout;
    }

    /**
     * @param md5Key
     */
    private void setMd5Key(String md5Key) {
        this.md5Key = md5Key;
    }

    /**
     * @param mMerchantMID
     */
    private void setMerchantMID(String mMerchantMID) {
        this.mMerchantMID = mMerchantMID;
    }

    /**
     * @param mActivity
     * @param mListener
     */
    public  void toCheckout(Activity mActivity, PaymentBean bean, CheckoutCallback mListener) {
        Callback.setCheckoutCallback(mListener);
        if (mGoopayIntent == null) {
            mGoopayIntent = new Intent();
        }
        mGoopayIntent.putExtra(CheckoutTools.INFO,bean);
        mGoopayIntent.setClass(mActivity, PaymentActivity.class);
        mActivity.startActivity(mGoopayIntent);
        mActivity.overridePendingTransition(android.R.anim.fade_in, 0);


    }

    /**
     * @param mActivity
     * @param mInfo
     * @param mListener
     * @return
     */
//    private boolean toPay(Activity mActivity, PayInfo mInfo, CheckoutCallback mListener) {
//        if (OrderJudgement.stringDetectionNull(mMerchantMID) || OrderJudgement.stringDetectionNull(md5Key)) {
//            try {
//                throw new CheckoutException(CheckoutException.EXCEPTION_INIT);
//            } catch (CheckoutException e) {
//                e.printStackTrace();
//            }
//            return false;
//        }
//        if (!isOpenNetwork(mActivity)) {
//            return false;
//        }
//        if (!checkPayInfo(mActivity, mInfo)) {
//            return false;
//        }
//        if (mAllPayment == null) {
//            mAllPayment = new AllPayment();
//        }
//        if (mListener == null) {
//            Log.e(Logs.TAG, "CheckoutCallback:>Listener is Null!");
//            return false;
//        }
//        mInfo.setMerchantID(mMerchantMID);
//        mInfo.setMd5Key(md5Key);
//        mInfo.setHttpKey(Logs.isDebug);
//        Callback.setCheckoutCallback(mListener);
//        return true;
//    }




    /**
     * 对网络连接状态进行判断
     *
     * @param mContext
     * @return true, 可用； false， 不可用
     */
    public boolean isOpenNetwork(Context mContext) {
        ConnectivityManager connManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        } else {
            Toast.makeText(mContext, "请检查你的网络连接。", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


}
