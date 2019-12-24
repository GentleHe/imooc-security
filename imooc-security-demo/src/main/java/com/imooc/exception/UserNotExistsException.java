package com.imooc.exception;

/**
 * @author 何国锋
 * @date 2019-12-21 19:42
 */
public class UserNotExistsException extends RuntimeException {

    private String id;

    public UserNotExistsException(String id){
        super("user " + id + " not exists");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
