package sdkdemo.kx.come.easypaisa;

import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import sdkdemo.kx.come.easypaylibrary.Checkout;
import sdkdemo.kx.come.easypaylibrary.bean.base.BlAdressBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.SpAdressBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.payment.PaymentBean;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;
import sdkdemo.kx.come.easypaylibrary.tools.CheckoutTools;

public class ThreeDSecurePaymentActivity extends BaseActivity {

    @BindView(R.id.sp_pay_type)
    Spinner mSpinner;
    @BindView(R.id.sp_currency)
    Spinner mSpinnerCurrency;
    @BindView(R.id.sp_ext2_1)
    Spinner mSpinnerExt21;

    private String mPayType = "13";
    private String mCurrency = "840";
    private int mCardLevel = 1;

    @BindView(R.id.et_sign_key)
    EditText mETSignKey;

    // payment
    @BindView(R.id.et_mer_no)
    EditText mMerNo;
    @BindView(R.id.et_order_no)
    EditText mOrderNo;
    @BindView(R.id.et_txt_3)
    EditText mETTxt3;
    @BindView(R.id.et_txt_4)
    EditText mETTxt4;
    @BindView(R.id.et_txt_5)
    EditText mETTxt5;
    @BindView(R.id.et_txt_6)
    EditText mETTxt6;
    @BindView(R.id.et_txt_7)
    EditText mETTxt7;
    @BindView(R.id.et_txt_8)
    EditText mETTxt8;
    @BindView(R.id.et_txt_9)
    EditText mETTxt9;

    // ext2
    @BindView(R.id.et_ext2_1)
    EditText mETTxtExt1;
    @BindView(R.id.et_ext_2)
    EditText mETTxtExt2;
    @BindView(R.id.et_txt_ext_3)
    EditText mETTxtExt3;
    @BindView(R.id.et_txt_ext_4)
    EditText mETTxtExt4;
    @BindView(R.id.et_txt_ext_5)
    EditText mETTxtExt5;
    @BindView(R.id.et_txt_ext_6)
    EditText mETTxtExt6;
    @BindView(R.id.et_txt_ext_7)
    EditText mETTxtExt7;
    @BindView(R.id.et_txt_ext_8)
    EditText mETTxtExt8;
    @BindView(R.id.et_txt_ext_9)
    EditText mETTxtExt9;
    @BindView(R.id.et_txt_ext_10)
    EditText mETTxtExt10;
    @BindView(R.id.et_txt_ext_11)
    EditText mETTxtExt11;
    @BindView(R.id.et_txt_ext_12)
    EditText mETTxtExt12;

    // shipping address
    @BindView(R.id.et_shipping_address_1)
    EditText mETTxtShippingAddress1;
    @BindView(R.id.et_shipping_address_2)
    EditText mETTxtShippingAddress2;
    @BindView(R.id.et_txt_shipping_address_3)
    EditText mETTxtShippingAddress3;
    @BindView(R.id.et_txt_shipping_address_4)
    EditText mETTxtShippingAddress4;
    @BindView(R.id.et_txt_shipping_address_5)
    EditText mETTxtShippingAddress5;
    @BindView(R.id.et_txt_shipping_address_6)
    EditText mETTxtShippingAddress6;
    @BindView(R.id.et_txt_shipping_address_7)
    EditText mETTxtShippingAddress7;
    @BindView(R.id.et_txt_shipping_address_8)
    EditText mETTxtShippingAddress8;

    // billing address
    @BindView(R.id.et_billing_address_1)
    EditText mETTxtBillingAddress1;
    @BindView(R.id.et_billing_address_2)
    EditText mETTxtBillingAddress2;
    @BindView(R.id.et_txt_billing_address_3)
    EditText mETTxtBillingAddress3;
    @BindView(R.id.et_txt_billing_address_4)
    EditText mETTxtBillingAddress4;
    @BindView(R.id.et_txt_billing_address_5)
    EditText mETTxtBillingAddress5;
    @BindView(R.id.et_txt_billing_address_6)
    EditText mETTxtBillingAddress6;
    @BindView(R.id.et_txt_billing_address_7)
    EditText mETTxtBillingAddress7;
    @BindView(R.id.et_txt_billing_address_8)
    EditText mETTxtBillingAddress8;


