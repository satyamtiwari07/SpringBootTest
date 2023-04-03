package com.mapping.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="drivers")
public class Drivers {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="id")
        Integer id;

        @Column(name="firstname")
        String firstname;

        @Column(name="lastname")
        String lastname;

        @Column(name="description")
        String des;

        @OneToOne(cascade = CascadeType.ALL)
        Vehicals v;

        @OneToMany(mappedBy="driver",cascade = CascadeType.ALL)
        List<Phone> phoneList = new ArrayList<>();


        public Drivers() {
        }

        public Drivers(String firstname, String lastname, String des) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.des = des;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public Vehicals getV() {
            return v;
        }

        public void setV(Vehicals v) {
            this.v = v;
        }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
            return "Drivers{" +
                    "id=" + id +
                    ", firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", des='" + des + '\'' +
                    '}';
    }
}

