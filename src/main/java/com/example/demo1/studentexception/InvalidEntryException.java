package com.example.demo1.studentexception;

public class InvalidEntryException extends RuntimeException
{
    public InvalidEntryException(String msg)
    {
        super(msg);
    }
}