    @BindView(R.id.sv_payment)
    ScrollView mSvPayment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mSvPayment.setVisibility(View.VISIBLE);
        mOrderNo.setText(getCurrentTime());
        mETTxt4.setText(getCurrentTime());
    }

    @OnClick(R.id.btn_confirm)
    protected void onClick() {
        sendRequest();
        mSvPayment.setVisibility(View.GONE);
    }

    private void sendRequest() {
        PaymentBean bean = setBean();
        Log.d("zt", "zt--" + bean.toString());
        Checkout.getInstance().setPayment(ThreeDSecurePaymentActivity.this,CheckoutTools.REQUES_PAY, bean, new CheckoutCallback() {
            @Override
            public void onCancel(String mResultMessage) {
                Log.i("zt", "onCancel:" + mResultMessage);
            }

            @Override
            public void onSuccess(String mResultMessage) {
                Log.i("zt", "onSuccess:" + mResultMessage);

            }

            @Override
            public void onError(String mResultMessage) {
                Log.i("zt", "onError:" + mResultMessage);
            }
        });

    }



    @OnItemSelected({R.id.sp_pay_type, R.id.sp_currency, R.id.sp_ext2_1})
    protected void onItemSelected(View view, int position) {

        switch (view.getId()) {

            case R.id.sp_pay_type: {
                String[] paytypes = getResources().getStringArray(R.array.paymenttype);
                mPayType = paytypes[position].substring(0, 2);
                break;
            }
            case R.id.sp_currency: {


                /**
                 * <option value="840">USD - US dollars</option>
                 * <option value="643">RUB - Russian ruble</option>
                 *  <option value="978">EUR - Euro</option>
                 */
                switch (position) {
                    case 0: {
                        mCurrency = "840";
                        break;
                    }
                    case 1: {
                        mCurrency = "643";
                        break;
                    }
                    case 2: {
                        mCurrency = "978";
                        break;
                    }
                }
                break;
            }
            case R.id.sp_ext2_1: {

                String[] cardLevels = getResources().getStringArray(R.array.card_level);
                mCardLevel = position + 1;
            }
        }


    }

    private PaymentBean setBean() {
        PaymentBean bean = new PaymentBean();
        bean.setInputCharset("1");
        bean.setVersion("v1.0");
        bean.setSignType("0");
        bean.setTradeNature("GOODS");

        BlAdressBean blAdressBean = new BlAdressBean();
        blAdressBean.setFirstName(parseViewText(mETTxtBillingAddress1));
        blAdressBean.setLastName(parseViewText(mETTxtBillingAddress7));
        blAdressBean.setAddress1(parseViewText(mETTxtBillingAddress2));
        blAdressBean.setAddress2(parseViewText(mETTxtBillingAddress8));
        blAdressBean.setZipCode(parseViewText(mETTxtBillingAddress3));
        blAdressBean.setCity(parseViewText(mETTxtBillingAddress4));
        // TODO: 2019-10-21 miss state
        blAdressBean.setCountry(parseViewText(mETTxtBillingAddress6));

        bean.setBlAdressBean(blAdressBean);

        SpAdressBean spAdressBean = new SpAdressBean();
        spAdressBean.setFirstName(parseViewText(mETTxtShippingAddress1));
        spAdressBean.setLastName(parseViewText(mETTxtShippingAddress7));
        spAdressBean.setAddress1(parseViewText(mETTxtShippingAddress2));
        spAdressBean.setAddress2(parseViewText(mETTxtShippingAddress8));
        spAdressBean.setZipCode(parseViewText(mETTxtShippingAddress3));
        spAdressBean.setCity(parseViewText(mETTxtShippingAddress4));
        // TODO: 2019-10-21 miss state
        spAdressBean.setCountry(parseViewText(mETTxtShippingAddress6));
        bean.setSpAdressBean(spAdressBean);

        bean.setPayType(mPayType);
        bean.setMerchantId(parseViewText(mMerNo));
        bean.setOrderNo(parseViewText(mOrderNo));
        bean.setOrderCurrency(mCurrency);
        bean.setOrderDatetime(parseViewText(mETTxt4));
        bean.setOrderAmount(parseViewText(mETTxt3));
        bean.setPickupUrl(parseViewText(mETTxt5));
        bean.setReceiveUrl(parseViewText(mETTxt6));
        bean.setPayerEmail(parseViewText(mETTxt7));
        bean.setPayerTelephone(parseViewText(mETTxt8));
        bean.setIPAdress(parseViewText(mETTxt9));


        // ext2
        bean.setCrdLvl(mCardLevel);
        bean.setTaxAmt(parseToInt(mETTxtExt1));
        bean.setCustCd(parseToInt(mETTxtExt2));
        bean.setMchPostCd(parseToInt(mETTxtExt11));
        bean.setTaxId(parseToInt(mETTxtExt3));
        bean.setMchMinorityCd(parseToInt(mETTxtExt4));
        bean.setMchStateCd(parseToInt(mETTxtExt5));
        bean.setShipPostCd(parseToInt(mETTxtExt6));
        bean.setDestPostCd(parseToInt(mETTxtExt7));
        bean.setInvoiceNum(parseToInt(mETTxtExt8));
        bean.setFreightAmt(parseToInt(mETTxtExt9));
        bean.setDutyAmt(parseToInt(mETTxtExt10));

        // TODO: 2019-10-21 miss the order item
        bean.setSecretKey(parseViewText(mETSignKey));

        // payment
        bean.setSignMsg("8f0e5fd0b3797194f27f0f547dcf9e0c");
        return bean;
    }

    @OnClick(R.id.iv_back)
    protected void onBackClick() {
        onBackPressed();
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
