package com.example.realTemp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.*;

@Entity
@Table(name = "driver_details")
@Getter
@Setter
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Drivers extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="driver_id")
    UUID id;

    @Column(name="driver_firstName")
    @NotBlank(message = "First Name Should Not be Empty")
    @NotNull(message = "Name Should Not be Null")
    String fName;

    @Column(name="driver_lastName")
    String lName;

    @Column(name="driver_age")
    @Min(value = 18 , message="Invalid Age : Equal to 17 or less than 17")
    int age;

    @Column(name="driver_info")
    @NotBlank
    String description;

    @Column(name="driver_email")
    @Email(message = "Email should be proper")
    String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Vehical> vehicals = new ArrayList<>();

    public Drivers() {
    }

    public Drivers(UUID id, String fName, String lName, int age, String description) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.description = description;
    }

    public List<Vehical> getVehicals() {
        return vehicals;
    }

    public void setVehicals(List<Vehical> vehicals) {
        this.vehicals = vehicals;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void addlist(Vehical v){
        vehicals.add(v);
    }

}
