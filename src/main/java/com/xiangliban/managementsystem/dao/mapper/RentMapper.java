package com.xiangliban.managementsystem.dao.mapper;

import com.xiangliban.managementsystem.pojo.Rent.RentAppointment;
import com.xiangliban.managementsystem.pojo.Rent.RentInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2021/12/16/15:05
 * @Description:
 */
@Mapper //表示mybatis的mapper类
@Repository  //整合进spring
public interface RentMapper {
    /*
     * 获取所有房屋信息
     * */
    ArrayList<Map<String, RentInformation>> selectAllRentInformation();


    /*
     * 根据价格区间获取房屋信息
     * */
    ArrayList<Map<String, RentInformation>> selectRentInformationByPriceBetweenAAndB(double low, double high);

    /*
     * 根据价格高于某一价格获取房屋信息
     * */
    ArrayList<Map<String, RentInformation>> selectRentInformationByPriceGreaterThanA(double price);


    /*
     * 根据房屋类型获取房屋信息
     * */
    ArrayList<Map<String, RentInformation>> selectRentInformationByType(int type);


    /*
     * 根据房屋面积获取房屋信息
     * */
    ArrayList<Map<String, RentInformation>> selectRentInformationByAreaBetweenAAndB(double tiny, double large);

    /*
     * 根据房屋面积高于某一房屋面积获取房屋信息
     * */
    ArrayList<Map<String, RentInformation>> selectRentInformationByAreaGreaterThanA(double area);


    /*
     * 根据屋室数量获取房屋信息
     * */
    ArrayList<Map<String, RentInformation>> selectRentInformationByBedroomAmount(int amount);

    /*
     * 根据屋室数量高于某一屋室数量获取房屋信息
     * */
    ArrayList<Map<String, RentInformation>> selectRentInformationByBedroomAmountGreaterThanA(int amount);


    /*
     * 根据朝向获取房屋信息
     * */
    ArrayList<Map<String, RentInformation>> selectRentInformationByToward(int toward);


    /*
     * 根据全部搜索条件获取特定房屋信息
     * */
    ArrayList<Map<String, RentInformation>> selectRentInformationByAllSearchItems(double low, double high, int type, double tiny, double large, double area, int amount, int toward, int order, String userId);

    /*
     * 根据用户ID查询其全部出租信息
     * */
    ArrayList<Map<String, RentInformation>> selectRentInformationByUserId(String userId);

    /*
     * 根据租房信息表主键查询全部出租信息
     * */
    Map<String, RentInformation> selectRentInformationByHouseId(String houseId);


    /*
     * 插入新的租房信息
     * */
    int insertIntoRentInformation(@Param("rentInformation") RentInformation rentInformation);

    /*
     * 插入新的租房预约
     * */
    int insertIntoRentAppointment(@Param("rentAppointment") RentAppointment rentAppointment);


    /*
     * 根据出租房屋号查看预约信息
     * */
    ArrayList<Map<String, RentAppointment>> selectRentAppointmentByHouseId(String houseId);


    ArrayList<Map<String, RentInformation>> selectRentInformationByDescribe(String hrDescribe);
}
