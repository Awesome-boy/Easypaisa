package sdkdemo.kx.come.easypaylibrary.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;


import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.Map;

import androidx.collection.ArrayMap;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import sdkdemo.kx.come.easypaylibrary.Checkout;
import sdkdemo.kx.come.easypaylibrary.bean.base.authorization.AuthorizationBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.genQR.GenQRBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.order.OrderCheckBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.parseQRBean.ParseQRBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.payment.PaymentBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.query.QueryBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.reback.VoidBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.refund.RefundBean;
import sdkdemo.kx.come.easypaylibrary.control.RequestControl;
import sdkdemo.kx.come.easypaylibrary.httpService.RetrofitClient;
import sdkdemo.kx.come.easypaylibrary.interfaces.Callback;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;
import sdkdemo.kx.come.easypaylibrary.interfaces.PaymentResult;
import sdkdemo.kx.come.easypaylibrary.layout.CardWebLayout;
import sdkdemo.kx.come.easypaylibrary.layout.CustomPopupWindow;
import sdkdemo.kx.come.easypaylibrary.tools.CheckoutTools;
import sdkdemo.kx.come.easypaylibrary.tools.ParamsTools;


/**
 * Created by xief on 2018/6/12.
 */

public final class PaymentActivity extends Activity {

    private CardWebLayout customerLayout;
    private PaymentResult mPaymentResult;
    private boolean popupwindowDisplayKey = true;
    private Object bean;
    private String type;
    private Activity activity;
    private RequestControl mControl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        customerLayout = new CardWebLayout();
        setContentView(customerLayout.createView(PaymentActivity.this));
        init();
    }

    private void init() {
        type = getIntent().getStringExtra(CheckoutTools.TYPE);
        bean =  getIntent().getSerializableExtra(CheckoutTools.INFO);
        CustomPopupWindow customPopupWindow=new CustomPopupWindow(PaymentActivity.this);
        mPaymentResult = new PaymentResult(PaymentActivity.this);
        mControl = new RequestControl(customPopupWindow,customerLayout,mPaymentResult);
        activity=PaymentActivity.this;
        initListener();

    }


    @Override
    public void onBackPressed() {
        this.finish();
        this.overridePendingTransition(0, android.R.anim.fade_out);
        mPaymentResult.cancelPayment("");
    }


    private void initListener() {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        if (popupwindowDisplayKey) {
                            popupwindowDisplayKey = false;
                            sendPaymentQuest(type,bean,mControl);

                        }
                    }
                });
    }

    private void sendPaymentQuest(String type, Object bean,RequestControl mControl) {
        switch (type){
            case CheckoutTools.REQUES_PAY:
                PaymentBean paymentBean= (PaymentBean) bean;
                Checkout.sendPaymentQuest(activity,paymentBean,mControl);
                break;
            case CheckoutTools.REQUES_GEN:
                GenQRBean genQRBean= (GenQRBean) bean;
                Checkout.genQR(activity,genQRBean,mControl);
                break;
            case CheckoutTools.REQUES_PARSE:
                ParseQRBean parseQRBean= (ParseQRBean) bean;
                Checkout.parseQR(activity,parseQRBean,mControl);
                break;
            case CheckoutTools.REQUES_INQURY:
                QueryBean queryBean= (QueryBean) bean;
                Checkout.queryResult(activity,queryBean,mControl);
                break;
            case CheckoutTools.REQUES_REFUND:
                RefundBean refundBean= (RefundBean) bean;
                Checkout.refundResult(activity,refundBean,mControl);
                break;
            case CheckoutTools.REQUES_VOID:
                VoidBean voidBean= (VoidBean) bean;
                Checkout.reback(activity,voidBean,mControl);
                break;
            case CheckoutTools.REQUES_PREAUTH:
                OrderCheckBean orderCheckBean= (OrderCheckBean) bean;
                Checkout.orderCheck(activity,orderCheckBean,mControl);
                break;
        }
    }



    @Override
    public void onPause() {
        super.onPause();
        customerLayout.getWebView().onPause();
        customerLayout.getWebView().pauseTimers();
    }

    @Override
    public void onResume() {
        super.onResume();
        customerLayout.getWebView().resumeTimers();
        customerLayout.getWebView().onResume();
    }

    @Override
    protected void onDestroy() {
        customerLayout.destroyWebView();
        super.onDestroy();
        mPaymentResult = null;
    }
}