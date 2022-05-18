package com.alex.converter.controller;

import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
  
  @ExceptionHandler(value={NullPointerException.class, IOException.class})
  public String testException(Exception ex, Model model){
    model.addAttribute("ex", ex);
    return "error";
  }
}
