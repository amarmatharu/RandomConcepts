package com.bdna.automation.dao.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/spring-servlet-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OracleDaoImplTest {

	@Autowired
	private OracleDaoImpl oracleDaoImpl;
	@Autowired
	private OracleDaoImplSecondary oracleDaoImplSecondary;

	@Test
	public void getAllTableName() {
		/*List<String> tableNames = oracleDaoImpl.getAllTableName();
		for (String name : tableNames) {
			System.out.println("Table names: " + name);
		}*/
		System.out.println("------------SECONDARY-----------------");
		List<String> tableNamesSecondary = oracleDaoImplSecondary.getAllTableName();
		for (String name : tableNamesSecondary) {
			oracleDaoImplSecondary.getCount("Select count(*) from  "  + name);
			System.out.println("Table names Secondary: " + name);
		}
		
		

	}

}
