package com.company.service.impl;

import com.company.dto.UserDto;
import com.company.exception.UserNotFoundException;
import com.company.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<UserDto> list = new ArrayList<>();

    @PostConstruct
    private void init(){
        list.add(new UserDto(1L,"Mahammad","mahammademinov"));
        list.add(new UserDto(2L,"Test","test"));
        list.add(new UserDto(3L,"Test1","test1"));
    }

    @Override
    public UserDto findByName(String name) {
        return list.stream().filter(userDto -> {
           return userDto.getName().equals(name);
        }).findFirst().orElseThrow(UserNotFoundException::new);
    }
}
