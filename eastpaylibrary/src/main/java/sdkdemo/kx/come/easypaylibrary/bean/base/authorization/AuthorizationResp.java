package sdkdemo.kx.come.easypaylibrary.bean.base.authorization;

import java.io.Serializable;

import sdkdemo.kx.come.easypaylibrary.bean.base.BlAdressBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.SpAdressBean;

public class AuthorizationResp implements Serializable {

        private String merchantId;
        private String version;
        private String language;
        private String signType;
        private String payType;
        private String issuerId;
        private String paymentOrderId;
        private String orderNo;
        private String orderDatetime;
        private String orderAmount;
        private String payDatetime;
        private String payAmount;
        private String ext1;
        private String ext2;
        private String payResult;
        private String errorCode;
        private String returnDatetime;
        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }
        public String getMerchantId() {
            return merchantId;
        }

        public void setVersion(String version) {
            this.version = version;
        }
        public String getVersion() {
            return version;
        }

        public void setLanguage(String language) {
            this.language = language;
        }
        public String getLanguage() {
            return language;
        }

        public void setSignType(String signType) {
            this.signType = signType;
        }
        public String getSignType() {
            return signType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }
        public String getPayType() {
            return payType;
        }

        public void setIssuerId(String issuerId) {
            this.issuerId = issuerId;
        }
        public String getIssuerId() {
            return issuerId;
        }

        public void setPaymentOrderId(String paymentOrderId) {
            this.paymentOrderId = paymentOrderId;
        }
        public String getPaymentOrderId() {
            return paymentOrderId;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }
        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderDatetime(String orderDatetime) {
            this.orderDatetime = orderDatetime;
        }
        public String getOrderDatetime() {
            return orderDatetime;
        }

        public void setOrderAmount(String orderAmount) {
            this.orderAmount = orderAmount;
        }
        public String getOrderAmount() {
            return orderAmount;
        }

        public void setPayDatetime(String payDatetime) {
            this.payDatetime = payDatetime;
        }
        public String getPayDatetime() {
            return payDatetime;
        }

        public void setPayAmount(String payAmount) {
            this.payAmount = payAmount;
        }
        public String getPayAmount() {
            return payAmount;
        }

        public void setExt1(String ext1) {
            this.ext1 = ext1;
        }
        public String getExt1() {
            return ext1;
        }

        public void setExt2(String ext2) {
            this.ext2 = ext2;
        }
        public String getExt2() {
            return ext2;
        }

        public void setPayResult(String payResult) {
            this.payResult = payResult;
        }
        public String getPayResult() {
            return payResult;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }
        public String getErrorCode() {
            return errorCode;
        }

        public void setReturnDatetime(String returnDatetime) {
            this.returnDatetime = returnDatetime;
        }
        public String getReturnDatetime() {
            return returnDatetime;
        }

}
