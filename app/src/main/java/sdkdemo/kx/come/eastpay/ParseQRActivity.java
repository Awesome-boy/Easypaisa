package sdkdemo.kx.come.eastpay;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sdkdemo.kx.come.easypaisa.R;
import sdkdemo.kx.come.easypaylibrary.Checkout;
import sdkdemo.kx.come.easypaylibrary.bean.base.parseQRBean.ParseQRBean;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;
import sdkdemo.kx.come.easypaylibrary.tools.CheckoutTools;

public class ParseQRActivity extends BaseActivity implements View.OnClickListener {

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
    @BindView(R.id.btn_scan)
    Button btn_scan;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_qr);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        btn_scan.setOnClickListener(this);
    }

    @OnClick(R.id.btn_confirm)
    protected void onClick() {
        String qrData=parseViewText(mETTxtParseQR3);
        if (qrData.equals("")||TextUtils.isEmpty(qrData)){
            showToast(this,getString(R.string.qrCode));
            return;
        }
        sendRequest();

    }


    private void sendRequest() {
        ParseQRBean bean=setBean();
        Checkout.getInstance().setPayment(ParseQRActivity.this,CheckoutTools.REQUES_PARSE, bean, new CheckoutCallback() {
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

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.btn_scan:
                requsetPermission();
                break;
        }
    }
    private void requsetPermission(){
        if (Build.VERSION.SDK_INT>22){
            if (ContextCompat.checkSelfPermission(ParseQRActivity.this,
                    android.Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                //先判断有没有权限 ，没有就在这里进行权限的申请
                ActivityCompat.requestPermissions(ParseQRActivity.this,
                        new String[]{android.Manifest.permission.CAMERA},1);

            }else {
                gotoScan();
            }
        }else {
            gotoScan();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    //这里已经获取到了摄像头的权限，想干嘛干嘛了可以
                    gotoScan();

                }else {
                    //这里是拒绝给APP摄像头权限，给个提示什么的说明一下都可以。
                    Toast.makeText(ParseQRActivity.this,"请手动打开相机权限",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }

    }

    private void gotoScan() {
        IntentIntegrator intentIntegrator = new IntentIntegrator(ParseQRActivity.this);
        intentIntegrator.setBeepEnabled(true);
        /*设置启动我们自定义的扫描活动，若不设置，将启动默认活动*/
        intentIntegrator.setCaptureActivity(ScanActivity.class);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intentIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                mETTxtParseQR3.setText(result.getContents());
                sendRequest();
//                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
