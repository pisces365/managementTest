package com.xiangliban.managementsystem.service.rent.blackbox;

import com.xiangliban.managementsystem.dao.mapper.RentMapper;
import com.xiangliban.managementsystem.pojo.Rent.RentInformation;
import com.xiangliban.managementsystem.service.RentService;
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
public class RentService1Test {

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

    private int selectId;

    private RentService rentService;
    private RentMapper rentMapper;

    public RentService1Test(double low, double high, int type, double tiny, double large, double area, int amount, int toward, int order, String userId, int selectId) {
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
        this.selectId = selectId;
    }

    @Parameterized.Parameters(name = "{index}: low = {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // 等价类划分
                { 2000, 3000, 1, 1, 0, 50, 1, 0, 1, "user#1", 1 },
                { 1, 1000, 2, 10, 50, 70, 2, 0, 1, "user#1", 2 },
                { 1000, 1500, 1, 3, 70, 90, 3, 0, 1, "user#1", 2 },
                { 1500, 2000, 1, 4, 90, 110, 4, 0, 1, "user#1", 2 },
                { 2000, 3000, 1, 1, 110, 130, 5, 0, 1, "user#1", 2 },
                { 3000, 4500, 1, 1, 130, 150, 6, 0, 1, "user#1", 2 },
                { 4500, 1, 1, 1, 150, 200, 6, 0, 1, "user#1", 2 },
                { 4500, 1, 1, 1, 200, 1, 6, 0, 1, "user#1", 2 },
                { 100, 0, 1, 1, 0, 50, 1, 0, 1, "user#1", 2 },
                { 0, 1000, 3, 1, 0, 50, 1, 0, 1, "user#1", 2 },
                { 0, 1000, 1, -1, 0, 50, 1, 0, 1, "user#1", 2 },
                { 0, 1000, 1, 1, -50, -100, 1, 0, 1, "user#1", 2 },
                { 0, 1000, 1, 1, 0, 50, 10, 0, 1, "user#1", 2 },
                // 边界值分析
                { 1, 3000, 1, 5, 5, 50, 1, 0, 1, "user#1", 1 },
                { 0, 3000, 1, 5, 5, 50, 1, 0, 1, "user#1", 2 },
                { -1, 3000, 1, 5, 5, 50, 1, 0, 1, "user#1", 2 },

                { 5, 5, 1, 0, 0, 50, 1, 0, 1, "user#1", 2 },
                { 5, 5, 1, 1, 0, 50, 1, 0, 1, "user#1", 1 },

                { 5, 5, 1, 5, 5, 0, 1, 0, 1, "user#1", 2 },
                { 5, 5, 1, 5, 5, 1, 1, 0, 1, "user#1", 1 },
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

    public ArrayList<Map<String, RentInformation>> returnOfSelectRentInformationByAllSearchItems(int id) {

        ArrayList<Map<String, RentInformation>> msr = new ArrayList<>();
        if(id == 1) {
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
        }
        return msr;
    }


    @org.junit.Test
    public void selectRentInformationByAllSearchItems() {

        ArrayList<Map<String, RentInformation>> msr = returnOfSelectRentInformationByAllSearchItems(selectId);

        expect(rentMapper.selectRentInformationByAllSearchItems(low, high, type, tiny, large, area, amount, toward, order, userId)).andReturn(msr);
        replay(rentMapper);

        assertEquals(msr, rentService.selectRentInformationByAllSearchItems(low, high, type, tiny, large, area, amount, toward, order, userId));

        if(low > 0 && high > 0 && tiny > 0 && large > 0)
        verify(rentMapper);
    }

}
