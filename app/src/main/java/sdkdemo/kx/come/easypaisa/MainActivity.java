package sdkdemo.kx.come.easypaisa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sdkdemo.kx.come.easypaylibrary.Checkout;
import sdkdemo.kx.come.easypaylibrary.activity.WebViewActivity;
import sdkdemo.kx.come.easypaylibrary.bean.payment.BlAdressBean;
import sdkdemo.kx.come.easypaylibrary.bean.payment.PaymentBean;
import sdkdemo.kx.come.easypaylibrary.bean.payment.SpAdressBean;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;


public class MainActivity extends BaseActivity {

    private Button btn;

    @BindView(R.id.btn_payment)
    Button mBtnPayment;
    @BindView(R.id.btn_authorization)
    Button mBtnAuthorization;
    @BindView(R.id.btn_inquiry)
    Button mBtnInquiry;
    @BindView(R.id.btn_void)
    Button mBtnVoid;
    @BindView(R.id.btn_refund)
    Button mBtnRefund;
    @BindView(R.id.btn_cancellation)
    Button mBtnCancellation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        initView();

    }

//    private void initView() {
//        btn = findViewById(R.id.btn_request);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sendRequest();
//            }
//        });
//    }

    private void sendRequest() {
        PaymentBean bean = setBean();
        Log.d("zt", "zt--" + bean.toString());
        Checkout.getInstance().toCheckout(MainActivity.this, bean, new CheckoutCallback() {
            @Override
            public void onCancel(String mResultMessage) {
                Log.i("zt", "onCancel:" + mResultMessage);
            }

            @Override
            public void onSuccess(String mResultMessage) {
                Log.i("zt", "onSuccess:" + mResultMessage);

                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("data", mResultMessage);
                startActivity(intent);

            }

            @Override
            public void onError(String mResultMessage) {
                Log.i("zt", "onError:" + mResultMessage);
            }
        });
    }

    private PaymentBean setBean() {
        PaymentBean bean = new PaymentBean();
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

    @OnClick({R.id.btn_payment, R.id.btn_authorization, R.id.btn_generate_qr
            , R.id.btn_parse_qr, R.id.btn_inquiry, R.id.btn_void
            , R.id.btn_refund, R.id.btn_cancellation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_payment: {
                startActivity(PaymentActivity.class);
                break;
            }
            case R.id.btn_authorization: {

                startActivity(AuthorizationActivity.class);
                break;
            }
            case R.id.btn_generate_qr: {
                startActivity(GenerateQRActivity.class);
                break;
            }

            case R.id.btn_parse_qr: {
                startActivity(ParseQRActivity.class);
                break;
            }
            case R.id.btn_inquiry: {
                startActivity(InquiryActivity.class);
                break;
            }
            case R.id.btn_void: {
                startActivity(VoidActivity.class);
                break;
            }
            case R.id.btn_refund: {
                startActivity(RefundActivity.class);
                break;
            }
            case R.id.btn_cancellation: {
                startActivity(PreAuthorizationActivity.class);
                break;
            }
            default:
                break;

        }
    }

    private void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
