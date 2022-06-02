package com.xiangliban.managementsystem.pojo.Express;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/13/23:30
 * @Description:
 */
@Data
public class DeliveryGroup {
    private String packageId;
    private String uid;
    private String packageDetails;
    private String packageLogisticsCompany;
    private String packageSenderAddress;
    private String packageRecipientAddress;
    private String packageSenderName;
    private String packageRecipientName;
    private String packageSenderPhone;
    private String packageRecipientPhone;
    private String packageEta;
    private String packagePaymentMethod;
    private double packageWeight;
    private String packageType;
    private String packageAdditionalServices;
    private String packageFreight;
    private int packageState;
    private String deliveryId;
    private String deliveryRecipientName;
    private String deliveryRecipientPhone;
    private String deliveryRecipientAddress;
    private int deliveryRecipientGender;
    private String deliveryEta;
    private String deliveryPaymentMethod;
    private double deliveryFreight;
    private int deliveryPhonesProtected;
    private int deliveryContactlessDistribution;
    private String orderId;
    private int orderStatus;
    private String puid;
    private int orderCourierStatus;
    private String orderCourierLocation;
}
