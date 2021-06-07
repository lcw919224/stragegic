package com.stragegic.service.user.entity;

import cn.hutool.json.JSONObject;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author lcw
 *
 * <p>
 * 微信小程序订阅消息推送
 * 确认接单 餐饮/民宿
 * </P>
 */

@Component("g4")
@Data
public class WxXcxOrderConfirmSubscribeMessageEntity {

    /**
     * 门店名称
     */
    private String thing3;
    /**
     * 订单编号
     */
    private String character_string1;
    /**
     * 订单金额
     */
    private String amount2;
    /**
     * 订单状态
     */
    private String phrase5;
    /**
     * 接单时间
     */
    private String time4;

    public JSONObject toJsonObject() {
        JSONObject paramMap = new JSONObject();
        paramMap.put("template_id", "gg6EAaXQ0lKFgQq0SVZ5CCdC1MDG9T4G5itzVa6dnKM");
        JSONObject data = new JSONObject();

        JSONObject thing3 = new JSONObject();
        thing3.put("value", this.getThing3());
        thing3.put("color", "#173177");

        JSONObject character_string1 = new JSONObject();
        character_string1.put("value", this.getCharacter_string1());
        character_string1.put("color", "#173177");

        JSONObject amount2 = new JSONObject();
        amount2.put("value", this.getAmount2());
        amount2.put("color", "#173177");

        JSONObject phrase5 = new JSONObject();
        phrase5.put("value", this.getPhrase5());
        phrase5.put("color", "#173177");

        JSONObject time4 = new JSONObject();
        time4.put("value", this.getTime4());
        time4.put("color", "#173177");

        data.put("thing3", thing3);
        data.put("character_string1", character_string1);
        data.put("amount2", amount2);
        data.put("phrase5", phrase5);
        data.put("time4", time4);
        paramMap.put("data", data);
        return paramMap;
    }
}
