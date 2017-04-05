package com.bdna.automation.bdnapublish.TEMPLATEPACKAGE;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import com.bdna.automation.service.TEMPLATESERVICE;
import com.bdna.automation.template.BaseTestCase;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component 
public class TEMPLATECLASS extends BaseTestCase{
	private static final long serialVersionUID = 1L;
		                                     
	@Autowired
	private TEMPLATESERVICE VARIABLESERVICE;
	
	public SampleResult runTest(JavaSamplerContext context) {
		boolean result = false;

		SampleResult results = new SampleResult();
		try {
			setupValues(context);
			results.sampleStart();
			result = VARIABLESERVICE.getCount(this.getClass().getSimpleName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			results.setSuccessful(result);
		}
		listParameters(context);
		return results;
	}
}
