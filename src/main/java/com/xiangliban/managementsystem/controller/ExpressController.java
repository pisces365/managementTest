package com.xiangliban.managementsystem.controller;

import com.xiangliban.managementsystem.pojo.Express.*;
import com.xiangliban.managementsystem.pojo.Express.Package;
import com.xiangliban.managementsystem.service.ExpressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/10/23:36
 * @Description:
 */
@Api(tags = "快递接口类")
@RestController
@CrossOrigin
public class ExpressController {

    @Autowired
    private ExpressService expressService;


    @ApiOperation("wx-vue根据用户uid查询所有包裹记录")
    @GetMapping("/express/allPackagesByUserId")
    public List<Map<String, Package>> selectAllPackagesByUserId(String uid) {
        return expressService.selectAllPackagesByUserId(uid);
    }


    @ApiOperation("wx根据用户uid查询所有未签收包裹（默认最新下单包裹在第一位）")
    @GetMapping("/express/unsignedPackageByUserIdAndOrderTime")
    public List<Map<String, Package>> selectUnsignedPackageByUserIdAndOrderTime(String uid) {
        return expressService.selectUnsignedPackageByUserIdAndOrderTime(uid);
    }

    @ApiOperation("wx根据用户uid查询所有签收包裹（默认最新下单包裹在第一位）")
    @GetMapping("/express/signedPackageByUserIdAndOrderTime")
    public List<Map<String, Package>> selectSignedPackageByUserIdAndOrderTime(String uid) {
        return expressService.selectSignedPackageByUserIdAndOrderTime(uid);
    }


    @ApiOperation("wx更改包裹签收状态为已签收")
    @PostMapping("/express/setPackageSignedState")
    public void setPackageSignedState(String packageId) {
        expressService.setPackageSignedState(packageId);
    }


    @ApiOperation("wx根据包裹packageId查询该包裹信息")
    @GetMapping("/express/packageByPackageId")
    public Map<String, Package> selectPackageByPackageId(String packageId) {
        return expressService.selectPackageByPackageId(packageId);
    }

    @ApiOperation("wx根据包裹packageId获取包裹全部物流数据")
    @GetMapping("/express/packageProcessesByPackageId")
    public List<Map<String, PackageProcess>> selectPackageProcessesByPackageId(String packageId) {
        return expressService.selectPackageProcessesByPackageId(packageId);
    }


    @ApiOperation("wx根据用户uid查询所有已预定包裹（默认最新下单包裹在第一位）")
    @GetMapping("/express/indoorBookedPackageByUserIdAndOrderTime")
    public List<Map<String, DeliveryGroup>> selectIndoorBookedPackageByUserIdAndOrderTime(String uid) {
        return expressService.selectIndoorBookedPackageByUserIdAndOrderTime(uid);
    }

    @ApiOperation("wx根据用户uid查询所有上门完成包裹（默认最新下单包裹在第一位）")
    @GetMapping("/express/indoorFinishedPackageByUserIdAndOrderTime")
    public List<Map<String, DeliveryGroup>> selectIndoorFinishedPackageByUserIdAndOrderTime(String uid) {
        return expressService.selectIndoorFinishedPackageByUserIdAndOrderTime(uid);
    }


    @ApiOperation("wx根据包裹packageId查询该已预定包裹信息")
    @GetMapping("/express/bookedDeliveryRequestByPackageId")
    public Map<String, DeliveryGroup> selectBookedDeliveryRequestByPackageId(String packageId) {
        return expressService.selectBookedDeliveryRequestByPackageId(packageId);
    }

    @ApiOperation("wx根据包裹packageId查询该已上门完成包裹信息")
    @GetMapping("/express/finishedDeliveryRequestByPackageId")
    public Map<String, DeliveryGroup> selectFinishedDeliveryRequestByPackageId(String packageId) {
        return expressService.selectFinishedDeliveryRequestByPackageId(packageId);
    }


