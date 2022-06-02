package com.xiangliban.managementsystem.pojo.Rent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/16/15:42
 * @Description:
 */
@ApiModel(value = "租房预约")
@Data
public class RentAppointment {
    /**
     * 出租房屋id
     */
    @ApiModelProperty(value = "出租房屋id")
    private String hroId;

    /**
     * 出租房屋id
     */
    @ApiModelProperty(value = "预约房屋id")
    private String hroRentId;

    /**
     * 出租房屋id
     */
    @ApiModelProperty(value = "预约人id")
    private String hroTenantId;

    /**
     * 出租房屋id
     */
    @ApiModelProperty(value = "预约日期")
    private String hroOrderDate;

    /**
     * 出租房屋id
     */
    @ApiModelProperty(value = "预约开始时间")
    private String hroOrderStartTime;

    /**
     * 出租房屋id
     */
    @ApiModelProperty(value = "预约结束时间")
    private String hroOrderEndTime;


    public RentAppointment(String hroOrderDate, String hroOrderStartTime, String hroOrderEndTime) {
        this.hroOrderDate = hroOrderDate;
        this.hroOrderStartTime = hroOrderStartTime;
        this.hroOrderEndTime = hroOrderEndTime;
    }
}
