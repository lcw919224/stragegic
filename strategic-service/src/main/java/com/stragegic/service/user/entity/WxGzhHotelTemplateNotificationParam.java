package com.stragegic.service.user.entity;

import cn.hutool.json.JSONObject;
import lombok.Data;
import org.springframework.stereotype.Component;


/**
 * @author lcw
 * <p>
 * 民宿新订单通知模板参数封装类
 * </p>
 */

@Component("g1")
@Data
public class WxGzhHotelTemplateNotificationParam {
    /**
     * 头数据
     */
    private String first;
    /**
     * 预订时间
     */
    private String orderdate;
    /**
     * 房间数
     */
    private Integer roomNum;
    /**
     * 入离日期
     */
    private String date;
    /**
     * 入住人
     */
    private String customerName;
    /**
     * 房价
     */
    private String price;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 到店时间
     */
    private String arrivalTime;
    /**
     * 备注
     */
    private String remark;

    /**
     * 参数
     */
    public JSONObject toJsonObject() {
        JSONObject paramMap = new JSONObject();
        paramMap.put("template_id", "2MZuPPkPsuC8BsQyTh5XCMC_n5k8u4tYIhKjf7xR8d4");
        JSONObject data = new JSONObject();
        JSONObject first = new JSONObject();
        first.put("value", this.getFirst());
        first.put("color", "#173177");
        JSONObject orderdate = new JSONObject();
        orderdate.put("value", this.getOrderdate());
        orderdate.put("color", "#173177");
        JSONObject roomNum = new JSONObject();
        roomNum.put("value", this.getRoomNum());
        roomNum.put("color", "#173177");
        JSONObject date = new JSONObject();
        date.put("value", this.getDate());
        date.put("color", "#173177");
        JSONObject customerName = new JSONObject();
        customerName.put("value", this.getCustomerName());
        customerName.put("color", "#173177");
        JSONObject price = new JSONObject();
        price.put("value", this.getPrice());
        price.put("color", "#173177");
        JSONObject orderNo = new JSONObject();
        orderNo.put("value", this.getOrderNo());
        orderNo.put("color", "#173177");
        JSONObject arrivalTime = new JSONObject();
        arrivalTime.put("value", this.getArrivalTime());
        arrivalTime.put("color", "#173177");
        JSONObject remark = new JSONObject();
        remark.put("value", this.getRemark());
        remark.put("color", "#173177");
        data.put("first", first);
        data.put("orderdate", orderdate);
        data.put("roomNum", roomNum);
        data.put("date", date);
        data.put("customerName", customerName);
        data.put("price", price);
        data.put("orderNo", orderNo);
        data.put("arrivalTime", arrivalTime);
        data.put("remark", remark);
        paramMap.put("data", data);
        return paramMap;
    }
}
