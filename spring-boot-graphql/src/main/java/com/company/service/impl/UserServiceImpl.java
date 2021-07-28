package com.company.service.impl;

import com.company.dto.AddressRespDto;
import com.company.dto.UserCreateReqDto;
import com.company.dto.UserRespDto;
import com.company.model.User;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import com.company.service.adapter.AddressAdapter;
import com.company.service.adapter.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserAdapter userAdapter;
    private final AddressAdapter addressAdapter;

    @Override
    public List<UserRespDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> {
                    UserRespDto userRespDto = userAdapter.map(user);
                    userRespDto.setAddress(addressAdapter.map(user.getAddress()));
                    return userRespDto;
                }).collect(Collectors.toList());

    }

    @Override
    public List<UserRespDto> getAll(int pageNo, int pageSize) {
        List<User> users = userRepository
                .findAll(PageRequest.of(pageNo,pageSize))
                .getContent();

        return users
                .stream()
                .map(user -> {
                    UserRespDto userRespDto = userAdapter.map(user);
                    userRespDto.setAddress(addressAdapter.map(user.getAddress()));
                    return userRespDto;
                }).collect(Collectors.toList());

    }

    @Override
    public UserRespDto findByUsername(String username) {


        return null;
    }

    @Override
    public UserRespDto add(UserCreateReqDto userCreateReqDto) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }
}
