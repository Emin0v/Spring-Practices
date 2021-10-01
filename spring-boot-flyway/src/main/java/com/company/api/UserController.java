package com.company.api;

import com.company.dto.UserResponseDto;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping
    public ResponseEntity<UserResponseDto> getAllByName(@RequestParam(name = "name") String name){
        return ResponseEntity.ok(userService.findByName(name));
    }

}
