package com.bdna.automation.bdnapublish.aggtable;

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

import com.bdna.automation.bdnapublish.testcases.Oracle2Oracle;

@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/spring-servlet-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Oracle2OracleTest {

	@Autowired
	private Oracle2Oracle oracle2Oracle;

	@Test
	public void runTest() {

		JavaSamplerContext context = new JavaSamplerContext(new Arguments());
		SampleResult result = oracle2Oracle.runTest(context);
		System.out.println("Result:" + Boolean.valueOf(result.getResponseDataAsString()));
		assertEquals(true, Boolean.valueOf(result.getResponseDataAsString()));

	}

}
