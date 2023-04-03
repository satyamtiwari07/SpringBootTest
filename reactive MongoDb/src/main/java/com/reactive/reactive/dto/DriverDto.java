package com.reactive.reactive.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DriverDto {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String desc;


}
