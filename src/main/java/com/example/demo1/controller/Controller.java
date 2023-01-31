package com.example.demo1.controller;

import com.example.demo1.model.Student;
import com.example.demo1.service.Service;
import com.example.demo1.service.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Student> getDetail()
    {
        log.info("Student details get successful");
        return service.getDetails();
    }
    @GetMapping("/student/getById/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Student getById(@PathVariable int studentId)
    {
        log.info("Student details get by StudentId successful");
        return service.getById(studentId);
    }
    @PostMapping("/createStudents")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student)
    {
        List<Student> students=new ArrayList<>();
        log.info("Student details are create successful");
        return service.addDetails(student);
    }
    @GetMapping("/student/getByBranch/{studentBranch}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getByBranch(@PathVariable String studentBranch)
    {
        log.info("Student details get by StudentBranch successful");
        return service.getByBranch(studentBranch);
    }
    @PutMapping("/student/updateDetails/{studentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Student updateStudent(@PathVariable int studentId,@RequestBody Student student)
    {
        log.info("Student details are update successful");
        return service.updateStudent(studentId,student);
    }
    @DeleteMapping("/student/deleteDetails/{studentId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student deleteStudent(@PathVariable int studentId)
    {
        log.info("Student details are deleted successful");
        return service.deleteStudent(studentId);
    }
}
