package sdkdemo.kx.come.easypaisa;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
