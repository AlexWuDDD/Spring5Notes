package com.alex.webadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //扫描s自定义ervlet组件
@SpringBootApplication
public class WebadminApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebadminApplication.class, args);
	}

}
