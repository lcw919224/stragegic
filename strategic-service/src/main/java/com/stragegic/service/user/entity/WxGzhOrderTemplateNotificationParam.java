package com.stragegic.service.user.entity;

import cn.hutool.json.JSONObject;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author lcw
 * <p>
 * 餐饮新订单提醒通知封装类
 * </p>
 */
@Component("g2")
@Data
public class WxGzhOrderTemplateNotificationParam {
    /**
     * 模板id
     */
    private final String templeId = "NUYUEDxuL6nNNRYc8L_yvmR1yZ208U4UW7NynLHu6ec";
    /**
     * 头数据
     */
    private String first;
    /**
     * 订单内容
     */
    private String keyword1;
    /**
     * 订单金额
     */
    private String keyword2;
    /**
     * 客户信息
     */
    private String keyword3;
    /**
     * 支付方式
     */
    private String keyword4;
    /**
     * 订单备注
     */
    private String keyword5;
    /**
     * 备注
     */
    private String remark;

    public JSONObject toJsonObject() {
        JSONObject paramMap = new JSONObject();
        paramMap.put("template_id", this.templeId);
        JSONObject data = new JSONObject();
        JSONObject first = new JSONObject();
        first.put("value", this.getFirst());
        first.put("color", "#173177");
        JSONObject keyword1 = new JSONObject();
        keyword1.put("value", this.getKeyword1());
        keyword1.put("color", "#173177");
        JSONObject keyword2 = new JSONObject();
        keyword2.put("value", this.getKeyword2());
        keyword2.put("color", "#173177");
        JSONObject keyword3 = new JSONObject();
        keyword3.put("value", this.getKeyword3());
        keyword3.put("color", "#173177");
        JSONObject keyword4 = new JSONObject();
        keyword4.put("value", this.getKeyword4());
        keyword4.put("color", "#173177");
        JSONObject keyword5 = new JSONObject();
        keyword5.put("value", this.getKeyword5());
        keyword5.put("color", "#173177");
        JSONObject remark = new JSONObject();
        remark.put("value", this.getRemark());
        remark.put("color", "#173177");

        data.put("first", first);
        data.put("keyword1", keyword1);
        data.put("keyword2", keyword2);
        data.put("keyword3", keyword3);
        data.put("keyword4", keyword4);
        data.put("keyword5", keyword5);
        data.put("remark", remark);
        paramMap.put("data", data);
        return paramMap;
    }

}
