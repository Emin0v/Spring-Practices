package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateReqDto {

    private String name;
    private String surname;
    private String username;
    private String password;
    private AddressCreateReqDto address;
}
