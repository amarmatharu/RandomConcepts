package com.bdna.automation.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bdna.automation.dao.impl.SQLServerDIMDaoImpl;
import com.bdna.automation.entity.BdnaTechnopediaTag;

@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/spring-servlet-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SQLServerDIMDaoImplTest {

	@Autowired
	private SQLServerDIMDaoImpl sqlServerDIMDao;

	@Test
	public void test() {
		List<BdnaTechnopediaTag> ls = new ArrayList<BdnaTechnopediaTag>();
		ls = sqlServerDIMDao.getBDNATechnopediaTag();
		System.out.println("size : " + ls.size());
	}

	@Test
	public void getCount() {

		String query = "select count(*) from AGG_N_IT_ASSETS_HW";
		int result = sqlServerDIMDao.getCount(query);
		System.out.println("Result : " + result);
	}

}
