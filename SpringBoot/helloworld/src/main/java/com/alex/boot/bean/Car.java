package com.alex.boot.bean;

import java.util.Objects;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 */
@NoArgsConstructor //无参构造器
@AllArgsConstructor //全参构造器
@ToString  //to string 方法
@Data //get  set
@EqualsAndHashCode //hashcode
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
  
  private String brand;
  private Integer price;
}
