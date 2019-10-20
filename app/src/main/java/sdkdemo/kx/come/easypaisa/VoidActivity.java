package sdkdemo.kx.come.easypaisa;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.OnClick;
import sdkdemo.kx.come.easypaylibrary.Checkout;
import sdkdemo.kx.come.easypaylibrary.bean.base.query.QueryBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.reback.VoidBean;
import sdkdemo.kx.come.easypaylibrary.interfaces.CheckoutCallback;

public class VoidActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_void);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_confirm)
    protected void onClick() {
        voidRequest();
    }

    private void voidRequest() {
         VoidBean bean = setBean();
        Log.d("zt", "zt--" + bean.toString());
        Checkout.getInstance().reback(VoidActivity.this, bean, new CheckoutCallback() {
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
        bean.setOrderNo("20191017142940");
        bean.setMerchantId("010704515311001");
        bean.setOrderDatetime("20191017144357");
        bean.setOriginalOrderNo("20191017142940");
        bean.setSecretKey("ZloDcaGkb1zP9%2FL7LkgWDA%3D%3D");
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
