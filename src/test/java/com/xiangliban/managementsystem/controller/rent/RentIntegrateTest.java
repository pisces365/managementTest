package com.xiangliban.managementsystem.controller.rent;

import com.xiangliban.managementsystem.ManagementsystemApplication;
import com.xiangliban.managementsystem.controller.RentController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 杨捷宁
 * @Date: 2022/06/02/18:51
 * @Description:
 */
@RunWith(SpringRunner.class)//让JUnit运行Spring的测试环境,获得Spring环境的上下文的支持
@SpringBootTest(classes = ManagementsystemApplication.class) //获取启动类，加载配置，寻找主配置启动类
@AutoConfigureMockMvc//用于自动配置MockMvc,配置后MockMvc类可以直接注入,相当于new MockMvc
public class RentIntegrateTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RentController rentController;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Transactional
    @Rollback()
    public void save() throws Exception {
        String json = "{……}";
        //执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/XXX/save")
                        .content(json.getBytes()) //传json参数
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .header("Authorization", "Bearer ********-****-****-****-************")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void get() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/XXX/get")
                .param("id", "**********")
                .header("Authorization", "Bearer ********-****-****-****-************")
        );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
    }

    @Test
    public void selectRentInformationByAllSearchItems() throws Exception {

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("low","2000");
        multiValueMap.add("high","3000");
        multiValueMap.add("type","1");
        multiValueMap.add("amount","1");
        multiValueMap.add("tiny","0");
        multiValueMap.add("large","50");
        multiValueMap.add("toward","1");
        multiValueMap.add("area","0");
        multiValueMap.add("order","1");
        multiValueMap.add("userId","user#1");

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/rent/selectRentInformationByAllSearchItems")
                        .params(multiValueMap)
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }

    @Test
    public void selectRentInformationByUserId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/rent/selectRentInformationByUserId")
                        .param("userId","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }

    @Test
    public void selectRentInformationByHouseId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/rent/selectRentInformationByHouseId")
                        .param("houseId","20211219154043")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }

    @Test
    public void selectRentAppointmentByHouseId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/rent/selectRentAppointmentByHouseId")
                        .param("houseId","20211219154043")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }

    @Test
    public void selectRentInformationByDescribe() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/rent/selectRentInformationByDescribe")
                        .param("hrDescribe","简易小屋，轻奢生活")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }

    @Test
    public void insertIntoRentInformation() throws Exception {

        String content = "{\"hrAirConditioner\":\"0\"," +
                "\"hrArea\":\"0\"," +
                "\"hrBedAmount\":\"0\"," +
                "\"hrBedroomAmount\":\"0\"," +
                "\"hrCheck\":\"0\"," +
                "\"hrCloset\":\"0\"," +
                "\"hrDecorate\":\"0\"," +
                "\"hrDescribe\":\"test\"," +
                "\"hrFloor\":\"1\"," +
                "\"hrIntroduce\":\"test\"," +
                "\"hrLivingRoomAmount\":\"1\"," +
                "\"hrLocation\":\"this is a location\"," +
                "\"hrNaturalGas\":\"1\"," +
                "\"hrNetwork\":\"0\"," +
                "\"hrPicture\":\"url\"," +
                "\"hrPrice\":\"2560\"," +
                "\"hrRefrigerator\":\"0\"," +
                "\"hrRoomAmount\":\"3\"," +
                "\"hrToiletAmount\":\"1\"," +
                "\"hrToward\":\"1\"," +
                "\"hrTv\":\"1\"," +
                "\"hrType\":\"1\"," +
                "\"hrWashingMachine\":\"0\"," +
                "\"hrWaterHeater\":\"0\"," +
                "\"hrpay\":\"微信\"}";

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .post("/rent/insertIntoRentInformation")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                        .content(content)
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }

    @Test
    public void insertIntoRentAppointment() throws Exception {

        String content = "{\"hroRentId\":\"20211225144655\"," +
                "\"hroTenantId\":\"2\"," +
                "\"hroOrderDate\":\"2022-6-2\"," +
                "\"hroOrderStartTime\":\"14:50\"," +
                "\"hroOrderEndTime\":\"15:50\"}";

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .post("/rent/insertIntoRentAppointment")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }
}
