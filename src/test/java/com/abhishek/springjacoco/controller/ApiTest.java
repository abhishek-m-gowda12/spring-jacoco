package com.abhishek.springjacoco.controller;

import com.abhishek.springjacoco.dto.Student;
import com.abhishek.springjacoco.service.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

class ApiTest {

    Api api;

    @Mock
    StudentServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        api = new Api(service);
    }

    @Test
    void getById() {

        Mockito.when(service.getById("1"))
                .thenReturn(new Student("1", "JOHN", 21));

        ResponseEntity<Student> responseEntity = api.getById("1");

        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals("1", responseEntity.getBody().getId());
    }

    @Test
    void getAll() {
    }
}