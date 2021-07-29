package com.company.api;


import com.company.dto.StudentRequestDTO;
import com.company.dto.StudentResponseDTO;
import com.company.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> add(@RequestBody StudentRequestDTO studentRequestDTO){
        return ResponseEntity.ok(studentService.add(studentRequestDTO));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") String id){
        studentService.delete(id);
        return HttpStatus.OK;
    }

}
