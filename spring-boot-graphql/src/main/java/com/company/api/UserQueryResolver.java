package com.company.api;

import com.company.dto.UserRespDto;
import com.company.service.UserService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserQueryResolver implements GraphQLQueryResolver {

    private final UserService userService;

    public List<UserRespDto> getAll(){
        return userService.getAll();
    }

    public List<UserRespDto> getAll(int pageNo, int pageSize){
        return userService.getAll(pageNo,pageSize);
    }

    public UserRespDto findByUsername(String username){
        return userService.findByUsername(username);
    }

}
