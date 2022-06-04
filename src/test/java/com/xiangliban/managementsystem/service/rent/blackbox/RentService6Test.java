package com.xiangliban.managementsystem.service.rent.blackbox;

import com.xiangliban.managementsystem.dao.mapper.RentMapper;
import com.xiangliban.managementsystem.pojo.Rent.RentInformation;
import com.xiangliban.managementsystem.service.RentService;
import org.easymock.EasyMock;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/06/02/14:10
 * @Description:
 */
@RunWith(value = Parameterized.class)
public class RentService6Test {
    private RentInformation rentInformation;

    private int resultCode;

    private RentService rentService;
    private RentMapper rentMapper;

    public RentService6Test(RentInformation rentInformation, int resultCode) {
        this.rentInformation = rentInformation;
        this.resultCode = resultCode;
    }

    @Parameterized.Parameters(name = "{index}: low = {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //等价类划分
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 2560, 0, 3, 1, 1, 1, 1, 0, 0, "微信"), 1},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "", 1, 0, "url", 2560, 0, 3, 1, 1, 1, 1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 2560, 0, 3, 1, 1, 1, -1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 2560, 0, 3, 1, 1, 1, 8, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", -2560, 0, 3, 1, 1, 1, 1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 2560, 0, 3, 1, -1, 1, 1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 2560, 0, 3, 1, 8, 1, 1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", -2, "this is a location", 1, 0, "url", 2560, 0, 3, 1, 1, 1, 1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "", 2560, 0, 3, 1, 1, 1, 1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "aaaaaaaaaaaaaaaaaaaaaa", "test", 1, "this is a location", 1, 0, "url", 2560, 0, 3, 1, 1, 1, 1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "", "test", 1, "this is a location", 1, 0, "url", 2560, 0, 3, 1, 1, 1, 1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, -1, "test", "1", "test", 1, "this is a location", 1, 0, "url", 2560, 0, 3, 1, 1, 1, 1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 3, "test", "1", "test", 1, "this is a location", 1, 0, "url", 2560, 0, 3, 1, 1, 1, 1, 0, 0, "微信"), 0},

                //边界值分析
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 5, 0, 5, 1, 5, 1, 0, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 5, 0, 5, 1, 5, 1, 1, 0, 0, "微信"), 1},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 5, 0, 5, 1, 5, 1, 2, 0, 0, "微信"), 1},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 5, 0, 5, 1, 5, 1, 3, 0, 0, "微信"), 0},

                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", -1, 0, 3, 1, 5, 1, 1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 0, 0, 3, 1, 5, 1, 1, 0, 0, "微信"), 1},

                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 5, 0, 5, 1, 0, 1, 1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 5, 0, 5, 1, 1, 1, 1, 0, 0, "微信"), 1},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 5, 0, 5, 1, 6, 1, 1, 0, 0, "微信"), 1},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 5, 0, 5, 1, 7, 1, 1, 0, 0, "微信"), 0},

                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 6, 0, 0, 1, 5, 1, 1, 0, 0, "微信"), 0},
                {new RentInformation(0, 0, 0, 0, 0, 0, 0, "test", "1", "test", 1, "this is a location", 1, 0, "url", 6, 0, 1, 1, 5, 1, 1, 0, 0, "微信"), 1},

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
    public void insertIntoRentInformation() {

        expect(rentMapper.insertIntoRentInformation(rentInformation)).andReturn(resultCode);
        replay(rentMapper);

        if (resultCode == 1) {
            assertEquals(1, rentService.insertIntoRentInformation(rentInformation));
            verify(rentMapper);
        } else {
            assertEquals(0, rentService.insertIntoRentInformation(rentInformation));
        }
    }
}
