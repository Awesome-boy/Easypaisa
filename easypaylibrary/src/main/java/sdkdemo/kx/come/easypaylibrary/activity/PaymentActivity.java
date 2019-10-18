package sdkdemo.kx.come.easypaylibrary.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;


import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import androidx.collection.ArrayMap;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import sdkdemo.kx.come.easypaylibrary.bean.payment.PaymentBean;
import sdkdemo.kx.come.easypaylibrary.httpService.RetrofitClient;
import sdkdemo.kx.come.easypaylibrary.interfaces.PaymentResult;
import sdkdemo.kx.come.easypaylibrary.layout.CardWebLayout;
import sdkdemo.kx.come.easypaylibrary.tools.CheckoutTools;

/**
 * Created by xief on 2018/6/12.
 */

public final class PaymentActivity extends Activity {

    private CardWebLayout customerLayout;
    private PaymentResult mPaymentResult;
    private boolean popupwindowDisplayKey = true;
    private PaymentBean bean;
    private Map<String,String> params;


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
        bean = (PaymentBean) getIntent().getSerializableExtra(CheckoutTools.INFO);
        mPaymentResult = new PaymentResult(PaymentActivity.this);
        params = setParams();
        initListener();

    }

    private Map<String,String> setParams() {
        Map<String, String> params = new ArrayMap<>();
        if (bean!=null){
            params.put("inputCharset", bean.getInputCharset());
            params.put("version", bean.getVersion());
            params.put("signType", String.valueOf(bean.getSignType()));
            params.put("tradeNature",bean.getTradeNature()  );
            params.put("billingAddress",  JSON.toJSONString(bean.getBlAdressBean()));
            params.put("shippingAddress", JSON.toJSONString(bean.getSpAdressBean()) );
            params.put("signMsg", bean.getSignMsg() );
            params.put("payType", String.valueOf(bean.getPayType()));
            params.put("merchantId", bean.getMerchantId() );
            params.put("orderNo", bean.getOrderNo() );
            params.put("orderCurrency", bean.getOrderCurrency() );
            params.put("orderAmount", bean.getOrderAmount() );
            params.put("orderDatetime",bean.getOrderDatetime()  );
            params.put("pickupUrl", bean.getPickupUrl() );
            params.put("receiveUrl", bean.getReceiveUrl() );
            params.put("payerEmail", bean.getPayerEmail() );
            params.put("payerTelephone",bean.getPayerTelephone()  );
            params.put("IPAddress", bean.getIPAdress() );
            params.put("crdLvl", String.valueOf(bean.getCrdLvl()));
            params.put("taxAmt", String.valueOf(bean.getTaxAmt()));
            params.put("custCd", String.valueOf(bean.getCustCd()));
            params.put("mchPostCd", String.valueOf(bean.getMchPostCd()));
            params.put("taxId", String.valueOf(bean.getTaxId()));
            params.put("mchMinorityCd",  String.valueOf(bean.getMchMinorityCd()));
            params.put("mchStateCd",  String.valueOf(bean.getMchStateCd()));
            params.put("shipPostCd",  String.valueOf(bean.getShipPostCd()));
            params.put("destPostCd", String.valueOf(bean.getDestPostCd()) );
            params.put("invoiceNum",  String.valueOf(bean.getInvoiceNum()));
            params.put("freightAmt", String.valueOf(bean.getFreightAmt()) );
            params.put("dutyAmt", String.valueOf(bean.getDutyAmt()) );
            params.put("secretKey", bean.getSecretKey() );
        }
        return params;
    }

    @Override
    public void onBackPressed() {
//        CardClient.setHttpKey(false);
//        mPaymentResult.cancelPayment(String.valueOf(mAssembly.getData().get("transactionId")));
    }


    private void initListener() {
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        if (popupwindowDisplayKey) {
                            popupwindowDisplayKey = false;
                            RetrofitClient.getInstance(PaymentActivity.this)
                                    .getApiService()
                                    .getOrder(params)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Observer<ResponseBody>() {
                                        @Override
                                        public void onSubscribe(Disposable d) {
                                            Log.i("zt", "onSubscribe:");
                                        }

                                        @Override
                                        public void onNext(ResponseBody value) {
                                            Log.i("zt", "onNext:" + value);
                                            mPaymentResult.successPayment(value);
                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            Log.i("zt", "onError:" + e);
                                        }

                                        @Override
                                        public void onComplete() {
                                            Log.i("zt", "onComplete:");

                                        }
                                    });
                        }
                    }
                });
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
