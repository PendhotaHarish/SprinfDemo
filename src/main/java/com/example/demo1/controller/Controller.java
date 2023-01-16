package com.example.demo1.controller;

import com.example.demo1.model.Student;
import com.example.demo1.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller
{
    @Autowired
    Service service;
    Logger log= LoggerFactory.getLogger(Controller.class);
    @GetMapping("/home")
    public String home()
    {
        return "controller is running";
    }
    @GetMapping("/studentDetails")
    public List<Student> getDetail()
    {
        log.info("Student details get successful");
        return service.getDetails();
    }
    @GetMapping("/student/getById/{studentId}")
    public Student getById(@PathVariable int studentId)
    {
        log.info("Student details get by StudentId successful");
        return service.getById(studentId);
    }
    @PostMapping("/createStudents")
    public Student createStudent(@RequestBody Student student)
    {
        log.info("Student details are create successful");
        Student st=service.addDetails(student);
        return st;
    }
    @GetMapping("/student/getByBranch/{studentBranch}")
    public List<Student> getByBranch(@PathVariable String studentBranch)
    {
        log.info("Student details get by StudentBranch successful");
        return service.getByBranch(studentBranch);
    }
    @PutMapping("/student/updateDetails/{studentId}")
    public Student updateStudent(@PathVariable int studentId,@RequestBody Student student)
    {
        log.info("Student details are update successful");
        return service.updateStudent(studentId, student);
    }
    @DeleteMapping("/student/deleteDetails/{studentId}")
    public Student deleteStudent(@PathVariable int studentId)
    {
        log.info("Student details are deleted successful");
        return service.deleteStudent(studentId);
    }
}
