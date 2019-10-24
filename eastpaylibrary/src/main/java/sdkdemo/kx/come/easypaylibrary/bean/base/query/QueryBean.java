package sdkdemo.kx.come.easypaylibrary.bean.base.query;

import java.io.Serializable;

public class QueryBean implements Serializable {
    private String version;
    private String signType;
    private String merchantId;
    private String orderNo;
    private String orderDatetime;
    private String queryDatetime;
    private String secretKey;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(String orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public String getQueryDatetime() {
        return queryDatetime;
    }

    public void setQueryDatetime(String queryDatetime) {
        this.queryDatetime = queryDatetime;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
