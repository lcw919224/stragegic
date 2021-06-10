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
        paramMap.append("template_id", "2MZuPPkPsuC8BsQyTh5XCMC_n5k8u4tYIhKjf7xR8d4");
        JSONObject data = new JSONObject();
        JSONObject first = new JSONObject();
        first.append("value", this.getFirst());
        first.append("color", "#173177");
        JSONObject orderdate = new JSONObject();
        orderdate.append("value", this.getOrderdate());
        orderdate.append("color", "#173177");
        JSONObject roomNum = new JSONObject();
        roomNum.append("value", this.getRoomNum());
        roomNum.append("color", "#173177");
        JSONObject date = new JSONObject();
        date.append("value", this.getDate());
        date.append("color", "#173177");
        JSONObject customerName = new JSONObject();
        customerName.append("value", this.getCustomerName());
        customerName.append("color", "#173177");
        JSONObject price = new JSONObject();
        price.append("value", this.getPrice());
        price.append("color", "#173177");
        JSONObject orderNo = new JSONObject();
        orderNo.append("value", this.getOrderNo());
        orderNo.append("color", "#173177");
        JSONObject arrivalTime = new JSONObject();
        arrivalTime.append("value", this.getArrivalTime());
        arrivalTime.append("color", "#173177");
        JSONObject remark = new JSONObject();
        remark.append("value", this.getRemark());
        remark.append("color", "#173177");
        data.append("first", first);
        data.append("orderdate", orderdate);
        data.append("roomNum", roomNum);
        data.append("date", date);
        data.append("customerName", customerName);
        data.append("price", price);
        data.append("orderNo", orderNo);
        data.append("arrivalTime", arrivalTime);
        data.append("remark", remark);
        paramMap.append("data", data);
        return paramMap;
    }
}
