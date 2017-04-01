package com.bdna.automation.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bdna.automation.dao.impl.OracleDaoImpl;
import com.bdna.automation.entity.BdnaTechnopediaTag;

@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/spring-servlet-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OracleDIMDaoImplTest {

	@Autowired
	private OracleDaoImpl oracleDIMDaoImpl;

	@Test
	public void test() {
		List<BdnaTechnopediaTag> ls = new ArrayList<BdnaTechnopediaTag>();
		ls = oracleDIMDaoImpl.getBDNATechnopediaTag();
		System.out.println("size : " + ls.size());
	}

	@Test
	public void getCount() {

		String query = "select count(*) from bdna_a_logger";
		int result = oracleDIMDaoImpl.getCount(query);
		System.out.println("Result : " + result);
	}

}
