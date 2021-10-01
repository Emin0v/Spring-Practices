package com.company.service;

import com.company.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto findByName(String name);

    List<UserResponseDto> findAll();
}
