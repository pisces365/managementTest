package com.xiangliban.managementsystem.service;

import com.xiangliban.managementsystem.dao.mapper.RentMapper;
import com.xiangliban.managementsystem.pojo.Rent.RentInformation;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.easymock.EasyMock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/05/29/8:09
 * @Description:
 */
@RunWith(value = Parameterized.class)
public class RentServiceTest {

    private double low;
    private double high;
    private int type;
    private int amount;
    private double tiny;
    private double large;
    private int toward;
    private double area;
    private int order;
    private String userId;

    private RentService rentService;
    private RentMapper rentMapper;

//    public RentServiceTest() {
//
//    }

    public RentServiceTest(double low, double high, int type, double tiny, double large, double area, int amount, int toward, int order, String userId) {
        this.low = low;
        this.high = high;
        this.type = type;
        this.tiny = tiny;
        this.large = large;
        this.area = area;
        this.amount = amount;
        this.toward = toward;
        this.order = order;
        this.userId = userId;
    }

    @Parameterized.Parameters(name = "{index}: low = {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 2000, 3000, 1, 1, 0, 50, 1, 0, 1, "user#1" },
        });
    }

    @org.junit.Before
    public void setUp() throws Exception {
        rentService = new RentService();
        rentMapper = EasyMock.createMock(RentMapper.class);
        rentService.setRentMapper(rentMapper);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void selectRentInformationByAllSearchItems() {

        ArrayList<Map<String, RentInformation>> msr = new ArrayList<>();
        Map<String, RentInformation> mr = new HashMap<>();
        RentInformation r = new RentInformation();
        r.setHrPrice(2566);
        r.setHrToiletAmount(1);
        r.setHrLivingRoomAmount(1);
        r.setHrId("20211220154815");
        r.setHrPicture("http://112.124.35.32:8081/xiangliban/api/file/r6th1dnb09c6.png#");
        r.setHrBedAmount(1);
        r.setHrArea(1);
        r.setHrToward(1);
        r.setHrBedroomAmount(1);
        r.setHrDescribe("日式温馨小屋，巨幕投影。");
        mr.put("1", r);
        msr.add(mr);
        expect(rentMapper.selectRentInformationByAllSearchItems(low, high, type, tiny, large, area, amount, toward, order, userId)).andReturn(msr);
        replay(rentMapper);

        assertEquals(rentService.selectRentInformationByAllSearchItems(low, high, type, tiny, large, area, amount, toward, order, userId),msr);

        verify(rentMapper);
    }

    @org.junit.Test
    public void selectRentInformationByUserId() {
    }

    @org.junit.Test
    public void selectRentInformationByHouseId() {
    }

    @org.junit.Test
    public void insertIntoRentInformation() {
    }

    @org.junit.Test
    public void insertIntoRentAppointment() {
    }

    @org.junit.Test
    public void selectRentAppointmentByHouseId() {
    }

    @org.junit.Test
    public void selectRentInformationByDescribe() {
    }
}
