package sdkdemo.kx.come.easypaylibrary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import androidx.collection.ArrayMap;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import sdkdemo.kx.come.easypaylibrary.activity.PaymentActivity;
import sdkdemo.kx.come.easypaylibrary.bean.base.authorization.AuthorizationResp;
import sdkdemo.kx.come.easypaylibrary.bean.base.genQR.GenQRBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.order.OrderCheckBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.parseQRBean.ParseQRBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.payment.PaymentBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.authorization.AuthorizationBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.query.QueryBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.reback.VoidBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.refund.RefundBean;
import sdkdemo.kx.come.easypaylibrary.control.RequestControl;
import sdkdemo.kx.come.easypaylibrary.httpService.ApiService;
import sdkdemo.kx.come.easypaylibrary.httpService.HttpResponse;
import sdkdemo.kx.come.easypaylibrary.httpService.RetrofitClient;
import sdkdemo.kx.come.easypaylibrary.interfaces.Callback;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;
import sdkdemo.kx.come.easypaylibrary.interfaces.PaymentResult;
import sdkdemo.kx.come.easypaylibrary.layout.CardWebLayout;
import sdkdemo.kx.come.easypaylibrary.layout.CustomPopupWindow;
import sdkdemo.kx.come.easypaylibrary.tools.CheckoutTools;
import sdkdemo.kx.come.easypaylibrary.tools.ParamsTools;


/**
 *
 */

public final class Checkout{

    private static Checkout mCheckout;

    public Intent mGoopayIntent;


    private Checkout() {

    }


    public static Checkout getInstance()  {
        if (mCheckout == null) {
            mCheckout=new Checkout();
        }
        return mCheckout;
    }


    /**
     * @param mActivity
     * @param mListener
     */
    public  void setPayment(Activity mActivity, String type,Object bean, CheckoutCallback mListener) {
        Callback.setCheckoutCallback(mListener);
        if (mGoopayIntent == null) {
            mGoopayIntent = new Intent();
        }
        mGoopayIntent.putExtra(CheckoutTools.TYPE,type);
        mGoopayIntent.putExtra(CheckoutTools.INFO, (Serializable) bean);
        mGoopayIntent.setClass(mActivity, PaymentActivity.class);
        mActivity.startActivity(mGoopayIntent);
        mActivity.overridePendingTransition(android.R.anim.fade_in, 0);

    }

    public static void sendPaymentQuest(Activity activity, PaymentBean paymentBean,RequestControl mControl) {
        Map<String,String> params = ParamsTools.setParams(paymentBean);
       PaymentResult mPaymentResult = new PaymentResult(activity);
        RetrofitClient.getInstance(activity)
                .getApiService()
                .getOrder(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    private String data;

                    @Override
                    public void onSubscribe(Disposable d) {

                        Log.i("zt", "onSubscribe:");
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Log.i("zt", "onNext:" + value);
                        try {
                            data = value.string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }


                    @Override
                    public void onError(Throwable e) {
                        mPaymentResult.failurePayment(data);
                        Log.i("zt", "onError:" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.i("zt", "onComplete:");
//                        mPaymentResult.successPayment(data);
                        mControl.visitWebView(data);

                    }
                });
    }
    public void setAuthorization(Activity mActivity, AuthorizationBean bean,CheckoutCallback mListener) {
       Callback.setCheckoutCallback(mListener);
        PaymentResult mPaymentResult=new PaymentResult(mActivity);
        Map<String,String> params=ParamsTools.authorizationParams(bean);
        RetrofitClient.getInstance(mActivity)
                .getApiService()
                .setAuthorization(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    private String data;
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("zt", "onSubscribe:");
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            data = value.string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.i("zt", "onError:" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.i("zt", "onComplete:"+data);
                       JSONObject jsonObject=JSONObject.parseObject(data);
                       if (jsonObject.getString("errorCode").equals("E3")){
                           mPaymentResult.failurePayment(data);
                       }else {
                           mPaymentResult.successPayment(data);
                       }


                    }
                });

    }

