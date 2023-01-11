package com.example.demo1.service;

import com.example.demo1.model.Student;

import java.util.List;

public interface Service
{
    List<Student> loadStudentDetails();
    List<Student> getDetails();

    public Student getById(int stdId);
    public Student addDetails(Student student);
}
