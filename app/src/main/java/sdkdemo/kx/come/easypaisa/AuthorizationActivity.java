package sdkdemo.kx.come.easypaisa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.OnClick;
import sdkdemo.kx.come.easypaylibrary.Checkout;
import sdkdemo.kx.come.easypaylibrary.activity.WebViewActivity;
import sdkdemo.kx.come.easypaylibrary.bean.base.BlAdressBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.SpAdressBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.authorization.AuthorizationBean;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;

public class AuthorizationActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_confirm)
    protected void onClick() {
        setAuthorization();

    }

    private void setAuthorization() {
        AuthorizationBean bean = setBean();
        Log.d("zt", "zt--" + bean.toString());
        Checkout.getInstance().setAuthorization(AuthorizationActivity.this, bean, new CheckoutCallback() {
            @Override
            public void onCancel(String mResultMessage) {
                Log.i("zt", "onCancel:" + mResultMessage);
            }

            @Override
            public void onSuccess(String mResultMessage) {
                Log.i("zt", "onSuccess:" + mResultMessage);
                Intent intent = new Intent(AuthorizationActivity.this, WebViewActivity.class);
                intent.putExtra("data", mResultMessage);
                startActivity(intent);

            }

            @Override
            public void onError(String mResultMessage) {
                Log.i("zt", "onError:" + mResultMessage);
            }
        });
    }

    private AuthorizationBean setBean() {
        AuthorizationBean bean = new AuthorizationBean();
        bean.setInputCharset("1");

        bean.setVersion("v1.0");
        bean.setSignType(0);
        bean.setTradeNature("GOODS");

        BlAdressBean blAdressBean = new BlAdressBean();
        blAdressBean.setFirstName("john");
        blAdressBean.setLastName("connor");
        blAdressBean.setAddress1("Muster Str. 12");
        blAdressBean.setAddress2("");
        blAdressBean.setZipCode("10178");
        blAdressBean.setCity("Los Angeles");
        blAdressBean.setCountry("US");

        bean.setBlAdressBean(blAdressBean);

        SpAdressBean spAdressBean = new SpAdressBean();
        spAdressBean.setFirstName("john");
        spAdressBean.setLastName("connor");
        spAdressBean.setAddress1("Muster Str. 12");
        spAdressBean.setAddress2("");
        spAdressBean.setZipCode("10178");
        spAdressBean.setCity("Los Angeles");
        spAdressBean.setCountry("US");
        bean.setSpAdressBean(spAdressBean);

        bean.setSignMsg("8f0e5fd0b3797194f27f0f547dcf9e0c");
        bean.setPayType(13);
        bean.setMerchantId("010704515311001");
        bean.setOrderNo("20191017134539");
        bean.setExtTL("C64EjY5ZgJ%2FB3dkulfeae%2Bxe1h%2FQdzzDGqzK0HMqDd0pTErt28tsBUjOawMBNEtrLVvby2jewwimnQy2LxMBX3dpGbHdX6cj45j9deQhDZrm6ZZ4Muq8%2BVQhQQLkvWZbNCNuIgeoHWP2fC6S4tdcxbiu5m18hHNTtyzlpnfGp%2F0%3D");
        bean.setOrderCurrency("840");
        bean.setOrderDatetime("20191017134537");
        bean.setOrderAmount("0.11");
        bean.setPickupUrl("http://sd.coshine.com:80/gateway/tests/payment_result.jsp");
        bean.setReceiveUrl("http://sd.coshine.com:80/gateway/tests/payment_callback.jsp");
        bean.setPayerEmail("paygwy@test.com");
        bean.setPayerTelephone("13888888888");
        bean.setIPAdress("113.246.97.101");


        bean.setCrdLvl(1);
        bean.setTaxAmt(1);
        bean.setCustCd(1);
        bean.setMchPostCd(1);
        bean.setTaxId(1);
        bean.setMchMinorityCd(1);
        bean.setMchStateCd(1);
        bean.setShipPostCd(1);
        bean.setDestPostCd(1);
        bean.setInvoiceNum(1);
        bean.setFreightAmt(1);
        bean.setDutyAmt(1);
        bean.setSecretKey("ZloDcaGkb1zP9/L7LkgWDA==");
        return bean;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
