package com.bdna.automation.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SQLServerDaoImpl extends HibernateDaoSupport {

	@Autowired
	@Qualifier(value = "sessionFactorySqlServer")
	private SessionFactory sessionFactorySqlServer;

	public int getCount(String query) {

		Session session = sessionFactorySqlServer.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(query);
		Integer result = (Integer) sqlQuery.list().get(0);
		System.out.println("Count for SQL Server: " + result);
		return result.intValue();

	}

}
