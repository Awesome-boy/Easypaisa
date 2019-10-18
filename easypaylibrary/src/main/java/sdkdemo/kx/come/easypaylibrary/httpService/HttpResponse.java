package sdkdemo.kx.come.easypaylibrary.httpService;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

public class HttpResponse<T> {

	@SerializedName("digest")
    private String digest;
    @SerializedName("msgCd")
    private String msgCd;
    @SerializedName("msgInfo")
    private String msgInfo;
	@SerializedName("body")
    private T body;

    public static final String NOT_FOUND = "404";

    private static final String SUCCESS_CODE = "00000";

    public HttpResponse(String msgCd, String msgInfo) {
        this.msgCd = msgCd;
        this.msgInfo = msgInfo;
    }

    public HttpResponse() {
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getMsgCd() {
        return msgCd;
    }

    public void setMsgCd(String msgCd) {
        this.msgCd = msgCd;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public boolean isSuccess() {
        return !TextUtils.isEmpty(msgCd) && msgCd.endsWith(SUCCESS_CODE);
    }

    public boolean isLogout() {
        return !TextUtils.isEmpty(msgCd) && msgCd.equals("ESB99026");
    }

    public String getId() {
        return body.getClass().toString();
    }
}
