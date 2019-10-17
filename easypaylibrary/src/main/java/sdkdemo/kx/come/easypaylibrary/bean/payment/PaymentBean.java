package sdkdemo.kx.come.easypaylibrary.bean.payment;

import java.io.Serializable;

public class PaymentBean implements Serializable {


    private int inputCharset;
    private int version;
    private int signType;
    private String tradeNature;

    private BlAdressBean blAdressBean;

    private SpAdressBean spAdressBean;

    private ext2 ext;

    private String signMsg;
    private int payType;
    private String merchantId;
    private String orderNo;
    private String orderAmount;
    private String orderCurrency;
    private String orderDatetime;
    private String pickupUrl;
    private String receiveUrl;
    private String payerEmail;
    private String payerTelephone;
    private String IPAdress;
    private String secretKey;


    public BlAdressBean getBlAdressBean() {
        return blAdressBean;
    }

    public void setBlAdressBean(BlAdressBean blAdressBean) {
        this.blAdressBean = blAdressBean;
    }

    public SpAdressBean getSpAdressBean() {
        return spAdressBean;
    }

    public void setSpAdressBean(SpAdressBean spAdressBean) {
        this.spAdressBean = spAdressBean;
    }

    public int getInputCharset() {
        return inputCharset;
    }

    public void setInputCharset(int inputCharset) {
        this.inputCharset = inputCharset;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getSignType() {
        return signType;
    }

    public void setSignType(int signType) {
        this.signType = signType;
    }

    public String getTradeNature() {
        return tradeNature;
    }

    public void setTradeNature(String tradeNature) {
        this.tradeNature = tradeNature;
    }

    public ext2 getExt() {
        return ext;
    }

    public void setExt(ext2 ext) {
        this.ext = ext;
    }

    public String getSignMsg() {
        return signMsg;
    }

    public void setSignMsg(String signMsg) {
        this.signMsg = signMsg;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
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

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public String getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(String orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public String getPickupUrl() {
        return pickupUrl;
    }

    public void setPickupUrl(String pickupUrl) {
        this.pickupUrl = pickupUrl;
    }

    public String getReceiveUrl() {
        return receiveUrl;
    }

    public void setReceiveUrl(String receiveUrl) {
        this.receiveUrl = receiveUrl;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public String getPayerTelephone() {
        return payerTelephone;
    }

    public void setPayerTelephone(String payerTelephone) {
        this.payerTelephone = payerTelephone;
    }

    public String getIPAdress() {
        return IPAdress;
    }

    public void setIPAdress(String IPAdress) {
        this.IPAdress = IPAdress;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
