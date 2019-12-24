package com.imooc.dto;

/**
 * @author 何国锋
 * @date 2019-12-21 10:53
 */
public class UserQueryCondition {

    private String username;

    private int age;

    private int ageTo;

    private int xxx;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public int getXxx() {
        return xxx;
    }

    public void setXxx(int xxx) {
        this.xxx = xxx;
    }

    @Override
    public String toString() {
        return "UserQueryCondition{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", ageTo=" + ageTo +
                ", xxx=" + xxx +
                '}';
    }
}
