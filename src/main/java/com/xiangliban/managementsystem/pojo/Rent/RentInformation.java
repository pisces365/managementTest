package com.xiangliban.managementsystem.pojo.Rent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/16/15:18
 * @Description:
 */
@ApiModel(value = "租房信息")
@Data
public class RentInformation {
    /**
     * 出租房屋id
     */
    @ApiModelProperty(value = "出租房屋id")
    private String hrId;

    /**
     * 房东id
     */
    @ApiModelProperty(value = "房东id")
    private String hrUserId;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String hrLocation;

    /**
     * 出租类型
     */
    @ApiModelProperty(value = "出租类型（整租、合租）")
    private int hrType;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private double hrPrice;

    /**
     * 面积
     */
    @ApiModelProperty(value = "面积")
    private double hrArea;

    /**
     * 朝向
     */
    @ApiModelProperty(value = "朝向")
    private int hrToward;

    /**
     * 客厅数量
     */
    @ApiModelProperty(value = "客厅数量")
    private int hrLivingRoomAmount;

    /**
     * 卧室数量
     */
    @ApiModelProperty(value = "卧室数量（几室）")
    private int hrBedroomAmount;

    /**
     * 床数量
     */
    @ApiModelProperty(value = "床数量")
    private int hrBedAmount;

    /**
     * 卫生间
     */
    @ApiModelProperty(value = "卫生间")
    private int hrToiletAmount;

    /**
     * 房屋总数
     */
    @ApiModelProperty(value = "房屋总数")
    private int hrRoomAmount;

    /**
     * 图片url
     */
    @ApiModelProperty(value = "图片url")
    private String hrPicture;

    /**
     * 房屋描述
     */
    @ApiModelProperty(value = "房屋标题")
    private String hrDescribe;

    /**
     * 详细介绍
     */
    @ApiModelProperty(value = "房屋亮点")
    private String hrIntroduce;

    /**
     * 房屋审核(0:未审核,1:通过,2:未通过)
     */
    @ApiModelProperty(value = "房屋审核(0:未审核,1:通过,2:未通过)")
    private int hrCheck;


    private String hrFloor;
    private String hrpay;
    private int hrDecorate;
    private int hrWashingMachine;
    private int hrRefrigerator;
    private int hrTv;
    private int hrAirConditioner;
    private int hrWaterHeater;
    private int hrNaturalGas;
    private int hrNetwork;
    private int hrCloset;

}
