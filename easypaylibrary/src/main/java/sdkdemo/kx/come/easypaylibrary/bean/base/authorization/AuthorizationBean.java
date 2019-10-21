package sdkdemo.kx.come.easypaylibrary.bean.base.authorization;

import java.io.Serializable;

import sdkdemo.kx.come.easypaylibrary.bean.base.BlAdressBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.SpAdressBean;

public class AuthorizationBean implements Serializable {


    private String inputCharset;
    private String version;
    private int signType;
    private String tradeNature;
    private String ext2;
    private String extTL;
    private BlAdressBean blAdressBean;
    private SpAdressBean spAdressBean;
    private String signMsg;
    private int payType;
    private String merchantId;
    private String orderNo;
    private String orderAmount;
    private String orderCurrency;
    private String orderDatetime;
    private String issuerId;
    private String pickupUrl;
    private String receiveUrl;
    private String payerEmail;
    private String payerTelephone;
    private String IPAdress;
    private String firstName;
    private String lastName;
    private String cardNumber;
    private String expiryMonth;
    private String expiryYear;
    private String cardCvv2;
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

    public String getExtTL() {
        return extTL;
    }

    public void setExtTL(String extTL) {
        this.extTL = extTL;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getCardCvv2() {
        return cardCvv2;
    }

    public void setCardCvv2(String cardCvv2) {
        this.cardCvv2 = cardCvv2;
    }



}
