package com.alex.helloworld2.bean;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Component
@Data
@ToString
public class Pet {
  private String name;
	private Double weight;
}
