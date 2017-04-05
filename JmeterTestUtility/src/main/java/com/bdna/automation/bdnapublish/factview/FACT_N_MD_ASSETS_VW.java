package com.bdna.automation.bdnapublish.factview;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bdna.automation.service.FactViewService;
import com.bdna.automation.template.BaseTestCase;

@Component
public class FACT_N_MD_ASSETS_VW extends BaseTestCase {
	private static final long serialVersionUID = 1L;
	@Autowired
	private FactViewService factViewService;

	public SampleResult runTest(JavaSamplerContext context) {
		boolean result = false;
		SampleResult results = new SampleResult();
		try {
			setupValues(context);
			results.sampleStart();
			result = factViewService.getCount(this.getClass().getSimpleName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			results.setSuccessful(result);
		}
		listParameters(context);
		return results;
	}
}