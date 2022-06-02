package com.xiangliban.managementsystem.dao;

import com.xiangliban.managementsystem.ManagementsystemApplication;
import com.xiangliban.managementsystem.pojo.Express.Package;
import com.xiangliban.managementsystem.service.ExpressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManagementsystemApplication.class)
class ExpressMapperTest {

    @Autowired
    private ExpressService expressService;

    @Test
    void selectAllPackagesByUserId() {
        List<Map<String, Package>> allPackage = expressService.selectAllPackagesByUserId("User#1");
        assertEquals("测试快递2",allPackage.get(0).get("packageDetails"));
    }

    @Test
    void selectUnsignedPackageByUserIdAndOrderTime() {
        
    }

    @Test
    void selectSignedPackageByUserIdAndOrderTime() {
    }

    @Test
    void setPackageSignedState() {
    }

    @Test
    void addPackageSignedState() {
    }

    @Test
    void selectPackageByPackageId() {
    }

    @Test
    void selectPackageProcessesByPackageId() {
    }

    @Test
    void selectIndoorBookedPackageByUserIdAndOrderTime() {
    }

    @Test
    void selectIndoorFinishedPackageByUserIdAndOrderTime() {
    }

    @Test
    void selectBookedDeliveryRequestByPackageId() {
    }

    @Test
    void selectFinishedDeliveryRequestByPackageId() {
    }

    @Test
    void postUserIndoorBooking() {
    }

    @Test
    void selectNewBookedDeliveryRequests() {
    }

    @Test
    void selectNewDeliveryRequestByDeliveryId() {
    }

    @Test
    void selectMyOngoingOrders() {
    }

    @Test
    void selectMyOngoingOrderByOrderId() {
    }

    @Test
    void selectMyFinishedOrders() {
    }

    @Test
    void selectMyFinishedOrderByOrderId() {
    }

    @Test
    void tackOrder() {
    }

    @Test
    void updateOrderState() {
    }

    @Test
    void selectNotAppointmentPackageByUserId() {
    }

    @Test
    void selectNoOrderBookedPackageByUserId() {
    }

    @Test
    void selectNoOrderBookedPackageByPackageId() {
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void testSelectAllPackagesByUserId() {
    }

    @Test
    void testSelectUnsignedPackageByUserIdAndOrderTime() {
    }

    @Test
    void testSelectSignedPackageByUserIdAndOrderTime() {
    }

    @Test
    void testSetPackageSignedState() {
    }

    @Test
    void testAddPackageSignedState() {
    }

    @Test
    void testSelectPackageByPackageId() {
    }

    @Test
    void testSelectPackageProcessesByPackageId() {
    }

    @Test
    void testSelectIndoorBookedPackageByUserIdAndOrderTime() {
    }

    @Test
    void testSelectIndoorFinishedPackageByUserIdAndOrderTime() {
    }

    @Test
    void testSelectBookedDeliveryRequestByPackageId() {
    }

    @Test
    void testSelectFinishedDeliveryRequestByPackageId() {
    }

    @Test
    void testPostUserIndoorBooking() {
    }

    @Test
    void testSelectNewBookedDeliveryRequests() {
    }

    @Test
    void testSelectNewDeliveryRequestByDeliveryId() {
    }

    @Test
    void testSelectMyOngoingOrders() {
    }

    @Test
    void testSelectMyOngoingOrderByOrderId() {
    }

    @Test
    void testSelectMyFinishedOrders() {
    }

    @Test
    void testSelectMyFinishedOrderByOrderId() {
    }

    @Test
    void testTackOrder() {
    }

    @Test
    void testUpdateOrderState() {
    }

    @Test
    void testSelectNotAppointmentPackageByUserId() {
    }

    @Test
    void testSelectNoOrderBookedPackageByUserId() {
    }

    @Test
    void testSelectNoOrderBookedPackageByPackageId() {
    }
}