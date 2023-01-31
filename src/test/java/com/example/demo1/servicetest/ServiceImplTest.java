package com.example.demo1.servicetest;

import com.example.demo1.controller.Controller;
import com.example.demo1.model.Student;
import com.example.demo1.service.Service;
import com.example.demo1.service.ServiceImpl;
import com.example.demo1.studentexception.EmptyListException;
import com.example.demo1.studentexception.InvalidEntryException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//5@AutoConfigureMockMvc
public class ServiceImplTest
{
    Student student;
    @Autowired
    ServiceImpl serviceimpl;
    //@Autowired
    //MockMvc mockMvc;
    @Autowired
    Service service;
    @Autowired
    Controller controller;
    @BeforeEach
    public void init()
    {
        student=new Student();
        student.setStudentId(123456);
        student.setStudentName("harish");
        student.setStudentMobileNo("9876543210");
        student.setStudentBranch("ECE");
        student.setStudentPercentage(79.8);
    }
    @Order(1)
    @Test
    void getStudentEmptyListTest()
    {
        assertThrows(EmptyListException.class,()->service.getDetails(),"No books present");
    }
    @Order(2)
    @Test
    void addDetailsTest()
    {
        student.setStudentId(12345);
        assertThrows(InvalidEntryException.class,()->service.addDetails(student),"Invalid entry");
    }
    @Order(3)
    @Test
    void studentAlreadyPresent()
    {
        student.setStudentId(123457);
        //service.addDetails(student);
        service.addDetails(student);
        assertThrows(InvalidEntryException.class,()->service.addDetails(student),"same book already present ");
    }
    @Order(4)
    @Test
    void getByIdTest()
    {
        student.setStudentId(123454);
        service.addDetails(student);
        assertThrows(InvalidEntryException.class,()->service.getById(123458),"Invalid entry");
    }
    @Order(5)
    @Test
    void searchByBranch()
    {
        student.setStudentBranch("ECE");
        student.setStudentId(123459);
        student.setStudentPercentage(50);
        service.addDetails(student);
        assertThrows(EmptyListException.class,()->service.getByBranch("cse"),"no student present by this branch");
    }
    @Order(6)
    @Test
    void updateStudentTest()
    {
        student.setStudentId(123450);
        student.setStudentName("hari");
        student.setStudentPercentage(56.9);
        service.addDetails(student);
        //Student actual=service.updateStudent(student.getStudentId(),student);
       // Student expected=service.getById(123450);
        //assertEquals(expected,actual);
        assertThrows(InvalidEntryException.class,()->service.updateStudent(123451,student),"Invalid entry");
    }
    @Order(7)
    @Test
    void deleteStudentTest()
    {
        student.setStudentId(123455);
        service.addDetails(student);
        assertThrows(InvalidEntryException.class,()->service.deleteStudent(123452));
    }
}

