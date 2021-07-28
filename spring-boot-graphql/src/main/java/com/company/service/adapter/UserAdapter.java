package com.company.service.adapter;

import com.company.dto.AddressCreateReqDto;
import com.company.dto.AddressRespDto;
import com.company.dto.UserCreateReqDto;
import com.company.dto.UserRespDto;
import com.company.model.Address;
import com.company.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserAdapter {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
//    @Mapping(target = "name", source = "dto.name")
//    @Mapping(target = "surname", source = "dto.surname")
//    @Mapping(target = "username", source = "dto.username")
//    @Mapping(target = "password", source = "dto.password")
//    @Mapping(target = "address", source = "dto.address")
    User map(UserCreateReqDto dto);

    UserRespDto map(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
//    @Mapping(target = "name", source = "dto.name")
    Address map(AddressCreateReqDto addressCreateReqDto);

    AddressRespDto map(Address address);

}
