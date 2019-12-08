package com.imooc.web.controller;

import com.imooc.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 何国锋
 * @date 2019-12-08 17:14
 */
@RestController
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> query(@RequestParam(name="username", required = false, defaultValue = "Tom") String username, @PageableDefault(page = 0, size = 17, sort = {"age,desc,name,asc"}) Pageable pageable){
        List<User> users = new ArrayList<>();


        log.info(username);
        log.info(pageable.toString());


        log.info("x");
        users.add(new User());
        users.add(new User());
        users.add(new User());


        log.info(users.toString());

        return users;
    }

}
