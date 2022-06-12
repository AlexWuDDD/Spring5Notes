package com.alex.webadmin;


import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class WebadminApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() {
		Long aLong = jdbcTemplate.queryForObject("select count(*) from tbl_dept", Long.class);
		log.info("记录总数：{}", aLong);

		log.info("数据源类型：{}", dataSource.getClass());
	
	}

}
