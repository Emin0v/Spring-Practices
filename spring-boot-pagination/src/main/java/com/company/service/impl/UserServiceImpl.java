package com.company.service.impl;

import com.company.dto.UserCreateReqDTO;
import com.company.dto.UserRespDTO;
import com.company.entity.User;
import com.company.repository.UserRepository;
import com.company.results.DataResult;
import com.company.results.Result;
import com.company.results.SuccessDataResult;
import com.company.service.UserService;
import com.company.service.adapter.UserAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserAdapter userAdapter;

    @Override
    public DataResult<List<UserRespDTO>> getAll(Integer pageNo, Integer pageSize) {

        List<User> user = userRepository
                .findAll(PageRequest.of(pageNo, pageSize))
                .getContent();

        return new SuccessDataResult<List<UserRespDTO>>
                (userAdapter.map(user), "successfully paged");
    }

    @Override
    public DataResult<List<UserRespDTO>> getAllSorted() {
        List<User> user = userRepository
                .findAll(Sort.by(Sort.Direction.ASC, "name"));

        return new SuccessDataResult<List<UserRespDTO>>
                (userAdapter.map(user), "successfully sorted");
    }

    @Override
    @Transactional
    public Result add(UserCreateReqDTO userCreateReqDTO) {

        User userDb = userRepository
                .save(userAdapter.map(userCreateReqDTO));

        return new Result(true, "successfully added");
    }

    @Override
    public DataResult<UserRespDTO> findByUsername(String username) {
        User user = userRepository.findByUsername(username).get();

        return new SuccessDataResult<UserRespDTO>
                (userAdapter.map(user));
    }

    @Override
    @Transactional
    public Result delete(String uuid) {
        User user = userRepository.findByUuid(uuid);
        userRepository.delete(user);

        return new Result(true, "successfully deleted");
    }
}
