package com.bdna.automation.bdnapublish.aggtable;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bdna.automation.service.AggTableService;
import com.bdna.automation.template.BaseTestCase;

<<<<<<< HEAD
@Component
public class AGG_N_IT_HW_TAB extends BaseTestCase {
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
=======
public class AGG_N_IT_HW_TAB extends BaseTestCase {
	private static final long serialVersionUID = 1L;

	public SampleResult runTest(JavaSamplerContext context) {
		boolean result = false;
		SampleResult results = new SampleResult();
		try {
			setupValues(context);
			results.sampleStart();
			result = new AggTableService().getCount(this.getClass().getSimpleName());
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