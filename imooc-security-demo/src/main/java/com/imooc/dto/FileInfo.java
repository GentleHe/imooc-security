package com.imooc.dto;

/**
 * @author 何国锋
 * @date 2019-12-23 21:34
 */
public class FileInfo {

    private String path;


    public FileInfo(String path) {
        this.path = path;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
