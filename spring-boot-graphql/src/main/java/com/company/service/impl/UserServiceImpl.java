package com.company.service.impl;

import com.company.dto.UserCreateReqDto;
import com.company.dto.UserRespDto;
import com.company.model.User;
import com.company.repository.UserRepository;
import com.company.service.UserService;
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

    @Override
    public List<UserRespDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> {
                    return userAdapter.map(user);
                }).collect(Collectors.toList());

    }

    @Override
    public List<UserRespDto> getAll(int pageNo, int pageSize) {
        List<User> users = userRepository
                .findAll(PageRequest.of(pageNo, pageSize))
                .getContent();

        return users
                .stream()
                .map(user -> {
                    return userAdapter.map(user);
                }).collect(Collectors.toList());

    }

    @Override
    public UserRespDto findByUsername(String username) {
        return userAdapter.map(
                userRepository.findByUsername(username));
    }

    @Override
    public UserRespDto add(UserCreateReqDto userCreateReqDto) {
        User user = userRepository.save(userAdapter.map(userCreateReqDto));
        return userAdapter.map(user);
    }
    @Override
    public void delete(String uuid) {
        userRepository.findByUuid(uuid);
    }
}
