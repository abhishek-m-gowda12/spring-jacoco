package com.abhishek.springjacoco.service;

import com.abhishek.springjacoco.dto.Student;
import com.abhishek.springjacoco.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getById(String id) {
        return studentRepository.getById(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
