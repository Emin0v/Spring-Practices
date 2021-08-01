package com.company.api;

import com.company.dto.UserCreateReqDTO;
import com.company.dto.UserRespDTO;
import com.company.results.DataResult;
import com.company.results.Result;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<DataResult<List<UserRespDTO>>>
    getAll(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return ResponseEntity.ok(userService.getAll(pageNo,pageSize));
    }

    @GetMapping("/sorted")
    public ResponseEntity<DataResult<List<UserRespDTO>>> getAllSorted() {
        return ResponseEntity.ok(userService.getAllSorted());
    }

   @GetMapping("/findByUsername")
   public ResponseEntity<DataResult<UserRespDTO>>
   findByUsername(@RequestParam String username){
        return ResponseEntity.ok(userService.findByUsername(username));
   }

    @PostMapping
    public ResponseEntity<Result> add(@RequestBody UserCreateReqDTO userCreateReqDTO){
        return ResponseEntity.ok(userService.add(userCreateReqDTO));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Result> delete(@PathVariable("uuid") String uuid){
        return ResponseEntity.ok(userService.delete(uuid));
    }


}
