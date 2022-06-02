package com.xiangliban.managementsystem.service;

import com.xiangliban.managementsystem.pojo.Express.*;
import com.xiangliban.managementsystem.dao.mapper.ExpressMapper;
import com.xiangliban.managementsystem.pojo.Express.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/10/23:34
 * @Description:
 */
@Repository
public class ExpressService {

    @Autowired
    private ExpressMapper expressMapper;


    public List<Map<String, Package>> selectAllPackagesByUserId(String uid) {
        return expressMapper.selectAllPackagesByUserId(uid);
    }


    public List<Map<String, Package>> selectUnsignedPackageByUserIdAndOrderTime(String uid) {
        return expressMapper.selectUnsignedPackageByUserIdAndOrderTime(uid);
    }

    public List<Map<String, Package>> selectSignedPackageByUserIdAndOrderTime(String uid) {
        return expressMapper.selectSignedPackageByUserIdAndOrderTime(uid);
    }


    public void setPackageSignedState(String packageId) {
        expressMapper.setPackageSignedState(packageId);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String f = sdf.format(date);
        String id = IdConsturctor.idConsturctor();
        expressMapper.addPackageSignedState(id, packageId, f);
    }


    public Map<String, Package> selectPackageByPackageId(String packageId) {
        return expressMapper.selectPackageByPackageId(packageId);
    }

    public List<Map<String, PackageProcess>> selectPackageProcessesByPackageId(String packageId) {
        return expressMapper.selectPackageProcessesByPackageId(packageId);
    }


    public List<Map<String, DeliveryGroup>> selectIndoorBookedPackageByUserIdAndOrderTime(String uid) {
        return expressMapper.selectIndoorBookedPackageByUserIdAndOrderTime(uid);
    }

    public List<Map<String, DeliveryGroup>> selectIndoorFinishedPackageByUserIdAndOrderTime(String uid) {
        return expressMapper.selectIndoorFinishedPackageByUserIdAndOrderTime(uid);
    }


    public Map<String, DeliveryGroup> selectBookedDeliveryRequestByPackageId(String packageId) {
        return expressMapper.selectBookedDeliveryRequestByPackageId(packageId);
    }

    public Map<String, DeliveryGroup> selectFinishedDeliveryRequestByPackageId(String packageId) {
        return expressMapper.selectFinishedDeliveryRequestByPackageId(packageId);
    }


    public void postUserIndoorBooking(DeliveryRequest deliveryRequest) {
        String id = IdConsturctor.idConsturctor();
        deliveryRequest.setDeliveryId(id);
        expressMapper.postUserIndoorBooking(deliveryRequest);
    }


    public List<Map<String, DeliveryRequest>> selectNewBookedDeliveryRequests() {
        return expressMapper.selectNewBookedDeliveryRequests();
    }

    public Map<String, DeliveryGroup> selectNewDeliveryRequestByDeliveryId(String deliveryId) {
        return expressMapper.selectNewDeliveryRequestByDeliveryId(deliveryId);
    }


    public List<Map<String, DeliveryGroup>> selectMyOngoingOrders(String uid) {
        return expressMapper.selectMyOngoingOrders(uid);
    }

    public Map<String, DeliveryGroup> selectMyOngoingOrderByOrderId(String orderId) {
        return expressMapper.selectMyOngoingOrderByOrderId(orderId);
    }


    public List<Map<String, DeliveryGroup>> selectMyFinishedOrders(String uid) {
        return expressMapper.selectMyFinishedOrders(uid);
    }

    public Map<String, DeliveryGroup> selectMyFinishedOrderByOrderId(String orderId) {
        return expressMapper.selectMyFinishedOrderByOrderId(orderId);
    }


    public void tackOrder(String deliveryId, String puid) {
        DeliveryOrder deliveryOrder = new DeliveryOrder();
        String id = IdConsturctor.idConsturctor();
        deliveryOrder.setOrderId(id);
        deliveryOrder.setOrderStatus(1);
        deliveryOrder.setOrderCourierStatus(2);
        deliveryOrder.setDeliveryId(deliveryId);
        deliveryOrder.setPuid(puid);
        deliveryOrder.setOrderCourierLocation(null);
        expressMapper.tackOrder(deliveryOrder);
    }

    public void updateOrderState(String orderId, String num) {
        DeliveryOrder deliveryOrder = new DeliveryOrder();
        deliveryOrder.setOrderId(orderId);
        if (num.equals("a")) {
            deliveryOrder.setOrderStatus(1);
            deliveryOrder.setOrderCourierStatus(1);
            expressMapper.updateOrderState(deliveryOrder);
        } else if (num.equals("b")) {
            deliveryOrder.setOrderStatus(2);
            deliveryOrder.setOrderCourierStatus(3);
            expressMapper.updateOrderState(deliveryOrder);
        }
    }


    public List<Map<String, Package>> selectNotAppointmentPackageByUserId(String uid) {
        return expressMapper.selectNotAppointmentPackageByUserId(uid);
    }


    public List<Map<String, DeliveryGroup>> selectNoOrderBookedPackageByUserId(String uid) {
        return expressMapper.selectNoOrderBookedPackageByUserId(uid);
    }

    public Map<String, DeliveryGroup> selectNoOrderBookedPackageByPackageId(String packageId) {
        return expressMapper.selectNoOrderBookedPackageByPackageId(packageId);
    }
}
