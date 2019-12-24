package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyConstraint;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author 何国锋
 * @date 2019-12-08 17:15
 */
public class User {


    //声明JsonView所需接口
    public interface  UserSimpleView {};
    public interface UserDetailView extends UserSimpleView{};

    private String id;

    @Past(message = "生日必须是过去的时间")
    private Date birthday;


    @MyConstraint(message = "默认值")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    //get方法指定获取他的视图，详细接口已经继承简单接口，所以详细接口无需再度声明了
    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", birthday=" + birthday +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
