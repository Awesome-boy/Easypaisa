package sdkdemo.kx.come.easypaylibrary.bean.base;

import java.io.Serializable;
import java.util.List;

public class ErrorBean implements Serializable {
    private String errorCode;
    private List<String> error;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }
}
