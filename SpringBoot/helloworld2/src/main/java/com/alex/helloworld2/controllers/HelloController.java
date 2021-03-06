package com.alex.helloworld2.controllers;

import com.alex.helloworld2.bean.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {

  @Autowired
  Person person;

  @RequestMapping("/person")
  public Person person() {
    log.info(person.getUserName());
    return person;
  }
}
