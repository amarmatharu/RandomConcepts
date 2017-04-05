package com.bdna.automation.bdnapublish.dimtable;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import com.bdna.automation.service.DimTableService;
import com.bdna.automation.template.BaseTestCase;

public class DIM_N_TPC_UUID_ALL_TAB extends BaseTestCase {
	private static final long serialVersionUID = 1L;

	public SampleResult runTest(JavaSamplerContext context) {
		boolean result = false;
		SampleResult results = new SampleResult();
		try {
			setupValues(context);
			results.sampleStart();
			result = new DimTableService().getCount(this.getClass().getSimpleName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			results.setSuccessful(result);
		}
		listParameters(context);
		return results;
	}
}