package com.company.service;

import com.company.dto.StudentRequestDTO;
import com.company.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {

    List<StudentResponseDTO> getAll();

    StudentResponseDTO findById(String id);

    StudentResponseDTO add(StudentRequestDTO studentRequestDTO);

    void delete(String id);
}
