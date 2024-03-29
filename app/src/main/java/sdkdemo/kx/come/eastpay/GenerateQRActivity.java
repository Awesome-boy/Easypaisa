package sdkdemo.kx.come.eastpay;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import sdkdemo.kx.come.easypaisa.R;
import sdkdemo.kx.come.easypaylibrary.Checkout;
import sdkdemo.kx.come.easypaylibrary.bean.base.genQR.GenQRBean;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;
import sdkdemo.kx.come.easypaylibrary.tools.CheckoutTools;

public class GenerateQRActivity extends BaseActivity {


    @BindView(R.id.sp_pay_type)
    Spinner mSpinnerCurrency;

    private String mCurrency = "USD";

    @BindView(R.id.et_sign_key)
    EditText mETSignKey;

    @BindView(R.id.et_txt_gen_qr_1)
    EditText mETTxtGenQR1;
    @BindView(R.id.et_txt_gen_qr_2)
    EditText mETTxtGenQR2;
    @BindView(R.id.et_txt_gen_qr_5)
    EditText mETTxtGenQR5;
    @BindView(R.id.et_txt_gen_qr_6)
    EditText mETTxtGenQR6;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mETTxtGenQR2.setText(getCurrentTime());
        mETTxtGenQR6.setText(getCurrentTime());
    }

    @OnClick(R.id.btn_confirm)
    protected void onClick() {
        sendRequest();

    }

    private void sendRequest() {
        GenQRBean bean = setBean();
        Checkout.getInstance().setPayment(GenerateQRActivity.this,CheckoutTools.REQUES_GEN, bean, new CheckoutCallback() {
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

    private GenQRBean setBean() {
        GenQRBean bean = new GenQRBean();
        bean.setSignType("0");
        bean.setVersion("v1.0");
        bean.setMerchantId(parseViewText(mETTxtGenQR1));
        bean.setOrderDatetime(parseViewText(mETTxtGenQR6));
        bean.setOrderNo(parseViewText(mETTxtGenQR2));
        bean.setCurrency(mCurrency);
        bean.setAmount(parseViewText(mETTxtGenQR5));

//        bean.setSecretKey(parseViewText(mETSignKey));

        bean.setSecretKey("ZloDcaGkb1zP9%2FL7LkgWDA%3D%3D");
        return bean;

    }

    @OnItemSelected(R.id.sp_pay_type)
    protected void onItemSelected(View view, int position) {
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
