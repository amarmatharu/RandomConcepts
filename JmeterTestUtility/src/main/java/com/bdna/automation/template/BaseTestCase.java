package com.bdna.automation.template;

import java.io.Serializable;
import java.util.Iterator;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;


public abstract class BaseTestCase extends AbstractJavaSamplerClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseTestCase() {
		System.out.println(whoAmI() + "\tConstruct");
	}

	/*
	 * Utility method to set up all the values
	 */
	public void setupValues(JavaSamplerContext context) {
	}

	public void setupTest(JavaSamplerContext context) {
		System.out.println(whoAmI() + "\tsetupTest()");
		listParameters(context);
	}

	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		return params;
	}

	/**
	 * Dump a list of the parameters in this context to the debug log.
	 * 
	 * @param context
	 *            the context which contains the initialization parameters.
	 */
	public void listParameters(JavaSamplerContext context) {
		Iterator<String> argsIt = context.getParameterNamesIterator();
		while (argsIt.hasNext()) {
			String name = (String) argsIt.next();
			System.out.println(name + "=" + context.getParameter(name));
		}

	}

	/**
	 * Generate a String identifier of this test for debugging purposes.
	 * 
	 * @return a String identifier for this test instance
	 */
	public String whoAmI() {
		StringBuffer sb = new StringBuffer();
		sb.append(Thread.currentThread().toString());
		sb.append("@");
		sb.append(Integer.toHexString(hashCode()));
		return sb.toString();
	}

	public abstract SampleResult runTest(JavaSamplerContext arg0);

}
