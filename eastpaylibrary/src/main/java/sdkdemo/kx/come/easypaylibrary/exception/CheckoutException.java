package sdkdemo.kx.come.easypaylibrary.exception;

/**
 * Created by xkaaron on 2016/12/6.
 */

public class CheckoutException extends Exception {
    public final static int EXCEPTION_INIT = 1;
    public final static int EXCEPTION_NOT_MERCHANT_ID = 2;
    public final static int EXCEPTION_NOT_MD5_KEY = 3;
    public final static int EXCEPTION_NOT_DEBUG_KEY = 4;
    public final static int EXCEPTION_NULL_PAYTYPE = 5;

    private int type = 1;

    public CheckoutException() {
    }

    public CheckoutException(int type) {
        this.type = type;
    }

    @Override
    public String getMessage() {
        switch (type) {
            case EXCEPTION_INIT:
                return "Checkout: Initialization not complete.";
            case EXCEPTION_NOT_MERCHANT_ID:
                return "Checkout: No merchant ID found.";
            case EXCEPTION_NOT_MD5_KEY:
                return "Checkout: No merchant key found.";
            case EXCEPTION_NOT_DEBUG_KEY:
                return "Checkout: No settings for debugging";
            case EXCEPTION_NULL_PAYTYPE:
                return "Checkout: PayType is null";
            default:
                return super.getMessage();
        }
    }
}