    @ApiOperation("wx上传用户预约信息表单")
    @PostMapping("/express/postUserIndoorBooking")
    public void postUserIndoorBooking(@RequestBody DeliveryRequest deliveryRequest) {
        expressService.postUserIndoorBooking(deliveryRequest);
    }


    @ApiOperation("wx-vue获取所有新的预约上门表单")
    @GetMapping("/express/selectNewBookedDeliveryRequests")
    public List<Map<String, DeliveryRequest>> selectNewBookedDeliveryRequests() {
        return expressService.selectNewBookedDeliveryRequests();
    }

    @ApiOperation("wx-vue根据用户上门预约表单deliveryId获取预约信息")
    @GetMapping("/express/selectNewDeliveryRequestByDeliveryId")
    public Map<String, DeliveryGroup> selectNewDeliveryRequestByDeliveryId(String deliveryId) {
        return expressService.selectNewDeliveryRequestByDeliveryId(deliveryId);
    }


    @ApiOperation("wx-vue根据快递员uid获取其所有进行中工单信息")
    @GetMapping("/express/selectMyOngoingOrders")
    public List<Map<String, DeliveryGroup>> selectMyOngoingOrders(String uid) {
        return expressService.selectMyOngoingOrders(uid);
    }

    @ApiOperation("wx-vue根据工单orderId获取进行中工单的信息")
    @GetMapping("/express/selectMyOngoingOrderByOrderId")
    public Map<String, DeliveryGroup> selectMyOngoingOrderByOrderId(String orderId) {
        return expressService.selectMyOngoingOrderByOrderId(orderId);
    }


    @ApiOperation("wx-vue根据快递员uid获取其所有已完成工单信息")
    @GetMapping("/express/selectMyFinishedOrders")
    public List<Map<String, DeliveryGroup>> selectMyFinishedOrders(String uid) {
        return expressService.selectMyFinishedOrders(uid);
    }

    @ApiOperation("wx-vue根据工单orderId获取已完成工单的信息")
    @GetMapping("/express/selectMyFinishedOrderByOrderId")
    public Map<String, DeliveryGroup> selectMyFinishedOrderByOrderId(String orderId) {
        return expressService.selectMyFinishedOrderByOrderId(orderId);
    }


    @ApiOperation("wx-vue配送员接单（订单状态默认为已接单/进行中）注：不要传入已接单的deliveryid，否则会报错")
    @PostMapping("/express/takeOrder")
    public void takeOrder(String deliveryId, String puid) {
        expressService.tackOrder(deliveryId, puid);
    }

    @ApiOperation("wx-vue配送员更新订单状态 对于num参数（a：正在配送/进行中；b：已完成/已完成）")
    @PostMapping("/express/updateOrderState")
    public void updateOrderState(String orderId, String num) {
        expressService.updateOrderState(orderId, num);
    }

    @ApiOperation("wx获取所有未预约的包裹信息")
    @GetMapping("/express/selectNotAppointmentPackageByUserId")
    public List<Map<String, Package>> selectNotAppointmentPackageByUserId(String uid) {
        return expressService.selectNotAppointmentPackageByUserId(uid);
    }

    @ApiOperation("wx根据用户uid获取所有已预约但尚未接单的全部包裹信息")
    @GetMapping("/express/selectNoOrderBookedPackageByUserId")
    public List<Map<String, DeliveryGroup>> selectNoOrderBookedPackageByUserId(String uid) {
        return expressService.selectNoOrderBookedPackageByUserId(uid);
    }

    @ApiOperation("wx用户根据packageId获取所有已预约但尚未接单的单个包裹信息")
    @GetMapping("/express/selectNoOrderBookedPackageByPackageId")
    public Map<String, DeliveryGroup> selectNoOrderBookedPackageByPackageId(String packageId) {
        return expressService.selectNoOrderBookedPackageByPackageId(packageId);
    }


}
