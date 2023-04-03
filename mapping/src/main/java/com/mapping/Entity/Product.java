package com.mapping.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Product")
public class Product {


    @Id
    private String pid;
    private String pName;

    @ManyToMany(mappedBy="products")
    List<Category>categories = new ArrayList<>();

    public Product(String pid, String pName) {
        this.pid = pid;
        this.pName = pName;
    }

    public Product() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
