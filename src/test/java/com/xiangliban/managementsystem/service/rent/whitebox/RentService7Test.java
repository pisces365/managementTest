package com.xiangliban.managementsystem.service.rent.whitebox;

import com.xiangliban.managementsystem.dao.mapper.RentMapper;
import com.xiangliban.managementsystem.pojo.Rent.RentAppointment;
import com.xiangliban.managementsystem.service.RentService;
import org.easymock.EasyMock;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/06/02/16:14
 * @Description:
 */
@RunWith(value = Parameterized.class)
public class RentService7Test {
    private RentAppointment rentAppointment;

    private int resultCode;

    private RentService rentService;
    private RentMapper rentMapper;

    public RentService7Test(RentAppointment rentAppointment, int resultCode) {
        this.rentAppointment = rentAppointment;
        this.resultCode = resultCode;
    }

    @Parameterized.Parameters(name = "{index}: low = {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                //语句覆盖
                { new RentAppointment("2021-12-24", "13:50", "14:50"), 1 },
                { new RentAppointment("illegal text", "13:50", "14:50"), 0 },
                //条件覆盖
                { new RentAppointment("2021-12-24", "13:50", "14:50"), 1 },
                { new RentAppointment("illegal text", "13:50", "14:50"), 0 },
                { new RentAppointment("2021-12-24", "illegal text", "14:50"), 0 },
                { new RentAppointment("2021-12-24", "13:50", "illegal text"), 0 },
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

        expect(rentMapper.insertIntoRentAppointment(rentAppointment)).andReturn(resultCode);
        replay(rentMapper);

        if(resultCode == 1) {
            assertEquals(1, rentService.insertIntoRentAppointment(rentAppointment));
            verify(rentMapper);
        } else {
            assertEquals(0, rentService.insertIntoRentAppointment(rentAppointment));
        }
    }
}
