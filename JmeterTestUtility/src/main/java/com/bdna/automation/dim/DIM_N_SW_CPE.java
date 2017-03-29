package com.bdna.automation.dim;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import com.bdna.automation.service.DIMService;
import com.bdna.automation.template.BaseTestCase;
import org.springframework.beans.factory.annotation.Autowired;

public class DIM_N_SW_CPE extends BaseTestCase {
	private static final long serialVersionUID = 1L;
	@Autowired
	private DIMService dimService;

	public SampleResult runTest(JavaSamplerContext context) {
		boolean result = false;
		SampleResult results = new SampleResult();
		try {
			setupValues(context);
			results.sampleStart();
			result = dimService.getCount(this.getClass().getSimpleName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			results.setSuccessful(result);
		}
		System.out.println(whoAmI() + "\trunTest():" + "\tTime:\t" + results.getTime());
		listParameters(context);
		return results;
	}
}