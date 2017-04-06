package com.bdna.automation.bdnapublish.facttable;

import static org.junit.Assert.assertEquals;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/spring-servlet-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class FactTableTest {

	@Autowired
	private FactTable factTable;

	@Test
	public void runTest() {

		JavaSamplerContext context = new JavaSamplerContext(new Arguments());
		SampleResult result = factTable.runTest(context);
		System.out.println("Result:" + Boolean.valueOf(result.getResponseDataAsString()));
		assertEquals(true, Boolean.valueOf(result.getResponseDataAsString()));

	}

}
