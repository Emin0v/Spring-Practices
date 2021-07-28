package com.company.api;

import com.company.dto.UserCreateReqDto;
import com.company.dto.UserRespDto;
import com.company.service.UserService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMutationResolver implements GraphQLMutationResolver {

    private final UserService userService;

    public UserRespDto add(UserCreateReqDto userCreateReqDto){
        return userService.add(userCreateReqDto);
    }

    public void delete(String uuid){
        userService.delete(uuid);
    }
}
