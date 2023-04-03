package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class driver {
    private String dname;
    private int Id;
    private int Mnum;


    @Autowired
    private mobile m;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getMnum() {
        return Mnum;
    }

    public void setMnum(int mnum) {
        Mnum = mnum;
    }
    public void show(){
        System.out.println(dname);
        System.out.println(Id);
        System.out.println(Mnum);
        System.out.println(m.getConfiguration());
        System.out.println(m.getName());

    }
}
