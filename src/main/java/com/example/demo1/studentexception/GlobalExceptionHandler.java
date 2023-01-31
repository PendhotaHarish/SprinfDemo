package com.example.demo1.studentexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(InvalidEntryException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorInfo invalidEntry(InvalidEntryException e, HttpServletRequest req)
    {
        return new ErrorInfo((HttpStatus.NOT_FOUND.value()),req.getRequestURI(),e.getMessage());
    }
    @ExceptionHandler(EmptyListException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorInfo EmptyListException(EmptyListException e, HttpServletRequest req){
        return new ErrorInfo((HttpStatus.NOT_FOUND.value()),req.getRequestURI(),e.getMessage());
    }
}
