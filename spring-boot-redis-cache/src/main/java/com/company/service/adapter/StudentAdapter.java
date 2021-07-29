package com.company.service.adapter;

import com.company.dto.StudentRequestDTO;
import com.company.dto.StudentResponseDTO;
import com.company.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentAdapter {

    Student map(StudentRequestDTO dto);

    StudentResponseDTO map(Student student);
}
