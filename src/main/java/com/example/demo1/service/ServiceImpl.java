package com.example.demo1.service;


import com.example.demo1.model.Student;
import com.example.demo1.studentexception.EmptyListException;
import com.example.demo1.studentexception.InvalidEntryException;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    public List<Student> listStudent = new ArrayList<Student>();
    @Override
    public List<Student> getDetails() {
        if (listStudent.isEmpty()) {
            throw new EmptyListException("there are no students details");
        }
        return listStudent;
    }

    @Override
    public Student getById(int stdId) {
        Student student = null;
        for (Student s : listStudent) {
            if (stdId == s.getStudentId()) {
                student = s;
                break;
            }
        }
        if (student == null) {
            throw new InvalidEntryException("You entered invalid studentId " + stdId);
        }
        return student;
    }

    @Override
    public Student addDetails(Student student)
    {
        for (Student std : listStudent) {
            if (student.getStudentId() == std.getStudentId()) {
                throw new InvalidEntryException("These studentId already exist");
            }
        }
        String str = String.valueOf(student.getStudentId());
        if (str.length() != 6) {
            throw new InvalidEntryException("Student must contain six digits");
        }
        if ((student.getStudentName().length() < 4)){
            throw new InvalidEntryException("studentName must contain 4 and more than 4");
        }
        if (student.getStudentPercentage() < 50) {
            throw new InvalidEntryException("These students are failed");
        }
        else
        {
            listStudent.add(student);
        }

        return student;
    }

    @Override
    public List<Student> getByBranch(String sBranch) {
        List<Student> listStudents = new ArrayList<>();
        for (Student std : listStudent) {
            if (std.getStudentBranch().equalsIgnoreCase(sBranch)) {
                listStudents.add(std);
            }
        }
        if (listStudents.isEmpty()) {
            throw new EmptyListException("no students present with branch name of : " + sBranch);
        }
        return listStudents;
    }

    @Override
    public Student updateStudent(int stId,Student student) {
        ServiceImpl sImpl = new ServiceImpl();
        Student students=null;
        for (Student std : listStudent) {
            if (std.getStudentId() == stId) {
                std.setStudentId(stId);
                std.setStudentName(student.getStudentName());
                std.setStudentMobileNo(student.getStudentMobileNo());
                std.setStudentBranch(student.getStudentBranch());
                std.setStudentPercentage(student.getStudentPercentage());
                sImpl.addDetails(std);
                students=std;
                break;
            }
        }
        if(students==null)
        {
            throw new InvalidEntryException("you entered invalid studentId are no student is present");
        }
        return students;
    }

    @Override
    public Student deleteStudent(int sId) {
        Student student = null;
        for (Student std : listStudent) {
            if (std.getStudentId() == sId) {
                student = std;
                listStudent.remove(std);
                break;
            }
        }
        if (student == null) {
            throw new InvalidEntryException("you entered invalid studentId are no student is present");
        }
        return student;
    }
}
