package com.example.demo1.service;

import com.example.demo1.model.Student;

import java.util.List;

public interface Service
{
    List<Student> getDetails();

    Student getById(int stdId);
    Student addDetails(Student student);
    List<Student> getByBranch(String sBranch);
    Student updateStudent(int stId, Student student);
    Student deleteStudent(int sId);
}
