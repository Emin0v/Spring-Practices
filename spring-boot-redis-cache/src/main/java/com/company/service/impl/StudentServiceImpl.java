package com.company.service.impl;

import com.company.dto.StudentRequestDTO;
import com.company.dto.StudentResponseDTO;
import com.company.entity.Student;
import com.company.repository.StudentRepository;
import com.company.service.StudentService;
import com.company.service.adapter.StudentAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentAdapter studentAdapter;

    @Override
    @Cacheable(cacheNames = "studentCache")
    public List<StudentResponseDTO> getAll() {
        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<StudentResponseDTO> responseDTOS
                = new ArrayList<>();
        studentRepository.findAll()
                .forEach(student -> {
                   responseDTOS.add(studentAdapter.map(student));
                });

        return responseDTOS;
    }

    @Override
    public StudentResponseDTO findById(String id) {
        return studentAdapter.map(studentRepository.findById(id).get());
    }

    @Override
    @Transactional
    public StudentResponseDTO add(StudentRequestDTO studentRequestDTO) {
        Student studentDb = studentRepository
                .save(studentAdapter.map(studentRequestDTO));

        return studentAdapter.map(studentDb);
    }

    @Override
    @Transactional
    public void delete(String id) {
         studentRepository.delete(studentRepository.findById(id).get());
         clearCache();
    }

    @CacheEvict(cacheNames = "studentCache")
    public void clearCache(){
        System.out.println("Cache cleared");
    }
}
