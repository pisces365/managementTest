package com.xiangliban.managementsystem.dao.mapper;

import com.xiangliban.managementsystem.pojo.Express.*;
import com.xiangliban.managementsystem.pojo.Express.Package;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/10/21:11
 * @Description:
 */
@Mapper //表示mybatis的mapper类
@Repository  //整合进spring
public interface ExpressMapper {
    List<Map<String, Package>> selectAllPackagesByUserId(String uid);


    List<Map<String, Package>> selectUnsignedPackageByUserIdAndOrderTime(String uid);

    List<Map<String, Package>> selectSignedPackageByUserIdAndOrderTime(String uid);


    void setPackageSignedState(String packageId);

    void addPackageSignedState(String packageProcessId, String packageId, String processTime);


    Map<String, Package> selectPackageByPackageId(String packageId);

    List<Map<String, PackageProcess>> selectPackageProcessesByPackageId(String packageId);


    List<Map<String, DeliveryGroup>> selectIndoorBookedPackageByUserIdAndOrderTime(String uid);

    List<Map<String, DeliveryGroup>> selectIndoorFinishedPackageByUserIdAndOrderTime(String uid);


    Map<String, DeliveryGroup> selectBookedDeliveryRequestByPackageId(String packageId);

    Map<String, DeliveryGroup> selectFinishedDeliveryRequestByPackageId(String packageId);


    void postUserIndoorBooking(@Param("deliveryRequest") DeliveryRequest deliveryRequest);


    List<Map<String, DeliveryRequest>> selectNewBookedDeliveryRequests();

    Map<String, DeliveryGroup> selectNewDeliveryRequestByDeliveryId(String deliveryId);


    List<Map<String, DeliveryGroup>> selectMyOngoingOrders(String uid);

    Map<String, DeliveryGroup> selectMyOngoingOrderByOrderId(String orderId);


    List<Map<String, DeliveryGroup>> selectMyFinishedOrders(String uid);

    Map<String, DeliveryGroup> selectMyFinishedOrderByOrderId(String orderId);


    void tackOrder(@Param("deliveryOrder") DeliveryOrder deliveryOrder);

    void updateOrderState(@Param("deliveryOrder") DeliveryOrder deliveryOrder);


    List<Map<String, Package>> selectNotAppointmentPackageByUserId(String uid);


    List<Map<String, DeliveryGroup>> selectNoOrderBookedPackageByUserId(String uid);

    Map<String, DeliveryGroup> selectNoOrderBookedPackageByPackageId(String packageId);

}
