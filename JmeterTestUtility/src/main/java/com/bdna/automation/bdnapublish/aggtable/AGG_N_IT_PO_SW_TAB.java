package com.bdna.automation.bdnapublish.aggtable;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bdna.automation.service.AggTableService;
import com.bdna.automation.template.BaseTestCase;

@Component
public class AGG_N_IT_PO_SW_TAB extends BaseTestCase {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AggTableService aggTableService;

	public SampleResult runTest(JavaSamplerContext context) {
		boolean result = false;
		SampleResult results = new SampleResult();
		try {
			setupValues(context);
			results.sampleStart();
			result = aggTableService.getCount(this.getClass().getSimpleName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			results.setSuccessful(result);
		}
		listParameters(context);
		return results;
	}
}