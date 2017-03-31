package com.bdna.automation.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/spring-servlet-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class DimTableServiceTest {
	
	@Autowired
	private DimTableService dimTableService;
	
	@Test
	public void getCount() throws ClassNotFoundException, SQLException  {
		
		boolean result = dimTableService.getCount("DIM_N_ALL_CONNECT_AS_TAB");
		assertEquals(true, result);
		
	}

}
