package sdkdemo.kx.come.eastpay;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import sdkdemo.kx.come.easypaisa.R;
import sdkdemo.kx.come.easypaylibrary.Checkout;
import sdkdemo.kx.come.easypaylibrary.bean.base.BlAdressBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.ErrorBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.SpAdressBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.authorization.AuthorizationBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.authorization.AuthorizationResp;
import sdkdemo.kx.come.easypaylibrary.bean.base.authorization.extTL;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;

public class AuthorizationActivity extends BaseActivity {


    @BindView(R.id.sp_pay_type)
    Spinner mSpinner;

    @BindView(R.id.sp_currency)
    Spinner mSpinnerCurrency;
    @BindView(R.id.sp_ext2_1)
    Spinner mSpinnerExt21;

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

    // exttl
    @BindView(R.id.et_txt_exttl_1)
    EditText mETTextExttl1;
    @BindView(R.id.et_txt_exttl_2)
    EditText mETTextExttl2;
    @BindView(R.id.et_txt_exttl_3)
    EditText mETTextExttl3;
    @BindView(R.id.et_txt_exttl_4)
    EditText mETTextExttl4;
    @BindView(R.id.et_txt_exttl_5)
    EditText mETTextExttl5;
    @BindView(R.id.et_txt_exttl_5_1)
    EditText mETTextExttl51;

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
//    @BindView(R.id.et_sign_msg)
//    EditText mSignMsg;

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


    @BindView(R.id.et_sign_key)
    EditText mETSignKey;

    private String mPayType = "13";
    private String mCurrency = "840";
    private int mCardLevel = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mOrderNo.setText(getCurrentTime());
        mETTxt4.setText(getCurrentTime());
    }

    @OnClick(R.id.btn_confirm)
    protected void onClick() {
        setAuthorization();

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
                AuthorizationResp bean= com.alibaba.fastjson.JSONObject.parseObject(mResultMessage,AuthorizationResp.class);
                showToast(AuthorizationActivity.this,mResultMessage);
                Log.d("zt",bean.getIssuerId());
                Intent intent=new Intent(AuthorizationActivity.this,ShowDataActivity.class);
                intent.putExtra("data",bean);
                startActivity(intent);
            }

            @Override
            public void onError(String mResultMessage) {
                Log.i("zt", "onError:" + mResultMessage);
                ErrorBean errorBean= com.alibaba.fastjson.JSONObject.parseObject(mResultMessage,ErrorBean.class);
                if (errorBean.getErrorCode().equals("E3")){
                    Toast.makeText(AuthorizationActivity.this, "Repeat the order",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private AuthorizationBean setBean() {
        AuthorizationBean bean = new AuthorizationBean();
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
        blAdressBean.setState(parseViewText(mETTxtBillingAddress5));
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
        spAdressBean.setState(parseViewText(mETTxtShippingAddress5));
        // TODO: 2019-10-21 miss state
        spAdressBean.setCountry(parseViewText(mETTxtShippingAddress6));
        bean.setSpAdressBean(spAdressBean);


        bean.setPayType(mPayType);
        bean.setMerchantId(parseViewText(mMerNo));
        bean.setOrderNo(parseViewText(mOrderNo));
        bean.setExt2("");
        extTL extTLbean=new extTL();
        extTLbean.setFirstName(parseViewText(mETTextExttl2));
        extTLbean.setLastName(parseViewText(mETTextExttl1));
        extTLbean.setCardNumber(parseViewText(mETTextExttl3));
        extTLbean.setExpiryMonth(parseViewText(mETTextExttl5));
        extTLbean.setExpiryYear(parseViewText(mETTextExttl51));
        extTLbean.setCardCvv2(parseViewText(mETTextExttl4));
        bean.setExtTLbean(extTLbean);
//        bean.setExtTLbean("C64EjY5ZgJ%2FB3dkulfeae%2Bxe1h%2FQdzzDGqzK0HMqDd0pTErt28tsBUjOawMBNEtrLVvby2jewwimnQy2LxMBX3dpGbHdX6cj45j9deQhDZrm6ZZ4Muq8%2BVQhQQLkvWZbNCNuIgeoHWP2fC6S4tdcxbiu5m18hHNTtyzlpnfGp%2F0%3D&1&M&010704515311001&0.11&840&20191018174733&20191018174733&13&paygwy@test.com&13888888888&http://sd.coshine.com:80/gateway/tests/payment_result.jsp&http://sd.coshine.com:80/gateway/tests/payment_callback.jsp&0&GOODS&v1.0&ZloDcaGkb1zP9/L7LkgWDA==");
        bean.setOrderCurrency(mCurrency);
        bean.setOrderDatetime(parseViewText(mETTxt4));
        bean.setOrderAmount(parseViewText(mETTxt3));
        bean.setPickupUrl(parseViewText(mETTxt5));
        bean.setReceiveUrl(parseViewText(mETTxt6));
        bean.setPayerEmail(parseViewText(mETTxt7));
        bean.setPayerTelephone(parseViewText(mETTxt8));
        bean.setIPAdress(parseViewText(mETTxt9));
        bean.setIssuerId("M");
        bean.setLastName(parseViewText(mETTextExttl1));
        bean.setFirstName(parseViewText(mETTextExttl2));
        bean.setCardNumber(parseViewText(mETTextExttl3));
        bean.setExpiryMonth(parseViewText(mETTextExttl5));
        bean.setExpiryYear(parseViewText(mETTextExttl51));
        bean.setCardCvv2(parseViewText(mETTextExttl4));
        // TODO: 2019-10-21 miss the exttl


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
