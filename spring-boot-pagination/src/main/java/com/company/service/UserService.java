package com.company.service;

import com.company.dto.UserCreateReqDTO;
import com.company.dto.UserRespDTO;
import com.company.entity.User;
import com.company.results.DataResult;
import com.company.results.Result;

import java.util.List;
import java.util.Optional;

public interface UserService {

    DataResult<List<UserRespDTO>> getAll(Integer pageNo, Integer pageSize);

    DataResult<List<UserRespDTO>> getAllSorted();

    Result add(UserCreateReqDTO userCreateReqDTO);

    DataResult<UserRespDTO> findByUsername(String username);

    Result delete(String uuid);

}
