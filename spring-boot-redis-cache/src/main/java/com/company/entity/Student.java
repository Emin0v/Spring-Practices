package com.company.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student implements Serializable {

    @Id
    private String id;
    private String name;
    private String username;
    private String password;
    private Gender gender;
    private int grade;

}
