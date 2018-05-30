package com.victorzhang.learn.distributed.serialize;

import java.io.Serializable;

/**
 * 人物对象,进行序列化必须实现Serializable接口，否则报java.io.NotSerializableException
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-05-30 15:57:08
 */
public class Person implements Serializable {

    private String username;
    private String password;

    public Person() {}

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
