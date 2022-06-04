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
 * @Date: 2022/06/02/13:17
 * @Description:
 */
@RunWith(value = Parameterized.class)
public class RentService2Test {
    private String userId;

    private int selectId;

    private RentService rentService;
    private RentMapper rentMapper;

    public RentService2Test(String userId, int selectId) {
        this.userId = userId;
        this.selectId = selectId;
    }

    @Parameterized.Parameters(name = "{index}: low = {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                //等价类划分
                { "user#1", 1 },
                { null, 2 },
                { "", 2 },
                { "user#1fCmXXDD", 2 },
                //边界值分析
                { "", 2 },
                { "1", 1 },
                { "11", 1 },
                { "1111111111", 1 },
                { "11111111111", 1 },
                { "111111111111", 2 },

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

    public ArrayList<Map<String, RentInformation>> returnOfselectRentInformationByUserId(int id) {

        ArrayList<Map<String, RentInformation>> msr = new ArrayList<>();
        if(id == 1) {
            Map<String, RentInformation> mr = new HashMap<>();
            RentInformation r = new RentInformation();
            r.setHrId("0");
            mr.put("1", r);
            msr.add(mr);
        }
        return msr;
    }

    @org.junit.Test
    public void selectRentInformationByUserId() {

        ArrayList<Map<String, RentInformation>> msr = returnOfselectRentInformationByUserId(selectId);

        expect(rentMapper.selectRentInformationByUserId(userId)).andReturn(msr);
        replay(rentMapper);

        assertEquals(msr, rentService.selectRentInformationByUserId(userId));

        if(userId != null && userId.length() > 0 && userId.length() <= 11)
            verify(rentMapper);
    }
}