    public static void queryResult(Activity mActivity, QueryBean bean, RequestControl mControl) {
        PaymentResult mPaymentResult=new PaymentResult(mActivity);
        Map<String,String> params=ParamsTools.query(bean);
        RetrofitClient.getInstance(mActivity)
                .getApiService()
                .query(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    private String data;
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("zt", "onSubscribe:");
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            data = value.string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.i("zt", "onError:" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.i("zt", "onComplete:"+data);
                        mPaymentResult.successPayment(data);
                        mControl.visitWebView(data);

                    }
                });

    }

    public static void refundResult(Activity mActivity, RefundBean bean,  RequestControl mControl) {
        PaymentResult mPaymentResult=new PaymentResult(mActivity);
        Map<String,String> params=ParamsTools.refund(bean);
        RetrofitClient.getInstance(mActivity)
                .getApiService()
                .refund(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    private String data;
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("zt", "onSubscribe:");
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Log.i("zt", "onNext:"+value);
                        try {
                            data = value.string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.i("zt", "onError:" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.i("zt", "onComplete:");
                        mPaymentResult.successPayment(data);
                        mControl.visitWebView(data);
                    }
                });
    }


    public static void reback(Activity mActivity, VoidBean bean,  RequestControl mControl) {
        PaymentResult mPaymentResult=new PaymentResult(mActivity);
        Map<String,String> params=ParamsTools.reback(bean);
        RetrofitClient.getInstance(mActivity)
                .getApiService()
                .reback(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    private String data;
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("zt", "onSubscribe:");
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Log.i("zt", "onNext:"+value);
                        try {
                            data=value.string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.i("zt", "onError:" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.i("zt", "onComplete:");
                        mPaymentResult.successPayment(data);
                        mControl.visitWebView(data);

                    }
                });
    }


    public static void orderCheck(Activity mActivity, OrderCheckBean bean,  RequestControl mControl) {
        PaymentResult mPaymentResult=new PaymentResult(mActivity);
        Map<String,String> params=ParamsTools.orderCheck(bean);
        RetrofitClient.getInstance(mActivity)
                .getApiService()
                .orderCheck(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    private String data;
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("zt", "onSubscribe:");
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Log.i("zt", "onNext:"+value);
                        try {
                            data=value.string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.i("zt", "onError:" + e);
                    }

                    @Override
                    public void onComplete() {
                        mPaymentResult.successPayment(data);
                        Log.i("zt", "onComplete:");
                        mControl.visitWebView(data);
                    }
                });
    }

    public static void genQR(Activity mActivity, GenQRBean bean,RequestControl mControl) {
        PaymentResult mPaymentResult=new PaymentResult(mActivity);
        Map<String,String> params=ParamsTools.genQR(bean);
        RetrofitClient.getInstance(mActivity)
                .getApiService()
                .genQR(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    private String data;
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("zt", "onSubscribe:");
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Log.i("zt", "onNext:"+value);
                        try {
                            data = value.string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.i("zt", "onError:" + e);
                        mPaymentResult.failurePayment("");
                    }

                    @Override
                    public void onComplete() {
                        Log.i("zt", "onComplete:");
                        mPaymentResult.successPayment(data);
                        mControl.visitWebView(data);
//                        AndroidAndJSInterface mAndroidAndJSInterface=new AndroidAndJSInterface(mActivity);
//                        cardWebLayout.getWebView().addJavascriptInterface(mAndroidAndJSInterface, "Android");

                    }
                });
    }
    public static  void parseQR(Activity mActivity, ParseQRBean bean, RequestControl mControl) {
        PaymentResult mPaymentResult=new PaymentResult(mActivity);
        Map<String,String> params=ParamsTools.parseQR(bean);
        RetrofitClient.getInstance(mActivity)
                .getApiService()
                .parseQR(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {

                    private String data;

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("zt", "onSubscribe:");
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Log.i("zt", "onNext:"+value);
                        try {
                            data = value.string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.i("zt", "onError:" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.i("zt", "onComplete:");
                        mPaymentResult.successPayment(data);
                        mControl.visitWebView(data);

                    }
                });
    }











    /**
     * 对网络连接状态进行判断
     *
     * @param mContext
     * @return true, 可用； false， 不可用
     */
    public static boolean isOpenNetwork(Context mContext) {
        ConnectivityManager connManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        } else {
            Toast.makeText(mContext, "请检查你的网络连接。", Toast.LENGTH_SHORT).show();
        }
        return false;
    }



}
