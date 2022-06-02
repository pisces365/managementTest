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
 * @Date: 2022/06/02/13:58
 * @Description:
 */
@RunWith(value = Parameterized.class)
public class RentService5Test {
    private String hrDescribe;

    private int selectId;

    private RentService rentService;
    private RentMapper rentMapper;

    public RentService5Test(String hrDescribe, int selectId) {
        this.hrDescribe = hrDescribe;
        this.selectId = selectId;
    }

    @Parameterized.Parameters(name = "{index}: low = {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "简易小屋，轻奢生活", 1 },
                { "", 2 },
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

    public ArrayList<Map<String, RentInformation>> returnOfSelectRentInformationByHouseId(int id) {
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
    public void selectRentInformationByDescribe() {

        ArrayList<Map<String, RentInformation>> msr = returnOfSelectRentInformationByHouseId(selectId);

        expect(rentMapper.selectRentInformationByDescribe(hrDescribe)).andReturn(msr);
        replay(rentMapper);

        if(hrDescribe != null && !hrDescribe.equals("")) {
            assertEquals(rentService.selectRentInformationByDescribe(hrDescribe).get(0).get("1").getHrId(), "0");
            verify(rentMapper);
        } else {
            assertEquals(rentService.selectRentInformationByDescribe(hrDescribe), new ArrayList<>());
        }

    }
}
