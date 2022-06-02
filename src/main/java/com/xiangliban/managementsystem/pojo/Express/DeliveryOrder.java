package com.xiangliban.managementsystem.pojo.Express;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/10/17:18
 * @Description:
 */
@Data
public class DeliveryOrder {
    private String orderId;
    private String deliveryId;
    private int orderStatus;
    private String puid;
    private int orderCourierStatus;
    private String orderCourierLocation;
}
