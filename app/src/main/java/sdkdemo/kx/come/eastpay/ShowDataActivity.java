package sdkdemo.kx.come.eastpay;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import sdkdemo.kx.come.easypaisa.R;
import sdkdemo.kx.come.easypaylibrary.bean.base.authorization.AuthorizationResp;

public class ShowDataActivity  extends  BaseActivity{
    @BindView(R.id.tv_merchant)
    TextView tv_merchant;
    @BindView(R.id.tv_order)
    TextView tv_order;
    @BindView(R.id.tv_amout)
    TextView tv_amout;
    @BindView(R.id.tv_result)
    TextView tv_result;
    @BindView(R.id.tv_errorcode)
    TextView tv_errorcode;
    @BindView(R.id.iv_back)
    ImageView iv_back;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        AuthorizationResp bean= (AuthorizationResp) getIntent().getSerializableExtra("data");
        tv_merchant.setText(bean.getMerchantId());
        tv_order.setText(bean.getOrderNo());
        tv_amout.setText(bean.getOrderAmount());
        tv_result.setText(bean.getPayResult());
        tv_errorcode.setText(bean.getErrorCode());
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
