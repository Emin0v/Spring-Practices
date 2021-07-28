package com.company.service.adapter;

import com.company.dto.UserCreateReqDto;
import com.company.dto.UserRespDto;
import com.company.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserAdapter {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "surname", source = "dto.surname")
    @Mapping(target = "username", source = "dto.username")
    @Mapping(target = "password", source = "dto.password")
    @Mapping(target = "address", ignore = true)
    User map(UserCreateReqDto dto);

    @Mapping(target = "address", ignore = true)
    UserRespDto map(User user);

}
