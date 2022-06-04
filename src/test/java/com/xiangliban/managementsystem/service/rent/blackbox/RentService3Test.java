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
public class RentService3Test {
    private String houseId;

    private int selectId;

    private RentService rentService;
    private RentMapper rentMapper;

    public RentService3Test(String houseId, int selectId) {
        this.houseId = houseId;
        this.selectId = selectId;
    }

    @Parameterized.Parameters(name = "{index}: low = {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                //等价类划分
                { "20211219154043", 1 },
                { null, 2 },
                { "", 2 },
                { "2021", 2 },
                { "2021121915404311", 2 },
                { "thishouse", 2 },
                //边界值分析
                { "1111111111111", 2 },
                { "11111111111111", 1 },
                { "111111111111111", 2 },
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

    public Map<String, RentInformation> returnOfSelectRentInformationByHouseId(int id) {

        Map<String, RentInformation> msr = new HashMap<>();
        if(id == 1) {
            RentInformation r = new RentInformation();
            r.setHrId("20211219154043");
            msr.put("1", r);
        }
        return msr;
    }

    @org.junit.Test
    public void selectRentInformationByHouseId() {

        Map<String, RentInformation> msr = returnOfSelectRentInformationByHouseId(selectId);

        expect(rentMapper.selectRentInformationByHouseId(houseId)).andReturn(msr);
        replay(rentMapper);



        if(houseId != null && houseId.length() == 14) {
            assertEquals("20211219154043", rentService.selectRentInformationByHouseId(houseId).get("1").getHrId());
            verify(rentMapper);
        } else {
            assertEquals(new HashMap<>(), rentService.selectRentInformationByHouseId(houseId));
        }

    }
}
