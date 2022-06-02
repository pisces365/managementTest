package com.xiangliban.managementsystem.service;

import com.xiangliban.managementsystem.ManagementsystemApplication;
import com.xiangliban.managementsystem.dao.mapper.ExpressMapper;
import com.xiangliban.managementsystem.pojo.Express.DeliveryGroup;
import com.xiangliban.managementsystem.pojo.Express.Package;
import com.xiangliban.managementsystem.pojo.Express.PackageProcess;
import org.easymock.EasyMock;
import org.easymock.IMocksControl;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManagementsystemApplication.class)
class ExpressServiceTest {
    @Autowired
    private ExpressService expressService;
    @Test
    void selectAllPackagesByUserId() {
       IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        Package packageTest = new Package();
        packageTest.setPackageId("666");
        Map<String,Package> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, Package>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectAllPackagesByUserId("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectAllPackagesByUserId("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectUnsignedPackageByUserIdAndOrderTime() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        Package packageTest = new Package();
        packageTest.setPackageId("666");
        Map<String,Package> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, Package>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectUnsignedPackageByUserIdAndOrderTime("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectUnsignedPackageByUserIdAndOrderTime("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectSignedPackageByUserIdAndOrderTime() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        Package packageTest = new Package();
        packageTest.setPackageId("666");
        Map<String,Package> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, Package>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectSignedPackageByUserIdAndOrderTime("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectSignedPackageByUserIdAndOrderTime("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void setPackageSignedState() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);
        Package packageTest = new Package();
        packageTest.setPackageId("666");
        Map<String,Package> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, Package>> packages = new ArrayList<>();
        packages.add(map);
        mockExpressMapper.setPackageSignedState("111");
        EasyMock.expectLastCall().anyTimes();
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);
        EasyMock.verify(mockExpressMapper);
    }

    @Test
    void selectPackageByPackageId() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        Package packageTest = new Package();
        packageTest.setPackageId("666");
        Map<String,Package> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, Package>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectPackageByPackageId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectPackageByPackageId("user#1").get("1").getPackageId());

        EasyMock.verify();

    }

    @Test
    void selectPackageProcessesByPackageId() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        PackageProcess packageTest = new PackageProcess();
        packageTest.setPackageId("666");
        Map<String,PackageProcess> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, PackageProcess>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectPackageProcessesByPackageId("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectPackageProcessesByPackageId("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectIndoorBookedPackageByUserIdAndOrderTime() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectIndoorBookedPackageByUserIdAndOrderTime("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectIndoorBookedPackageByUserIdAndOrderTime("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectIndoorFinishedPackageByUserIdAndOrderTime() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectIndoorFinishedPackageByUserIdAndOrderTime("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectIndoorFinishedPackageByUserIdAndOrderTime("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectBookedDeliveryRequestByPackageId() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectBookedDeliveryRequestByPackageId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectBookedDeliveryRequestByPackageId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectFinishedDeliveryRequestByPackageId() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectFinishedDeliveryRequestByPackageId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectFinishedDeliveryRequestByPackageId("user#1").get("1").getPackageId());

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
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectNewDeliveryRequestByDeliveryId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectNewDeliveryRequestByDeliveryId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectMyOngoingOrders() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectMyOngoingOrders("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectMyOngoingOrders("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectMyOngoingOrderByOrderId() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectNewDeliveryRequestByDeliveryId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectNewDeliveryRequestByDeliveryId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectMyFinishedOrders() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectNewDeliveryRequestByDeliveryId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectNewDeliveryRequestByDeliveryId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectMyFinishedOrderByOrderId() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectMyFinishedOrderByOrderId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectMyFinishedOrderByOrderId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void tackOrder() {
    }

    @Test
    void updateOrderState() {
    }

    @Test
    void selectNotAppointmentPackageByUserId() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        Package packageTest = new Package();
        packageTest.setPackageId("666");
        Map<String,Package> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, Package>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectNotAppointmentPackageByUserId("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectNotAppointmentPackageByUserId("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectNoOrderBookedPackageByUserId() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectNoOrderBookedPackageByUserId("user#1")).andReturn(packages);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectNoOrderBookedPackageByUserId("user#1").get(0).get("1").getPackageId());

        EasyMock.verify();
    }

    @Test
    void selectNoOrderBookedPackageByPackageId() {
        IMocksControl control = EasyMock.createControl();
        ExpressMapper mockExpressMapper = EasyMock.createMock(ExpressMapper.class);

        DeliveryGroup packageTest = new DeliveryGroup();
        packageTest.setPackageId("666");
        Map<String,DeliveryGroup> map =new HashMap<>();
        map.put("1",packageTest);
        List<Map<String, DeliveryGroup>> packages = new ArrayList<>();
        packages.add(map);

        EasyMock.expect(mockExpressMapper.selectNoOrderBookedPackageByPackageId("user#1")).andReturn(map);
        EasyMock.replay(mockExpressMapper);
        ReflectionTestUtils.setField(expressService,"expressMapper",mockExpressMapper);

        assertEquals("666",expressService.selectNoOrderBookedPackageByPackageId("user#1").get("1").getPackageId());

        EasyMock.verify();
    }
}