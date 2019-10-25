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
import sdkdemo.kx.come.easypaylibrary.bean.base.refund.RefundBean;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;
import sdkdemo.kx.come.easypaylibrary.tools.CheckoutTools;

public class RefundActivity extends BaseActivity {

    @BindView(R.id.et_sign_key)
    EditText mETSignKey;

    @BindView(R.id.et_txt_refund_1)
    EditText mETTxtRefund1;
    @BindView(R.id.et_txt_refund_2)
    EditText mETTxtRefund2;
    @BindView(R.id.et_txt_refund_3)
    EditText mETTxtRefund3;
    @BindView(R.id.et_txt_refund_4)
    EditText mETTxtRefund4;
    @BindView(R.id.et_txt_refund_5)
    EditText mETTxtRefund5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_confirm)
    protected void onClick() {
        String originalOrder=parseViewText(mETTxtRefund5);
        if (originalOrder.equals("")||TextUtils.isEmpty(originalOrder)){
            showToast(this,getString(R.string.orignalCode));
            return;
        }
        refundRequest();
    }

    private void refundRequest() {
        RefundBean bean = setBean();
        Log.d("zt", "zt--" + bean.toString());
        Checkout.getInstance().setPayment(RefundActivity.this,CheckoutTools.REQUES_REFUND, bean, new CheckoutCallback() {
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

    private RefundBean setBean() {
        RefundBean bean=new RefundBean();
        bean.setVersion("v1.0");
        bean.setSignType("0");
        bean.setOrderNo(parseViewText(mETTxtRefund2));
        bean.setMerchantId(parseViewText(mETTxtRefund1));
        bean.setOrderDatetime(parseViewText(mETTxtRefund3));
        bean.setRefundAmount(parseViewText(mETTxtRefund4));
        bean.setOriginalOrderNo(parseViewText(mETTxtRefund5));
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
