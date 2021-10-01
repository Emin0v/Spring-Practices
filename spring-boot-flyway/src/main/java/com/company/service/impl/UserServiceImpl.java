package com.company.service.impl;

import com.company.dto.UserResponseDto;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponseDto findByName(String name) {
        return modelMapper.map(userRepository.findByName(name),UserResponseDto.class);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user->modelMapper.map(user,UserResponseDto.class))
                .collect(Collectors.toList());

    }
}
