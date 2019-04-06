package com.lovejava.domain;

import java.io.Serializable;

/**
 * @author:tianyao
 * @date:2019-04-04 14:33
 */
public class Role implements Serializable {
    private Integer id;
    private String work;
    private String address;
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", work='" + work + '\'' +
                ", address='" + address + '\'' +
                ", users=" + user +
                '}';
    }
}
