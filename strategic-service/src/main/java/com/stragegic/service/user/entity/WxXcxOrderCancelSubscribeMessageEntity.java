package com.stragegic.service.user.entity;



import cn.hutool.json.JSONObject;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author lcw
 *
 * <p>
 * 微信订阅消息
 * 餐饮/民宿 订单取消提醒
 * </p>
 */
@Component("g3")
@Data
public class WxXcxOrderCancelSubscribeMessageEntity {
    /**
     * 商品名称
     */
    private String thing2;
    /**
     * 取消说明
     */
    private String thing1;
    /**
     * 退款金额
     */
    private String amount15;
    /**
     * 取消时间
     */
    private String date4;

    public JSONObject toJSONObject() {
        JSONObject paramMap = new JSONObject();
        paramMap.put("template_id", "l9lyVRjxvoBiTyCIKncvujH69Aw-grWY0ZaPKN_KizU");

        JSONObject data = new JSONObject();

        JSONObject thing2 = new JSONObject();
        thing2.put("value", this.getThing2());
        thing2.put("color", "#173177");

        JSONObject thing1 = new JSONObject();
        thing1.put("value", this.getThing1());
        thing1.put("color", "#173177");

        JSONObject amount15 = new JSONObject();
        amount15.put("value", this.getAmount15());
        amount15.put("color", "#173177");

        JSONObject date4 = new JSONObject();
        date4.put("value", this.getDate4());
        date4.put("color", "#173177");

        data.put("thing2", thing2);
        data.put("thing1", thing1);
        data.put("amount15", amount15);
        data.put("date4", date4);

        paramMap.put("data", data);
        return paramMap;
    }
}
