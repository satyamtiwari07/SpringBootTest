package com.example.drivername.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drivername")
public class Driver {
    private String desc;
    private Integer exp;
    private String profile;

    public Driver(String desc, Integer exp, String profile) {
        this.desc = desc;
        this.exp = exp;
        this.profile = profile;
    }

    public Driver() {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "desc='" + desc + '\'' +
                ", exp=" + exp +
                ", profile='" + profile + '\'' +
                '}';
    }
}
