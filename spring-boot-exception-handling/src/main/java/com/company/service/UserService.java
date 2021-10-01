package com.company.service;

import com.company.dto.UserDto;

public interface UserService {

    UserDto findByName(String name);
}
