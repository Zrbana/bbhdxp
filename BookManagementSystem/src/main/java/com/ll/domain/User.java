package com.ll.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 用户信息
 */
public class User implements Serializable {

    private Integer rid;
    private String username;
    private String password;
    private String rights;
    private List<Record> records;

    public Integer getRid() {
        return rid;
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

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        if (this.rights == null) {
            this.rights = rights;
        }
    }

    public List<Record> getRecords() {
        return records;
    }

    @Override
    public String toString() {
        return "User{" +
                "rid=" + rid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rights='" + rights + '\'' +
                ", records=" + records +
                '}';
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
