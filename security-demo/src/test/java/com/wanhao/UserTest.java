package com.wanhao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by LiuLiHao on 2019/1/29 0029 下午 08:58
 * @author : LiuLiHao
 * 描述：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    /**
     * 第一步执行
     */
    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testQuerySuccess() throws Exception{
        String result = mockMvc.perform(
                get("/user").param("username", "jojo")
                        .param("age", "18")
                        .param("ageTo", "60")
                        .param("xxx", "yyy")
                        // .param("size", "15")
                        // .param("page", "3")
                        // .param("sort", "age,desc")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    @Test
    public void whenDetailSuccess() throws Exception{
        String result = mockMvc.perform(
                get("/user/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(jsonPath("$.username").value("admin"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    @Test
    public void whenDetailFail() throws Exception{
        mockMvc.perform(
                get("/user/sss")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is4xxClientError());
    }


    /**
     * 用户创建请求
     * @throws Exception
     */
    @Test
    public void whenCreateSuccess() throws Exception{
        //json
        String json = "{\"username\":\"admin\"}";
        mockMvc.perform(
                post("/user")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10086));
    }

}
