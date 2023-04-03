package com.mapping.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Category")
public class Category {

    @Id
    private String cid;
    private  String cname;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();



    public Category() {
    }

    public Category(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
