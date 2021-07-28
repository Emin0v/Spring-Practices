package com.company.service.adapter;

import com.company.dto.AddressCreateReqDto;
import com.company.dto.AddressRespDto;
import com.company.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressAdapter {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "name", source = "dto.name")
    Address map(AddressCreateReqDto dto);

    AddressRespDto map(Address address);
}
