package sdkdemo.kx.come.easypaisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


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
