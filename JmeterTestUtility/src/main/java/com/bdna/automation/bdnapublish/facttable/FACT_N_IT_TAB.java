package com.bdna.automation.bdnapublish.facttable;import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;import org.apache.jmeter.samplers.SampleResult;import com.bdna.automation.service.FactTableService;import com.bdna.automation.template.BaseTestCase;public class FACT_N_IT_TAB extends BaseTestCase{	private static final long serialVersionUID = 1L;	public SampleResult runTest(JavaSamplerContext context) {		boolean result = false;		SampleResult results = new SampleResult();		try {			setupValues(context);			results.sampleStart();			result = new FactTableService().getCount(this.getClass().getSimpleName());		} catch (Exception e) {			e.printStackTrace();		} finally {			results.setSuccessful(result);		}		listParameters(context);		return results;	}}