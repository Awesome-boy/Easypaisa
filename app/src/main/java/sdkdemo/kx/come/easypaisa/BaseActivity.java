package sdkdemo.kx.come.easypaisa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.Nullable;

public abstract class BaseActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    protected String parseViewText(EditText et) {
        return et.getText().toString();
    }

    protected int parseToInt(EditText editText) {
        try {
            return Integer.valueOf(editText.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
    protected String getCurrentTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        String time =simpleDateFormat.format(date);
        return time;
    }


}
