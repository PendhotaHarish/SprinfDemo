package com.example.demo1.studentexception;

public class EmptyListException extends RuntimeException
{
    public EmptyListException(String msg)
    {
        super(msg);
    }
}
