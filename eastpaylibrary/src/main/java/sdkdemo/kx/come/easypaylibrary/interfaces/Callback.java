package sdkdemo.kx.come.easypaylibrary.interfaces;


public final class Callback {
    private static CheckoutCallback mCheckoutCallback;

    public static void setCheckoutCallback(CheckoutCallback mCheckoutCallback) {
        Callback.mCheckoutCallback = mCheckoutCallback;
    }

    public static CheckoutCallback getCheckoutCallback() {
        return mCheckoutCallback;
    }
}
