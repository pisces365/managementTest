package com.xiangliban.managementsystem.controller;

import com.xiangliban.managementsystem.ManagementsystemApplication;
import com.xiangliban.managementsystem.controller.ExpressController;
import com.xiangliban.managementsystem.dao.mapper.ExpressMapper;
import com.xiangliban.managementsystem.pojo.Express.DeliveryGroup;
import com.xiangliban.managementsystem.pojo.Express.Package;
import com.xiangliban.managementsystem.pojo.Express.PackageProcess;
import com.xiangliban.managementsystem.service.ExpressService;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManagementsystemApplication.class)
class ExpressControllerTest {
    @Autowired
    private ExpressController expressController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void selectAllPackagesByUserId() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        Package packageTest = new Package();
        packageTest.setPackageId("666");
        Map<String,Package> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, Package>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectAllPackagesByUserId("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectAllPackagesByUserId("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectUnsignedPackageByUserIdAndOrderTime() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        Package packageTest = new Package();
        packageTest.setPackageId("666");
        Map<String,Package> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, Package>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectUnsignedPackageByUserIdAndOrderTime("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectUnsignedPackageByUserIdAndOrderTime("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectSignedPackageByUserIdAndOrderTime() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        Package packageTest = new Package();
        packageTest.setPackageId("666");
        Map<String,Package> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, Package>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectSignedPackageByUserIdAndOrderTime("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectSignedPackageByUserIdAndOrderTime("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void setPackageSignedState() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);
        Package packageTest = new Package();
        packageTest.setPackageId("666");
        Map<String,Package> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, Package>> packages = new ArrayList<>();
        packages.add(map);
        mockExpressService.setPackageSignedState("111");
        EasyMock.expectLastCall().anyTimes();
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);
        EasyMock.verify(mockExpressService);
    }

    @Test
    void selectPackageByPackageId() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        Package packageTest = new Package();
        packageTest.setPackageId("666");
        Map<String,Package> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, Package>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectPackageByPackageId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectPackageByPackageId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectPackageProcessesByPackageId() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        PackageProcess packageTest = new PackageProcess();
        packageTest.setPackageId("666");
        Map<String,PackageProcess> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, PackageProcess>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectPackageProcessesByPackageId("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectPackageProcessesByPackageId("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectIndoorBookedPackageByUserIdAndOrderTime() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectIndoorBookedPackageByUserIdAndOrderTime("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectIndoorBookedPackageByUserIdAndOrderTime("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectIndoorFinishedPackageByUserIdAndOrderTime() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectIndoorFinishedPackageByUserIdAndOrderTime("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectIndoorFinishedPackageByUserIdAndOrderTime("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectBookedDeliveryRequestByPackageId() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectBookedDeliveryRequestByPackageId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectBookedDeliveryRequestByPackageId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectFinishedDeliveryRequestByPackageId() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectFinishedDeliveryRequestByPackageId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectFinishedDeliveryRequestByPackageId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void postUserIndoorBooking() {
    }

    @Test
    void selectNewBookedDeliveryRequests() {
    }

    @Test
    void selectNewDeliveryRequestByDeliveryId() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectNewDeliveryRequestByDeliveryId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectNewDeliveryRequestByDeliveryId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectMyOngoingOrders() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectMyOngoingOrders("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectMyOngoingOrders("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectMyOngoingOrderByOrderId() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectNewDeliveryRequestByDeliveryId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectNewDeliveryRequestByDeliveryId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectMyFinishedOrders() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectNewDeliveryRequestByDeliveryId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectNewDeliveryRequestByDeliveryId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectMyFinishedOrderByOrderId() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectMyFinishedOrderByOrderId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectMyFinishedOrderByOrderId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void takeOrder() {
    }

    @Test
    void updateOrderState() {
    }

    @Test
    void selectNotAppointmentPackageByUserId() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        Package packageTest = new Package();
        packageTest.setPackageId("666");
        Map<String,Package> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, Package>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectNotAppointmentPackageByUserId("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectNotAppointmentPackageByUserId("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectNoOrderBookedPackageByUserId() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectNoOrderBookedPackageByUserId("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectNoOrderBookedPackageByUserId("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectNoOrderBookedPackageByPackageId() {
        IMocksControl control = EasyMock.createControl();
        ExpressService mockExpressService = EasyMock.createMock(ExpressService.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressService.selectNoOrderBookedPackageByPackageId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressService);
        ReflectionTestUtils.setField(expressController,"expressService",mockExpressService);

        assertEquals("666",expressController.selectNoOrderBookedPackageByPackageId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }
}