package sdkdemo.kx.come.easypaisa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sdkdemo.kx.come.easypaylibrary.Checkout;
import sdkdemo.kx.come.easypaylibrary.activity.WebViewActivity;
import sdkdemo.kx.come.easypaylibrary.bean.base.authorization.AuthorizationBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.query.QueryBean;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;

public class InquiryActivity extends BaseActivity {

    @BindView(R.id.et_sign_key)
    EditText mETSignKey;

    @BindView(R.id.et_txt_inquiry_1)
    EditText mETTxtInquiry1;
    @BindView(R.id.et_txt_inquiry_2)
    EditText mETTxtInquiry2;
    @BindView(R.id.et_txt_inquiry_3)
    EditText mETTxtInquiry3;
    @BindView(R.id.et_txt_inquiry_4)
    EditText mETTxtInquiry4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_confirm)
    protected void onClick() {
        sendRequest();
    }

    private void sendRequest() {
        QueryBean bean = setBean();
        Log.d("zt", "zt--" + bean.toString());
        Checkout.getInstance().queryResult(InquiryActivity.this, bean, new CheckoutCallback() {
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

    private QueryBean setBean() {
        QueryBean bean=new QueryBean();
        bean.setVersion("v1.0");
        bean.setSignType("0");
        bean.setOrderNo(parseViewText(mETTxtInquiry2));
        bean.setMerchantId(parseViewText(mETTxtInquiry1));
        bean.setOrderDatetime(parseViewText(mETTxtInquiry3));
        bean.setQueryDatetime(parseViewText(mETTxtInquiry4));
        bean.setSecretKey(parseViewText(mETSignKey));
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
