package com.example.demo1.service;


import com.example.demo1.model.Student;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service
{
    @Override
    public List<Student> loadStudentDetails()
    {
        List<Student> sList=new ArrayList<Student>();
        sList.add(new Student(123,"harish","9876654323"));
        sList.add(new Student(124,"Raju","8766543239"));
        return sList;
    }
    List<Student> listStudent=loadStudentDetails();

    /*List<Student> listStudent=List.of(new Student(123,"harish","9876654323"),
                new Student(124,"pendhota","9807654321"));*/
    @Override
    public List<Student> getDetails() {
        return listStudent;
    }

    @Override
    public Student getById(int stdId)
    {
        for(Student s:listStudent)
        {
            if(stdId==s.getStudentId())
            {
                return s;
            }
        }
        return null;
    }

    @Override
    public Student addDetails(Student student)
    {
        listStudent.add(student);
        return student;
    }
}
