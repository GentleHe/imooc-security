package com.imooc.web.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * API测试的迷你版，主要是注解配置方便做出了更精简的改动
 * 使用 @AutoConfigureMockMvc 自动伪造web环境，然后使用 @Autowired 自动织入 MockMvc
 *
 *
 * @author 何国锋
 * @date 2019-12-08 16:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@AutoConfigureMockMvc
public class MiniControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void whenQuerySuccess() throws Exception {
        mockMvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON).param("username", "Jack"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }
}
