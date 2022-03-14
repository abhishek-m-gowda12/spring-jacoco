package com.abhishek.springjacoco.controller;

import com.abhishek.springjacoco.dto.Student;
import com.abhishek.springjacoco.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class Api {

    private final StudentServiceImpl service;

    public Api(StudentServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getById(@PathVariable("id") String id) {

        Student student = service.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAll() {

        List<Student> students = service.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
}
