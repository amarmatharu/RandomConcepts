package com.bdna.automation.bdnapublish.dimtable;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bdna.automation.service.DimTableService;
import com.bdna.automation.template.BaseTestCase;

@Component
public class DIM_N_SW_LIC_ADDITIONAL_SW_TAB extends BaseTestCase {
	private static final long serialVersionUID = 1L;
	@Autowired
	private DimTableService dimTableService;

	public SampleResult runTest(JavaSamplerContext context) {
		boolean result = false;
		SampleResult results = new SampleResult();
		try {
			setupValues(context);
			results.sampleStart();
			result = dimTableService.getCount(this.getClass().getSimpleName());
=======
import com.bdna.automation.service.DimTableService;
import com.bdna.automation.template.BaseTestCase;

public class DIM_N_SW_LIC_ADDITIONAL_SW_TAB extends BaseTestCase {
	private static final long serialVersionUID = 1L;

	public SampleResult runTest(JavaSamplerContext context) {
		boolean result = false;
		SampleResult results = new SampleResult();
		try {
			setupValues(context);
			results.sampleStart();
			result = new DimTableService().getCount(this.getClass().getSimpleName());
>>>>>>> branch 'master' of git@github.com:bdna/UtiltiyProjects.git
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			results.setSuccessful(result);
		}
		listParameters(context);
		return results;
	}
}