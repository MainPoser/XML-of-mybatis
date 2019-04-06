package com.lovejava.domain;

import java.util.List;

/**
 * @author:tianyao
 * @date:2019-04-04 14:33
 */
public class Role {
    private Integer id;
    private String work;
    private String address;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
                ", users=" + users +
                '}';
    }
}
