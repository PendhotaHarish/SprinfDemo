package com.example.demo1.controller;

import com.example.demo1.model.Student;
import com.example.demo1.service.Service;
import com.example.demo1.service.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
class ControllerTest
{
    Student student;
    @Autowired
    Service service;
    @Autowired
    ServiceImpl serviceImpl;
    @Autowired
    MockMvc mockMvc;
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
    void createStudentTest() throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        //student.setStudentId(123457);
        this.mockMvc.perform(post("/api/createStudents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(student)))
                        .andExpect(status().isCreated());
    }

    @Order(2)
    @Test
    void getByIdTest() throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        student.setStudentId(123451);
        student.setStudentName("hari");
        student.setStudentMobileNo("9876543219");
        service.addDetails(student);
        this.mockMvc.perform(get("/api/student/getById/123451")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(123451)))
                        .andExpect(status().isOk());
    }
    @Order(3)
    @Test
    void getDetailTest() throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        student.setStudentId(123452);
        student.setStudentName("harish");
        student.setStudentMobileNo("9876543212");
        student.setStudentBranch("ECE");
        student.setStudentPercentage(79.8);
        service.addDetails(student);
        this.mockMvc.perform(get("/api/studentDetails")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(student)))
                .andExpect(status().isAccepted());
    }
    @Order(4)
    @Test
    void getByBranchTest() throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        student.setStudentId(123453);
        student.setStudentName("harish");
        student.setStudentMobileNo("9876543212");
        student.setStudentBranch("ECE");
        student.setStudentPercentage(79.8);
        service.addDetails(student);
        this.mockMvc.perform(get("/api/student/getByBranch/ECE")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }
    @Order(5)
    @Test
    void updateStudentTest() throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        student.setStudentId(123455);
        student.setStudentName("harish");
        student.setStudentMobileNo("9876543212");
        student.setStudentBranch("ECE");
        student.setStudentPercentage(79.8);
        service.addDetails(student);
        this.mockMvc.perform(put("/api/student/updateDetails/123455")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(student)))
                .andExpect(status().isCreated());
    }
    @Order(6)
    @Test
    void deleteStudentTest() throws Exception
    {
        ObjectMapper mapper=new ObjectMapper();
        student.setStudentId(123454);
        student.setStudentName("harish");
        student.setStudentMobileNo("9876543212");
        student.setStudentBranch("ECE");
        student.setStudentPercentage(79.8);
        service.addDetails(student);
        this.mockMvc.perform(delete("/api/student/deleteDetails/123454")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(student)))
                .andExpect(status().isAccepted());
    }
}