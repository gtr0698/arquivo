package com.arquivo.csv.arquivo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String action;
    private Integer idnumber;
    private String user;
    private String rolekey;
    private Integer status;

    public Enroll(String action, Integer idnumber, String user, String rolekey, Integer status) {
        this.action = action;
        this.idnumber = idnumber;
        this.user = user;
        this.rolekey = rolekey;
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public Integer getIdnumber() {
        return idnumber;
    }

    public String getUser() {
        return user;
    }

    public String getRolekey() {
        return rolekey;
    }

    public Integer getStatus() {
        return status;
    }

    public Enroll() {
    }
}
