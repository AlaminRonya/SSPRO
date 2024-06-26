package com.alamin.testdemo.service;

import com.alamin.testdemo.model.Student;

import java.util.List;

/**
 * @author Ml Amin
 */

public interface IStudentService {
    Student addStudent(Student student);
    List<Student> getStudents();
    Student updateStudent(Student student, Long id);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
}