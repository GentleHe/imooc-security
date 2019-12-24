package com.imooc.web.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Restful API测试
 * <p>
 * 可以尝试使用迷你版的精简配置
 *
 * @author 何国锋
 * @date 2019-12-08 16:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class ControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        // 伪造一个web环境
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        //以下是针对特定的控制器做一个环境
//        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }


    @Test
    public void whenQuerySuccess() throws Exception {
        mockMvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON).param("username", "Jack").param("size", "15").param("page", "3").param("sort", "age, desc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }
}
