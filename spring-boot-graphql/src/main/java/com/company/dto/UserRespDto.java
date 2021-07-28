package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRespDto {

    private Long id;
    private String uuid;
    private String name;
    private String surname;
    private String username;
    private AddressRespDto address;

}
