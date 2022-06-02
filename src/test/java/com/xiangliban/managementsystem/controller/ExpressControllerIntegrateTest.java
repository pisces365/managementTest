package com.xiangliban.managementsystem.controller;

import com.xiangliban.managementsystem.ManagementsystemApplication;
import com.xiangliban.managementsystem.pojo.Express.DeliveryRequest;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONValue;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)//让JUnit运行Spring的测试环境,获得Spring环境的上下文的支持
@SpringBootTest(classes = ManagementsystemApplication.class) //获取启动类，加载配置，寻找主配置启动类
@AutoConfigureMockMvc//用于自动配置MockMvc,配置后MockMvc类可以直接注入,相当于new MockMvc
class ExpressControllerIntegrateTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ExpressController expressController;

    @BeforeEach
    void setUp() {
    }
    @Test
    @Transactional
    @Rollback()
    void selectAllPackagesByUserId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/allPackagesByUserId")
                        .param("uid","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                        );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());

    }

    @Test
    void selectUnsignedPackageByUserIdAndOrderTime() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/unsignedPackageByUserIdAndOrderTime")
                        .param("uid","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectSignedPackageByUserIdAndOrderTime() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/signedPackageByUserIdAndOrderTime")
                        .param("uid","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void setPackageSignedState() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .post("/express/setPackageSignedState")
                        .param("packageId","789789")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectPackageByPackageId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/packageByPackageId")
                        .param("packageId","789789")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectPackageProcessesByPackageId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/packageProcessesByPackageId")
                        .param("packageId","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectIndoorBookedPackageByUserIdAndOrderTime() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/indoorBookedPackageByUserIdAndOrderTime")
                        .param("uid","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectIndoorFinishedPackageByUserIdAndOrderTime() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/indoorFinishedPackageByUserIdAndOrderTime")
                        .param("uid","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectBookedDeliveryRequestByPackageId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/bookedDeliveryRequestByPackageId")
                        .param("packageId","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectFinishedDeliveryRequestByPackageId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/finishedDeliveryRequestByPackageId")
                        .param("packageId","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void postUserIndoorBooking() throws Exception {
        DeliveryRequest deliveryRequest = new DeliveryRequest();
        deliveryRequest.setUid("user#1");
        deliveryRequest.setDeliveryId("1");
        deliveryRequest.setPackageId("456456");
        deliveryRequest.setDeliveryRecipientName("1");
        deliveryRequest.setDeliveryRecipientPhone("1");
        deliveryRequest.setDeliveryRecipientAddress("1");
        deliveryRequest.setDeliveryPaymentMethod("1");
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .post("/express/postUserIndoorBooking")
                        .content(JSONValue.toJSONString(deliveryRequest))
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectNewBookedDeliveryRequests() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/selectNewBookedDeliveryRequests")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectNewDeliveryRequestByDeliveryId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/selectNewDeliveryRequestByDeliveryId")
                        .param("deliveryId","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectMyOngoingOrders() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/selectMyOngoingOrders")
                        .param("uid","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectMyOngoingOrderByOrderId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/selectMyOngoingOrderByOrderId")
                        .param("orderId","20211218184000")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectMyFinishedOrders() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/selectMyFinishedOrders")
                        .param("uid","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectMyFinishedOrderByOrderId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/selectMyFinishedOrderByOrderId")
                        .param("orderId","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void takeOrder() throws Exception {
//        ResultActions resultActions =
//                mockMvc.perform(MockMvcRequestBuilders
//                        .post("/express/takeOrder")
//                        .param("deliveryId","20211220155755")
//                        .param("puid","user#1")
//                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
//                );
//        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void updateOrderState() throws Exception {
//        ResultActions resultActions =
//                mockMvc.perform(MockMvcRequestBuilders
//                        .get("/express/updateOrderState")
//                        .param("orderId","user#1")
//                        .param("num","user#1")
//                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
//                );
//        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectNotAppointmentPackageByUserId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/selectNotAppointmentPackageByUserId")
                        .param("uid","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectNoOrderBookedPackageByUserId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/selectNoOrderBookedPackageByUserId")
                        .param("uid","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    void selectNoOrderBookedPackageByPackageId() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/express/selectNoOrderBookedPackageByPackageId")
                        .param("packageId","user#1")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}