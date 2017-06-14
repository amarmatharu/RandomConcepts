package com.bdna.automation.bdnapublish.testcases;

import java.util.ArrayList;
import java.util.List;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockServletContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.bdna.automation.entity.MapCompareResult;
import com.bdna.automation.entity.MapCountObject;
import com.bdna.automation.service.Orc2OrcCmprisonService;
import com.bdna.automation.template.BaseTestCase;

@Component
public class Oracle2Oracle extends BaseTestCase {
	private static final long serialVersionUID = 1L;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	public SampleResult runTest(JavaSamplerContext context) {
		MapCompareResult mapResult = new MapCompareResult();
		SampleResult results = new SampleResult();

		XmlWebApplicationContext ctx = new XmlWebApplicationContext();
		ctx.setConfigLocations(new String[] { "classpath:/spring-servlet-context.xml" });
		ctx.setServletContext(new MockServletContext(""));
		ctx.refresh();
		Orc2OrcCmprisonService orc2OrcCmprisonService = (Orc2OrcCmprisonService) ctx.getBean("orc2OrcCmprisonService");
		try {
			setupValues(context);
			results.sampleStart();
			mapResult = orc2OrcCmprisonService.fetchAndCompareCount();
			if (!mapResult.isMatch()) {
				populateResponseMsg(mapResult, results);
			}

		}

		catch (Exception e) {
			LOGGER.error("Exception", e);

		} finally {
			results.setSuccessful(mapResult.isMatch());
			ctx.close();
		}
		listParameters(context);
		return results;
	}

	public void populateResponseMsg(MapCompareResult mapResult, SampleResult results) {
		StringBuffer errorResMsg = new StringBuffer();
		List<MapCountObject> ls = new ArrayList<MapCountObject>();

		ls.addAll(mapResult.getUnmatchedObjectList());
		for (int i = 0; i < ls.size(); i++) {
			errorResMsg.append("TABLE: " + ls.get(i).getObjectName() + " Primary Count: " + ls.get(i).getCount_1()
					+ " Secondary Count: " + ls.get(i).getCount_2()).append("\n");

		}
		results.setResponseData(errorResMsg.toString());
		results.setResponseMessage(errorResMsg.toString());

	}
}