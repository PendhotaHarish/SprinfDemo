package com.example.demo1.controller;

import com.example.demo1.model.Student;
import com.example.demo1.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller
{
    @Autowired
    Service service;
    @GetMapping("/home")
    public String home()
    {
        return "controller is running";
    }
    @GetMapping("/studentDetails")
    public List<Student> getDetail()
    {
        return service.getDetails();
    }
    @GetMapping("/student/getById/{studentId}")
    public Student getById(@PathVariable int studentId)
    {
        return service.getById(studentId);
    }
    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student)
    {
        Student st= service.addDetails(student);
        return st;
    }
}
