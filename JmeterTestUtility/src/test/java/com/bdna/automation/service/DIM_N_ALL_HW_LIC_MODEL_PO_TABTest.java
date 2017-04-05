package com.bdna.automation.service;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bdna.automation.bdnapublish.dimtable.DIM_N_ALL_HW_LIC_MODEL_PO_TAB;

@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/spring-servlet-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class DIM_N_ALL_HW_LIC_MODEL_PO_TABTest {
	
	
@Autowired DIM_N_ALL_HW_LIC_MODEL_PO_TAB dimNAll;
	
	@Test
	public void runTest()
	{
		
		
		JavaSamplerContext context = new JavaSamplerContext(new Arguments());
		dimNAll.runTest(context);
	}


}
