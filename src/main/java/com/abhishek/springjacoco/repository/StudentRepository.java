package com.abhishek.springjacoco.repository;

import com.abhishek.springjacoco.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private static final List<Student> STUDENT_LIST = initializeStudentList();

    private static List<Student> initializeStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("1", "john", 21));
        students.add(new Student("2", "doe", 22));

        return students;
    }

    public Student getById(String id) {
        return STUDENT_LIST.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Student> findAll() {
        return STUDENT_LIST;
    }
}
