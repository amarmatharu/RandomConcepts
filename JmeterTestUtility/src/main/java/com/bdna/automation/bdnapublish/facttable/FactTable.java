package com.bdna.automation.bdnapublish.facttable;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bdna.automation.service.FactTableService;
import com.bdna.automation.template.BaseTestCase;

@Component
public class FactTable extends BaseTestCase {
	private static final long serialVersionUID = 1L;

	@Autowired
	private FactTableService factTableService;

	public SampleResult runTest(JavaSamplerContext context) {
		boolean result = false;
		SampleResult results = new SampleResult();
		try {
			setupValues(context);
			results.sampleStart();
			result = factTableService.getCount();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			results.setSuccessful(result);
		}
		listParameters(context);
		return results;
	}
}