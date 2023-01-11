package com.example.demo1.model;

public class Student
{
    private int studentId;
    private String studentName;
    private String studentMobileNo;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentMobileNo() {
        return studentMobileNo;
    }

    public void setStudentMobileNo(String studentMobileNo) {
        this.studentMobileNo = studentMobileNo;
    }

    public Student(int studentId, String studentName, String studentMobileNo) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMobileNo = studentMobileNo;
    }
}
