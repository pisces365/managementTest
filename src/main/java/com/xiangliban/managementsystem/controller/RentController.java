package com.xiangliban.managementsystem.controller;

import com.xiangliban.managementsystem.pojo.Rent.RentAppointment;
import com.xiangliban.managementsystem.pojo.Rent.RentInformation;
import com.xiangliban.managementsystem.service.IdConsturctor;
import com.xiangliban.managementsystem.service.RentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/16/15:05
 * @Description:
 */
@Api(tags = "房屋出租接口类")
@RestController
@CrossOrigin
public class RentController {

    @Autowired
    private RentService rentService;

    /*
     * 根据全部搜索条件获取特定房屋信息
     * */
    @ApiOperation("根据全部搜索条件获取特定房屋信息")
    @GetMapping("/rent/selectRentInformationByAllSearchItems")
    public ArrayList<Map<String, RentInformation>> selectRentInformationByAllSearchItems(double low, double high, int type, double tiny, double large, double area, int amount, int toward, int order, String userId) {
        return rentService.selectRentInformationByAllSearchItems(low, high, type, tiny, large, area, amount, toward, order, userId);
    }

    /*
     * 根据用户ID查询其全部出租信息
     * */
    @ApiOperation("根据用户ID查询其全部出租信息")
    @GetMapping("/rent/selectRentInformationByUserId")
    public ArrayList<Map<String, RentInformation>> selectRentInformationByUserId(String userId) {
        return rentService.selectRentInformationByUserId(userId);
    }

    /*
     * 根据租房信息表主键查询全部出租信息
     * */
    @ApiOperation("根据租房信息表主键查询全部出租信息")
    @GetMapping("/rent/selectRentInformationByHouseId")
    public Map<String, RentInformation> selectRentInformationByHouseId(String houseId) {
        return rentService.selectRentInformationByHouseId(houseId);
    }


    /*
     * 插入新的租房信息
     * */
    @ApiOperation("插入新的租房信息")
    @PostMapping("/rent/insertIntoRentInformation")
    public void insertIntoRentInformation(@RequestBody RentInformation rentInformation) {
        rentService.insertIntoRentInformation(rentInformation);
    }

    /*
     * 插入新的租房预约
     * */
    @ApiOperation("插入新的租房预约")
    @PostMapping("/rent/insertIntoRentAppointment")
    public void insertIntoRentAppointment(@RequestBody RentAppointment rentAppointment) {
        rentService.insertIntoRentAppointment(rentAppointment);
    }


    /*
     * 根据出租房屋号查看预约信息
     * */
    @ApiOperation("根据出租房屋号查看预约信息")
    @GetMapping("/rent/selectRentAppointmentByHouseId")
    public ArrayList<Map<String, RentAppointment>> selectRentAppointmentByHouseId(String houseId) {
        return rentService.selectRentAppointmentByHouseId(houseId);
    }


    @ApiOperation("根据房屋描述（标题）检索所有房屋")
    @GetMapping("/rent/selectRentInformationByDescribe")
    public ArrayList<Map<String, RentInformation>> selectRentInformationByDescribe(String hrDescribe) {
        return rentService.selectRentInformationByDescribe(hrDescribe);
    }

}
