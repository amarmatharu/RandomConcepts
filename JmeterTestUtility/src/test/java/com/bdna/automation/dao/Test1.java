package com.bdna.automation.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bdna.automation.dao.impl.OracleDaoImpl;

@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/spring-servlet-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Test1 {
	
	
	@Autowired
	private OracleDaoImpl oracleDIMDaoImpl;
	
	@Test
	public void test()
	{
		
	}

}
