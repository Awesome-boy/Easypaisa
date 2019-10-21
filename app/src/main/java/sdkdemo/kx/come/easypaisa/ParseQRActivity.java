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
import sdkdemo.kx.come.easypaylibrary.bean.base.parseQRBean.ParseQRBean;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;

public class ParseQRActivity extends BaseActivity {

    @BindView(R.id.et_sign_key)
    EditText mETSignKey;

    @BindView(R.id.et_txt_parse_qr_1)
    EditText mETTxtParseQR1;
    @BindView(R.id.et_txt_parse_qr_2)
    EditText mETTxtParseQR2;
    @BindView(R.id.et_txt_parse_qr_3)
    EditText mETTxtParseQR3;
    @BindView(R.id.et_txt_parse_qr_5)
    EditText mETTxtParseQR5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_qr);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_confirm)
    protected void onClick() {
        sendRequest();

    }

    private void sendRequest() {
        ParseQRBean bean=setBean();
        Checkout.getInstance().parseQR(ParseQRActivity.this, bean, new CheckoutCallback() {
            @Override
            public void onCancel(String mResultMessage) {
                Log.i("zt", "onCancel:" + mResultMessage);
            }

            @Override
            public void onSuccess(String mResultMessage) {
                Log.i("zt", "onSuccess:" + mResultMessage);
                Intent intent = new Intent(ParseQRActivity.this, WebViewActivity.class);
                intent.putExtra("data", mResultMessage);
                startActivity(intent);

            }

            @Override
            public void onError(String mResultMessage) {
                Log.i("zt", "onError:" + mResultMessage);
            }
        });
    }

    private ParseQRBean setBean() {
        ParseQRBean bean=new ParseQRBean();
        bean.setSignType("0");
        bean.setVersion("v1.0");
        bean.setMerchantId(parseViewText(mETTxtParseQR1));
        bean.setOrderDatetime(parseViewText(mETTxtParseQR5));
        bean.setTerminalId(parseViewText(mETTxtParseQR2));

        //00020101021204150107045153110015204531153038405405998.05802NG5919Circle+Trade+Co+Ltd6012Lagos+Island61064200006237011420191021095154061501070451531100164450002ZH0119Circle+Trade+Co+Ltd0212Lagos+Island6304B441
        bean.setQRcode(parseViewText(mETTxtParseQR3));
//        bean.setQRcode("00020101021204150107045153110015204531153038405405998.05802NG5919Circle+Trade+Co+Ltd6012Lagos+Island61064200006237011420191021095154061501070451531100164450002ZH0119Circle+Trade+Co+Ltd0212Lagos+Island6304B441");
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
