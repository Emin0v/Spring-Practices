package com.company.dto;

import com.company.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO extends JdkSerializationRedisSerializer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String username;
    private String password;
    private Gender gender;
    private int grade;

}
