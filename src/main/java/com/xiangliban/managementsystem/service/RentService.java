package com.xiangliban.managementsystem.service;

import com.xiangliban.managementsystem.dao.mapper.RentMapper;
import com.xiangliban.managementsystem.pojo.Rent.RentAppointment;
import com.xiangliban.managementsystem.pojo.Rent.RentInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/16/15:04
 * @Description:
 */
@Repository
public class RentService {

    @Autowired
    private RentMapper rentMapper;

    /*
     * 根据全部搜索条件获取特定房屋信息
     * */
    public ArrayList<Map<String, RentInformation>> selectRentInformationByAllSearchItems(double low, double high, int type, double tiny, double large, double area, int amount, int toward, int order, String userId) {
        return rentMapper.selectRentInformationByAllSearchItems(low, high, type, tiny, large, area, amount, toward, order, userId);
    }

    /*
     * 根据用户ID查询其全部出租信息
     * */
    public ArrayList<Map<String, RentInformation>> selectRentInformationByUserId(String userId) {
        return rentMapper.selectRentInformationByUserId(userId);
    }

    /*
     * 根据租房信息表主键查询全部出租信息
     * */
    public Map<String, RentInformation> selectRentInformationByHouseId(String houseId) {
        return rentMapper.selectRentInformationByHouseId(houseId);
    }


    /*
     * 插入新的租房信息
     * */
    public void insertIntoRentInformation(RentInformation rentInformation) {
        rentInformation.setHrId(IdConsturctor.idConsturctor());
        rentInformation.setHrCheck(0);
        rentMapper.insertIntoRentInformation(rentInformation);
    }

    /*
     * 插入新的租房预约
     * */
    public void insertIntoRentAppointment(RentAppointment rentAppointment) {
        rentAppointment.setHroId(IdConsturctor.idConsturctor());
        rentMapper.insertIntoRentAppointment(rentAppointment);
    }


    /*
     * 根据出租房屋号查看预约信息
     * */
    public ArrayList<Map<String, RentAppointment>> selectRentAppointmentByHouseId(String houseId) {
        return rentMapper.selectRentAppointmentByHouseId(houseId);
    }


    public ArrayList<Map<String, RentInformation>> selectRentInformationByDescribe(String hrDescribe) {
        return rentMapper.selectRentInformationByDescribe(hrDescribe);
    }
}
