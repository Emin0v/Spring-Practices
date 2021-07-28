package com.company.service;

import com.company.dto.UserCreateReqDto;
import com.company.dto.UserRespDto;

import java.util.List;

public interface UserService {

    List<UserRespDto> getAll();

    List<UserRespDto> getAll(int pageNo, int pageSize);

    UserRespDto findByUsername(String username);

    UserRespDto add(UserCreateReqDto userCreateReqDto);

    void delete(String uuid);
}
