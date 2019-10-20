package sdkdemo.kx.come.easypaylibrary.tools;

import com.alibaba.fastjson.JSON;

import java.util.Map;

import androidx.collection.ArrayMap;
import sdkdemo.kx.come.easypaylibrary.bean.base.authorization.AuthorizationBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.order.OrderCheckBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.payment.PaymentBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.query.QueryBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.reback.VoidBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.refund.RefundBean;

public class ParamsTools {

    public static Map<String,String> setParams(PaymentBean bean) {
        Map<String, String> params = new ArrayMap<>();
        if (bean!=null){
            params.put("inputCharset", bean.getInputCharset());
            params.put("version", bean.getVersion());
            params.put("signType", String.valueOf(bean.getSignType()));
            params.put("tradeNature",bean.getTradeNature()  );
            params.put("billingAddress",  JSON.toJSONString(bean.getBlAdressBean()));
            params.put("shippingAddress", JSON.toJSONString(bean.getSpAdressBean()) );
            params.put("signMsg", bean.getSignMsg() );
            params.put("payType", String.valueOf(bean.getPayType()));
            params.put("merchantId", bean.getMerchantId() );
            params.put("orderNo", bean.getOrderNo() );
            params.put("orderCurrency", bean.getOrderCurrency() );
            params.put("orderAmount", bean.getOrderAmount() );
            params.put("orderDatetime",bean.getOrderDatetime()  );
            params.put("pickupUrl", bean.getPickupUrl() );
            params.put("receiveUrl", bean.getReceiveUrl() );
            params.put("payerEmail", bean.getPayerEmail() );
            params.put("payerTelephone",bean.getPayerTelephone()  );
            params.put("IPAddress", bean.getIPAdress() );
            params.put("crdLvl", String.valueOf(bean.getCrdLvl()));
            params.put("taxAmt", String.valueOf(bean.getTaxAmt()));
            params.put("custCd", String.valueOf(bean.getCustCd()));
            params.put("mchPostCd", String.valueOf(bean.getMchPostCd()));
            params.put("taxId", String.valueOf(bean.getTaxId()));
            params.put("mchMinorityCd",  String.valueOf(bean.getMchMinorityCd()));
            params.put("mchStateCd",  String.valueOf(bean.getMchStateCd()));
            params.put("shipPostCd",  String.valueOf(bean.getShipPostCd()));
            params.put("destPostCd", String.valueOf(bean.getDestPostCd()) );
            params.put("invoiceNum",  String.valueOf(bean.getInvoiceNum()));
            params.put("freightAmt", String.valueOf(bean.getFreightAmt()) );
            params.put("dutyAmt", String.valueOf(bean.getDutyAmt()) );
            params.put("secretKey", bean.getSecretKey() );
        }
        return params;
    }

    public static Map<String,String> authorizationParams(AuthorizationBean bean) {
        Map<String, String> params = new ArrayMap<>();
        if (bean!=null){
            params.put("inputCharset", bean.getInputCharset());
            params.put("version", bean.getVersion());
            params.put("signType", String.valueOf(bean.getSignType()));
            params.put("tradeNature",bean.getTradeNature()  );
            params.put("billingAddress",  JSON.toJSONString(bean.getBlAdressBean()));
            params.put("shippingAddress", JSON.toJSONString(bean.getSpAdressBean()) );
            params.put("signMsg", bean.getSignMsg() );
            params.put("payType", String.valueOf(bean.getPayType()));
            params.put("merchantId", bean.getMerchantId() );
            params.put("orderNo", bean.getOrderNo() );
            params.put("orderCurrency", bean.getOrderCurrency() );
            params.put("orderAmount", bean.getOrderAmount() );
            params.put("orderDatetime",bean.getOrderDatetime()  );
            params.put("extTL",bean.getExtTL());
            params.put("pickupUrl", bean.getPickupUrl() );
            params.put("receiveUrl", bean.getReceiveUrl() );
            params.put("payerEmail", bean.getPayerEmail() );
            params.put("payerTelephone",bean.getPayerTelephone()  );
            params.put("IPAddress", bean.getIPAdress() );
            params.put("crdLvl", String.valueOf(bean.getCrdLvl()));
            params.put("taxAmt", String.valueOf(bean.getTaxAmt()));
            params.put("custCd", String.valueOf(bean.getCustCd()));
            params.put("mchPostCd", String.valueOf(bean.getMchPostCd()));
            params.put("taxId", String.valueOf(bean.getTaxId()));
            params.put("mchMinorityCd",  String.valueOf(bean.getMchMinorityCd()));
            params.put("mchStateCd",  String.valueOf(bean.getMchStateCd()));
            params.put("shipPostCd",  String.valueOf(bean.getShipPostCd()));
            params.put("destPostCd", String.valueOf(bean.getDestPostCd()) );
            params.put("invoiceNum",  String.valueOf(bean.getInvoiceNum()));
            params.put("freightAmt", String.valueOf(bean.getFreightAmt()) );
            params.put("dutyAmt", String.valueOf(bean.getDutyAmt()) );
            params.put("secretKey", bean.getSecretKey() );
        }
        return params;

    }

    public static Map<String,String> query(QueryBean bean) {
        Map<String, String> params = new ArrayMap<>();
        if (bean!=null){
            params.put("version", bean.getVersion());
            params.put("signType",bean.getSignType());
            params.put("merchantId",bean.getMerchantId());
            params.put("orderNo", bean.getOrderNo() );
            params.put("orderDatetime", bean.getOrderDatetime());
            params.put("queryDatetime", bean.getQueryDatetime() );
            params.put("secretKey", bean.getSecretKey() );
        }
        return params;
    }

    public static Map<String,String> refund(RefundBean bean) {
        Map<String, String> params = new ArrayMap<>();
        if (bean!=null){
            params.put("version", bean.getVersion());
            params.put("signType",bean.getSignType());
            params.put("merchantId",bean.getMerchantId());
            params.put("orderNo", bean.getOrderNo() );
            params.put("orderDatetime", bean.getOrderDatetime());
            params.put("refundAmount", bean.getRefundAmount());
            params.put("originalOrderNo", bean.getOriginalOrderNo());
            params.put("secretKey", bean.getSecretKey() );
        }
        return params;

    }

    public static Map<String,String> revoid(VoidBean bean) {
        Map<String, String> params = new ArrayMap<>();
        if (bean!=null){
            params.put("version", bean.getVersion());
            params.put("signType",bean.getSignType());
            params.put("merchantId",bean.getMerchantId());
            params.put("orderNo", bean.getOrderNo() );
            params.put("orderDatetime", bean.getOrderDatetime());
            params.put("originalOrderNo", bean.getOriginalOrderNo());
            params.put("secretKey", bean.getSecretKey() );
        }
        return params;
    }

    public static Map<String,String> orderCheck(OrderCheckBean bean) {
        Map<String, String> params = new ArrayMap<>();
        if (bean!=null){
            params.put("version", bean.getVersion());
            params.put("signType",bean.getSignType());
            params.put("merchantId",bean.getMerchantId());
            params.put("orderNo", bean.getOrderNo() );
            params.put("action", bean.getAction());
            params.put("checkDatetime", bean.getCheckDatetime());
            params.put("secretKey", bean.getSecretKey() );
        }
        return params;
    }
}