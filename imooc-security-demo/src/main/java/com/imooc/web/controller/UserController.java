package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import com.imooc.exception.UserNotExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 何国锋
 * @date 2019-12-08 17:14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);


    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors){

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println("user.id: " + user.getId());
        System.out.println("user.name: " + user.getUsername());
        System.out.println("user.password: " + user.getPassword());

        user.setId("1");

        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update( @Valid @RequestBody User user, BindingResult errors){

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError)error;
                String message = fieldError.getField() + " " + error.getDefaultMessage();
                System.out.println("message: " + message);
            });

        }

        System.out.println("user.id: " + user.getId());
        System.out.println("user.name: " + user.getUsername());
        System.out.println("user.password: " + user.getPassword());

        user.setId("1");

        return user;
    }

    @JsonView(User.UserSimpleView.class)
    @GetMapping
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 0, size = 17, sort = {"age,desc,name,asc"}) Pageable pageable){
        List<User> users = new ArrayList<>();


        log.info(condition.toString());
        log.info(pageable.toString());


        log.info("x");
        users.add(new User());
        users.add(new User());
        users.add(new User());


        log.info(users.toString());

        return users;
    }

    @JsonView(User.UserDetailView.class)
    @GetMapping(value = "/{id:\\d+}")
    public User getInfo(@PathVariable(value = "id") String id){

//        throw new UserNotExistsException("1");

        System.out.println("调用getInfo服务");

        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println("id: " + id);
    }


}
