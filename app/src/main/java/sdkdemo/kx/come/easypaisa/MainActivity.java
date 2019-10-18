package sdkdemo.kx.come.easypaisa;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import sdkdemo.kx.come.easypaylibrary.Checkout;
import sdkdemo.kx.come.easypaylibrary.bean.payment.BlAdressBean;
import sdkdemo.kx.come.easypaylibrary.bean.payment.PaymentBean;
import sdkdemo.kx.come.easypaylibrary.bean.payment.SpAdressBean;
import sdkdemo.kx.come.easypaylibrary.bean.payment.ext2;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;


public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        btn = findViewById(R.id.btn_request);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();
            }
        });
    }

    private void sendRequest() {
        PaymentBean bean= setBean();;
        Checkout.getInstance().toCheckout(MainActivity.this, bean, new CheckoutCallback() {
            @Override
            public void onCancel(String mResultMessage) {
                Log.i("zt","onCancel:"+mResultMessage);
            }

            @Override
            public void onSuccess(ResponseBody mResultMessage) {
                Log.i("zt","onSuccess:"+mResultMessage);
            }

            @Override
            public void onError(String mResultMessage) {
                Log.i("zt","onError:"+mResultMessage);
            }
        });
    }

    private PaymentBean setBean() {
        PaymentBean bean=new PaymentBean();
        bean.setInputCharset(1);
        bean.setVersion("v1.0");
        bean.setSignType(0);
        bean.setTradeNature("GOODS");

        BlAdressBean blAdressBean=new BlAdressBean();
        blAdressBean.setFirstName("john");
        blAdressBean.setLastName("connor");
        blAdressBean.setAddress1("Muster Str. 12");
        blAdressBean.setAddress2("");
        blAdressBean.setZipCode("10178");
        blAdressBean.setCity("Los Angeles");
        blAdressBean.setCountry("US");

        bean.setBlAdressBean(blAdressBean);

        SpAdressBean spAdressBean=new SpAdressBean();
        spAdressBean.setFirstName("john");
        spAdressBean.setLastName("connor");
        spAdressBean.setAddress1("Muster Str. 12");
        spAdressBean.setAddress2("");
        spAdressBean.setZipCode("10178");
        spAdressBean.setCity("Los Angeles");
        spAdressBean.setCountry("US");
        bean.setSpAdressBean(spAdressBean);
//orderNo	20191017134537
//orderCurrency	840
//orderAmount	0.11
//orderDatetime	20191017134537
//pickupUrl	http://sd.coshine.com:80/gateway/tests/payment_result.jsp
//receiveUrl	http://sd.coshine.com:80/gateway/tests/payment_callback.jsp
//payerEmail	paygwy@test.com
//payerTelephone	13888888888
//IPAddress	113.246.97.101
        bean.setSignMsg("8f0e5fd0b3797194f27f0f547dcf9e0c");
        bean.setPayType(13);
        bean.setMerchantId("010704515311001");
        bean.setOrderNo("20191017134537");
        bean.setOrderCurrency("840");
        bean.setOrderDatetime("20191017134537");
        bean.setOrderAmount("0.11");
        bean.setPickupUrl("http://sd.coshine.com:80/gateway/tests/payment_result.jsp");
        bean.setReceiveUrl("http://sd.coshine.com:80/gateway/tests/payment_callback.jsp");
        bean.setPayerEmail("paygwy@test.com");
        bean.setPayerTelephone("13888888888");
        bean.setIPAdress("113.246.97.101");
        //crdLvl	1
        //taxAmt	1
        //custCd	1
        //mchPostCd	1
        //taxId	1
        //mchMinorityCd	1
        //mchStateCd	1
        //shipPostCd	1
        //destPostCd	1
        //invoiceNum	1
        //freightAmt	1
        //dutyAmt	1
        ext2 ext=new ext2();
        ext.setCrdLvl(1);
        ext.setTaxAmt(1);
        ext.setCustCd(1);
        ext.setMchPostCd(1);
        ext.setTaxId(1);
        ext.setMchMinorityCd(1);
        ext.setMchStateCd(1);
        ext.setShipPostCd(1);
        ext.setDestPostCd(1);
        ext.setInvoiceNum(1);
        ext.setFreightAmt(1);
        ext.setDutyAmt(1);
        bean.setExt(ext);

        return  bean;
    }
}
