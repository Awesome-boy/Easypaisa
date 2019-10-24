package sdkdemo.kx.come.easypaylibrary.tools;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

import sdkdemo.kx.come.easypaylibrary.bean.base.authorization.AuthorizationBean;
import sdkdemo.kx.come.easypaylibrary.bean.base.payment.PaymentBean;

/**
 * Created by xief on 2016/12/6.
 */

public class CheckoutTools {

    //    public final static String HOST_TEST = "https://dev-pacypay2-gateway.ronhan.com";

    public final static String INFO = "CheckoutInfo";
    public final static String DATA = "data";
    public final static String TYPE = "type";
    public final static String REQUES_PAY = "payment";
    public final static String REQUES_AUTH = "auth";
    public final static String REQUES_GEN = "gen";
    public final static String REQUES_PARSE = "parse";
    public final static String REQUES_INQURY = "inquery";
    public final static String REQUES_REFUND = "refund";
    public final static String REQUES_VOID = "void";
    public final static String REQUES_PREAUTH = "preauth";



    public static Map<String,String> setMap(Object mbean){
        Map<String, String> map = new HashMap<String, String>();
            PaymentBean  bean = (PaymentBean) mbean;
            map.put("inputCharset",bean.getInputCharset());
            map.put("merchantId",bean.getMerchantId());

            map.put("orderAmount",bean.getOrderAmount());
            map.put("orderCurrency",bean.getOrderCurrency());
            map.put("orderNo",bean.getOrderNo());
            map.put("orderDatetime",bean.getOrderDatetime());
            map.put("payType",bean.getPayType());
            map.put("payerEmail",bean.getPayerEmail());
            map.put("payerTelephone",bean.getPayerTelephone());
            map.put("pickupUrl",bean.getPickupUrl());
            map.put("receiveUrl",bean.getReceiveUrl());
            map.put("signType",bean.getSignType());
            map.put("tradeNature",bean.getTradeNature());
            map.put("version",bean.getVersion());


            map.put("payerIDCard","");
            map.put("pid","");
            map.put("orderExpireDatetime","");
            map.put("productName","");
            map.put("productPrice","");
            map.put("productNum","");
            map.put("productId","");
            map.put("prodectDesc","");
            map.put("ext1","");
            map.put("ext2","");
            map.put("extTL","");
            map.put("issuerId","");
            map.put("pan","");

        return  map;

    }

    public static Map<String,String> setAuthMap(AuthorizationBean bean,String extTL){
        Map<String, String> map = new HashMap<String, String>();
        map.put("ext1",bean.getExt1());
        map.put("ext2",bean.getExt2());
        map.put("extTL",extTL);
        map.put("inputCharset",bean.getInputCharset());
        map.put("issuerId",bean.getIssuerId());
        map.put("merchantId",bean.getMerchantId());

        map.put("orderAmount",bean.getOrderAmount());
        map.put("orderCurrency",bean.getOrderCurrency());
        map.put("orderNo",bean.getOrderNo());
        map.put("orderDatetime",bean.getOrderDatetime());
        map.put("payType",bean.getPayType());
        map.put("payerEmail",bean.getPayerEmail());
        map.put("payerTelephone",bean.getPayerTelephone());
        map.put("pickupUrl",bean.getPickupUrl());
        map.put("receiveUrl",bean.getReceiveUrl());
        map.put("signType",bean.getSignType());
        map.put("tradeNature",bean.getTradeNature());
        map.put("version",bean.getVersion());

        map.put("payerIDCard","");
        map.put("pid","");
        map.put("orderExpireDatetime","");
        map.put("productName","");
        map.put("productPrice","");
        map.put("productNum","");
        map.put("productId","");
        map.put("prodectDesc","");

        map.put("pan","");

       return map;
    }

}
