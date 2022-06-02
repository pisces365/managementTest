package com.xiangliban.managementsystem.pojo.Express;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/10/16:21
 * @Description:
 */
@Data
public class Package {
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

}
