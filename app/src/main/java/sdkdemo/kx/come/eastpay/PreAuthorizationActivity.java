package sdkdemo.kx.come.eastpay;

import android.os.Bundle;
import android.text.TextUtils;
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
import sdkdemo.kx.come.easypaylibrary.bean.base.order.OrderCheckBean;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;
import sdkdemo.kx.come.easypaylibrary.tools.CheckoutTools;

public class PreAuthorizationActivity extends BaseActivity {

    @BindView(R.id.sp_pay_type)
    Spinner mSpinner;

    private String mAction = "confirm";

    @BindView(R.id.et_sign_key)
    EditText mETSignKey;
    @BindView(R.id.et_txt_pre_authorization_1)
    EditText mETTxtPreAuthorization1;
    @BindView(R.id.et_txt_pre_authorization_2)
    EditText mETTxtPreAuthorization2;
    @BindView(R.id.et_txt_pre_authorization_5)
    EditText mETTxtPreAuthorization5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_authorization);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mETTxtPreAuthorization5.setText(getCurrentTime());
    }

    @OnClick(R.id.btn_confirm)
    protected void onClick() {
       String orderNo= parseViewText(mETTxtPreAuthorization2);
        if (orderNo.equals("")||TextUtils.isEmpty(orderNo)){
            showToast(this,getString(R.string.orderNo));
            return;
        }
        sendRequest();
    }

    @OnItemSelected(R.id.sp_pay_type)
    protected void onItemSelected(View view, int position) {
        String[] actions = getResources().getStringArray(R.array.action);
        mAction = actions[position];
    }


    private void sendRequest() {
        OrderCheckBean bean = setBean();
        Checkout.getInstance().setPayment(PreAuthorizationActivity.this,CheckoutTools.REQUES_PREAUTH, bean, new CheckoutCallback() {
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

    private OrderCheckBean setBean() {
        OrderCheckBean bean=new OrderCheckBean();
        bean.setVersion("v1.0");
        bean.setSignType("0");
        bean.setOrderNo(parseViewText(mETTxtPreAuthorization2));
        bean.setMerchantId(parseViewText(mETTxtPreAuthorization1));
        bean.setAction(mAction);
        bean.setCheckDatetime(parseViewText(mETTxtPreAuthorization5));
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
