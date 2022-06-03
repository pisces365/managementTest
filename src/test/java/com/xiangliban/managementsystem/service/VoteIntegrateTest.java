package com.xiangliban.managementsystem.service;
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

@RunWith(SpringRunner.class)//让JUnit运行Spring的测试环境,获得Spring环境的上下文的支持
@SpringBootTest(classes = ManagementsystemApplication.class) //获取启动类，加载配置，寻找主配置启动类
@AutoConfigureMockMvc//用于自动配置MockMvc,配置后MockMvc类可以直接注入,相当于new MockMvc
public class VoteIntegrateTest {
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
    public void selectAllVoteType() throws Exception {

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/vote/allVoteType")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }
    @Test
    public void selectAllVoteDetail() throws Exception {

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/vote/selectAllVoteDetail")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }
    @Test
    public void selectVoteDetailById() throws Exception {

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("id","1");

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/vote/voteDetailById")
                        .params(multiValueMap)
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }
    @Test
    public void selectvoteDetailByType() throws Exception {

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("type","1");

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .get("/vote/voteDetailsByType")
                        .params(multiValueMap)
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }
    @Test
    public void addVoteType() throws Exception {

        String content = "{\"id\":\"0\"," +
                "\"name\":\"村长选举\"}";

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .post("/vote/addVoteType")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                        .content(content)
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }
    @Test
    public void addVoteInfo() throws Exception {

        String content = "{\"id\":\"0\"," +
                "\"name\":\"0\"," +
                "\"state\":\"0\"," +
                "\"department\":\"0\"," +
                "\"intro\":\"0\"," +
                "\"start\":\"0\"," +
                "\"end\":\"0\"," +
                "\"img\":\"test\","  +
                "\"type\":\"1\"}";

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .post("/vote/addVoteInfo")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                        .content(content)
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }
    @Test
    public void deleteVoteInfo() throws Exception {

        String content = "{\"id\":\"1\"}";

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .post("/vote/deleteVoteInfo")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                        .content(content)
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }
    @Test
    public void updateVoteType() throws Exception {

        String content = "{\"id\":\"0\"," +
                "\"name\":\"村长不选举\"}";

        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders
                        .post("/vote/updateVoteType")
                        .contentType(MediaType.APPLICATION_JSON) //此处不设置也可以
                        .content(content)
                );
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }

}
