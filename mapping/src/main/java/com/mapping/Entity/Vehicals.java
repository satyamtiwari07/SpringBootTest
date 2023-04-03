package com.mapping.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Vehicals")
public class Vehicals{

    @Id
    int vid;
    String vehName;
    String vedDesc;


    public Vehicals() {
    }

    public Vehicals(int vid, String vehName, String vedDesc, Drivers drivers) {
        this.vid = vid;
        this.vehName = vehName;
        this.vedDesc = vedDesc;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVehName() {
        return vehName;
    }

    public void setVehName(String vehName) {
        this.vehName = vehName;
    }

    public String getVedDesc() {
        return vedDesc;
    }

    public void setVedDesc(String vedDesc) {
        this.vedDesc = vedDesc;
    }
}
