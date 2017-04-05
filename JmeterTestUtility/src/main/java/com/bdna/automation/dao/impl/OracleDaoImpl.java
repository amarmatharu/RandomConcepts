package com.bdna.automation.dao.impl;

import java.math.BigDecimal;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class OracleDaoImpl extends HibernateDaoSupport {

	@Autowired
	@Qualifier(value = "sessionFactoryOracle")
	private SessionFactory sessionFactoryOracle;

	public int getCount(String query) {

		Session session = sessionFactoryOracle.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(query);
		BigDecimal result = (BigDecimal) sqlQuery.list().get(0);
		System.out.println("Count for Oracle: " + result);
		return result.intValue();

	}

}
