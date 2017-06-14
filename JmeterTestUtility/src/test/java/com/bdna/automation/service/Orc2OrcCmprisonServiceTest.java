package com.bdna.automation.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/spring-servlet-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Orc2OrcCmprisonServiceTest {
	
	@Autowired private Orc2OrcCmprisonService orc2OrcCmprisonService;
	
	@Test
	public void fetchAndCompareCount()
	{
		orc2OrcCmprisonService.fetchAndCompareCount();
	}

}
