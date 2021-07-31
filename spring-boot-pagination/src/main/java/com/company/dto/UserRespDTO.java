package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRespDTO {

    private Long id;
    private String uuid;
    private String name;
    private String surname;
    private String username;
}
