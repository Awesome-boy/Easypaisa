package sdkdemo.kx.come.eastpay;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sdkdemo.kx.come.easypaisa.R;
import sdkdemo.kx.come.easypaylibrary.Checkout;
import sdkdemo.kx.come.easypaylibrary.bean.base.reback.VoidBean;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;
import sdkdemo.kx.come.easypaylibrary.tools.CheckoutTools;

public class VoidActivity extends BaseActivity {


    @BindView(R.id.et_sign_key)
    EditText mETSignKey;

    @BindView(R.id.et_txt_void_1)
    EditText mETTxtVoid1;
    @BindView(R.id.et_txt_void_2)
    EditText mETTxtVoid2;
    @BindView(R.id.et_txt_void_3)
    EditText mETTxtVoid3;
    @BindView(R.id.et_txt_void_4)
    EditText mETTxtVoid4;
    @BindView(R.id.et_txt_void_5)
    EditText mETTxtVoid5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_void);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mETTxtVoid2.setText(getCurrentTime());
    }

    @OnClick(R.id.btn_confirm)
    protected void onClick() {
        String originalOrder=parseViewText(mETTxtVoid5);
        if (originalOrder.equals("")||TextUtils.isEmpty(originalOrder)){
            showToast(this,getString(R.string.orignalCode));
            return;
        }
        voidRequest();
    }

    private void voidRequest() {
         VoidBean bean = setBean();
        Log.d("zt", "zt--" + bean.toString());
        Checkout.getInstance().setPayment(VoidActivity.this,CheckoutTools.REQUES_VOID, bean, new CheckoutCallback() {
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

    private VoidBean setBean() {
        VoidBean bean=new VoidBean();
        bean.setVersion("v1.0");
        bean.setSignType("0");
        bean.setOrderNo(parseViewText(mETTxtVoid2));
        bean.setMerchantId(parseViewText(mETTxtVoid1));
        bean.setOrderDatetime(parseViewText(mETTxtVoid3));
        bean.setOriginalOrderNo(parseViewText(mETTxtVoid5));
        
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
