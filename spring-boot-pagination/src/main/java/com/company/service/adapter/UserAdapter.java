package com.company.service.adapter;

import com.company.dto.UserCreateReqDTO;
import com.company.dto.UserRespDTO;
import com.company.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAdapter {

    User map(UserCreateReqDTO dto);

    UserRespDTO map(User user);

    List<UserRespDTO> map(List<User> user);

}
