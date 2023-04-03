package com.reactive.reactive.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "drivers_details")
public class Driver {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String desc;

}
