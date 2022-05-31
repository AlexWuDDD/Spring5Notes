package com.alex.web01.bean;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
  private String userName;
  private Integer age;
  private Date birth;
  private Pet pet;
}
