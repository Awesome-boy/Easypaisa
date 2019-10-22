package sdkdemo.kx.come.easypaylibrary.bean.base.payment;

import java.io.Serializable;

import sdkdemo.kx.come.easypaylibrary.bean.base.BlAdressBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.SpAdressBean;

public class PaymentBean implements Serializable {


    private String inputCharset;
    private String version;
    private String signType;
    private String tradeNature;

    private BlAdressBean blAdressBean;

    private SpAdressBean spAdressBean;



    private String signMsg;
    private String payType;
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
    private int crdLvl;
    private int taxAmt;
    private int custCd;
    private int mchPostCd;
    private int taxId;
    private int mchMinorityCd;
    private int mchStateCd;
    private int shipPostCd;
    private int destPostCd;
    private int invoiceNum;
    private int freightAmt;
    private int dutyAmt;

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

    public String getInputCharset() {
        return inputCharset;
    }

    public void setInputCharset(String inputCharset) {
        this.inputCharset = inputCharset;
    }

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

    public String getTradeNature() {
        return tradeNature;
    }

    public void setTradeNature(String tradeNature) {
        this.tradeNature = tradeNature;
    }



    public String getSignMsg() {
        return signMsg;
    }

    public void setSignMsg(String signMsg) {
        this.signMsg = signMsg;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
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

    public int getCrdLvl() {
        return crdLvl;
    }

    public void setCrdLvl(int crdLvl) {
        this.crdLvl = crdLvl;
    }

    public int getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(int taxAmt) {
        this.taxAmt = taxAmt;
    }

    public int getCustCd() {
        return custCd;
    }

    public void setCustCd(int custCd) {
        this.custCd = custCd;
    }

    public int getMchPostCd() {
        return mchPostCd;
    }

    public void setMchPostCd(int mchPostCd) {
        this.mchPostCd = mchPostCd;
    }

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    public int getMchMinorityCd() {
        return mchMinorityCd;
    }

    public void setMchMinorityCd(int mchMinorityCd) {
        this.mchMinorityCd = mchMinorityCd;
    }

    public int getMchStateCd() {
        return mchStateCd;
    }

    public void setMchStateCd(int mchStateCd) {
        this.mchStateCd = mchStateCd;
    }

    public int getShipPostCd() {
        return shipPostCd;
    }

    public void setShipPostCd(int shipPostCd) {
        this.shipPostCd = shipPostCd;
    }

    public int getDestPostCd() {
        return destPostCd;
    }

    public void setDestPostCd(int destPostCd) {
        this.destPostCd = destPostCd;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public int getFreightAmt() {
        return freightAmt;
    }

    public void setFreightAmt(int freightAmt) {
        this.freightAmt = freightAmt;
    }

    public int getDutyAmt() {
        return dutyAmt;
    }

    public void setDutyAmt(int dutyAmt) {
        this.dutyAmt = dutyAmt;
    }

    @Override
    public String toString() {
        return "AuthorizationBean{" +
                "inputCharset='" + inputCharset + '\'' +
                ", version='" + version + '\'' +
                ", signType=" + signType +
                ", tradeNature='" + tradeNature + '\'' +
                ", blAdressBean=" + blAdressBean +
                ", spAdressBean=" + spAdressBean +
                ", signMsg='" + signMsg + '\'' +
                ", payType=" + payType +
                ", merchantId='" + merchantId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderAmount='" + orderAmount + '\'' +
                ", orderCurrency='" + orderCurrency + '\'' +
                ", orderDatetime='" + orderDatetime + '\'' +
                ", pickupUrl='" + pickupUrl + '\'' +
                ", receiveUrl='" + receiveUrl + '\'' +
                ", payerEmail='" + payerEmail + '\'' +
                ", payerTelephone='" + payerTelephone + '\'' +
                ", IPAdress='" + IPAdress + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", crdLvl=" + crdLvl +
                ", taxAmt=" + taxAmt +
                ", custCd=" + custCd +
                ", mchPostCd=" + mchPostCd +
                ", taxId=" + taxId +
                ", mchMinorityCd=" + mchMinorityCd +
                ", mchStateCd=" + mchStateCd +
                ", shipPostCd=" + shipPostCd +
                ", destPostCd=" + destPostCd +
                ", invoiceNum=" + invoiceNum +
                ", freightAmt=" + freightAmt +
                ", dutyAmt=" + dutyAmt +
                '}';
    }
}
