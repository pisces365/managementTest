package com.xiangliban.managementsystem.pojo.Express;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/10/17:10
 * @Description:
 */
@Data
public class DeliveryRequest {
    private String deliveryId;
    private String uid;
    private String packageId;
    private String deliveryRecipientName;
    private String deliveryRecipientPhone;
    private String deliveryRecipientAddress;
    private int deliveryRecipientGender;
    private String deliveryEta;
    private String deliveryPaymentMethod;
    private double deliveryFreight;
    private int deliveryPhonesProtected;
    private int deliveryContactlessDistribution;
}
