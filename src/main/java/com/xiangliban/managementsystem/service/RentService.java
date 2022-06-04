package com.xiangliban.managementsystem.service;

import com.xiangliban.managementsystem.dao.mapper.RentMapper;
import com.xiangliban.managementsystem.pojo.Rent.RentAppointment;
import com.xiangliban.managementsystem.pojo.Rent.RentInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    public void setRentMapper(RentMapper rentMapper) {
        this.rentMapper = rentMapper;
    }

    /*
     * 根据全部搜索条件获取特定房屋信息
     * */
    public ArrayList<Map<String, RentInformation>> selectRentInformationByAllSearchItems(double low, double high, int type, double tiny, double large, double area, int amount, int toward, int order, String userId) {
        if(low < 0 || high < 0) {
            return new ArrayList<Map<String, RentInformation>>();
        }
        else if(tiny < 0 || large < 0) {
            return new ArrayList<Map<String, RentInformation>>();
        } else {
            return rentMapper.selectRentInformationByAllSearchItems(low, high, type, tiny, large, area, amount, toward, order, userId);
        }
    }

    /*
     * 根据用户ID查询其全部出租信息
     * */
    public ArrayList<Map<String, RentInformation>> selectRentInformationByUserId(String userId) {
        if (userId == null) {
            return new ArrayList<Map<String, RentInformation>>();
        } else if("".equals(userId)) {
            return new ArrayList<Map<String, RentInformation>>();
        } else if(userId.length() > 11) {
            return new ArrayList<Map<String, RentInformation>>();
        } else {
            return rentMapper.selectRentInformationByUserId(userId);
        }
    }

    /*
     * 根据租房信息表主键查询全部出租信息
     * */
    public Map<String, RentInformation> selectRentInformationByHouseId(String houseId) {
        if(houseId == null) {
            return new HashMap<>();
        } else if("".equals(houseId)) {
            return new HashMap<>();
        } else if(houseId.length() != 14) {
            return new HashMap<>();
        } else {
            if(houseId.matches("[0-9]+")) {
                return rentMapper.selectRentInformationByHouseId(houseId);
            } else {
                return new HashMap<>();
            }
        }
    }


    /*
     * 插入新的租房信息
     * */
    public int insertIntoRentInformation(RentInformation rentInformation) {
        rentInformation.setHrId(IdConsturctor.idConsturctor());
        rentInformation.setHrCheck(0);

        if(rentInformation.getHrLocation() == null || "".equals(rentInformation.getHrLocation())) {
            return 0;
        } else if (rentInformation.getHrType() < 1 || rentInformation.getHrType() > 2) {
            return 0;
        } else if (rentInformation.getHrPrice() < 0) {
            return 0;
        } else if (rentInformation.getHrToward() < 1 || rentInformation.getHrToward() > 6) {
            return 0;
        } else if (rentInformation.getHrLivingRoomAmount() < 0) {
            return 0;
        } else if (rentInformation.getHrRoomAmount() <= 0) {
            return 0;
        } else if ("".equals(rentInformation.getHrPrice())) {
            return 0;
        } else if ("".equals(rentInformation.getHrFloor()) || rentInformation.getHrFloor().length() > 20) {
            return 0;
        } else if (rentInformation.getHrWashingMachine() < 0 || rentInformation.getHrWashingMachine() > 1) {
            return 0;
        } else if (rentInformation.getHrPicture().length() == 0) {
            return 0;
        } else if (rentInformation.getHrDecorate() != 1 && rentInformation.getHrDecorate() != 0) {
            return 0;
        } else {
            rentMapper.insertIntoRentInformation(rentInformation);
            return 1;
        }
    }

    /*
     * 插入新的租房预约
     * */
    public int insertIntoRentAppointment(RentAppointment rentAppointment) {
        rentAppointment.setHroId(IdConsturctor.idConsturctor());

        if(!dateStrIsValid(rentAppointment.getHroOrderDate(), "yyyy-MM-dd")) {
            return 0;
        } else if (!checkTime(rentAppointment.getHroOrderStartTime())) {
            return 0;
        } else if (!checkTime(rentAppointment.getHroOrderEndTime())) {
            return 0;
        } else {
            rentMapper.insertIntoRentAppointment(rentAppointment);
            return 1;
        }
    }


    /*
     * 根据出租房屋号查看预约信息
     * */
    public ArrayList<Map<String, RentAppointment>> selectRentAppointmentByHouseId(String houseId) {
        return rentMapper.selectRentAppointmentByHouseId(houseId);
    }

    /*
     * 根据出租房屋描述查看预约信息
     * */
    public ArrayList<Map<String, RentInformation>> selectRentInformationByDescribe(String hrDescribe) {

        if("".equals(hrDescribe)) {
            return new ArrayList<>();
        } else {
            return rentMapper.selectRentInformationByDescribe(hrDescribe);
        }
    }





    /**
     * 日期检查器
     * @param rawDateStr
     * @param pattern
     * @return
     */
    private boolean dateStrIsValid(String rawDateStr, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            // 转化为 Date类型测试判断
            date = dateFormat.parse(rawDateStr);
            return rawDateStr.equals(dateFormat.format(date));
        } catch (ParseException e) {
            return false;
        }

    }

    /**
     * 时间检查器
     * 校验时间格式HH:MM（精确）
     */
    private static boolean checkTime(String time) {
        if (checkHHMM(time)) {
            String[] temp = time.split(":");
            if ((temp[0].length() == 2 || temp[0].length() == 1) && temp[1].length() == 2) {
                int h,m;
                try {
                    h = Integer.parseInt(temp[0]);
                    m = Integer.parseInt(temp[1]);
                } catch (NumberFormatException e) {
                    return false;
                }
                if (h >= 0 && h <= 24 && m <= 60 && m >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 校验时间格式（仅格式）
     */
    private static boolean checkHHMM(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
        try {
            @SuppressWarnings("unused")
            Date t = dateFormat.parse(time);
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }
}
