package com.bdna.automation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.bdna.automation.entity.BdnaTechnopediaTag;

@Transactional
public class SQLServerDIMDaoImpl extends HibernateDaoSupport {

	@Autowired
	@Qualifier(value = "sessionFactorySqlServer")
	private SessionFactory sessionFactorySqlServer;

	public List<BdnaTechnopediaTag> getBDNATechnopediaTag() {
		List<BdnaTechnopediaTag> ls = new ArrayList<BdnaTechnopediaTag>();
		try {

			DetachedCriteria convReqCriteria = DetachedCriteria.forClass(BdnaTechnopediaTag.class);
			ls = (List<BdnaTechnopediaTag>) getHibernateTemplate().findByCriteria(convReqCriteria);
		} catch (Exception e) {
			System.out.println("Exception" + e);
		}
		return ls;

	}

	public int getCount(String query) {

		Session session = sessionFactorySqlServer.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(query);
		Integer result = (Integer) sqlQuery.list().get(0);
		System.out.println("Count for SQL Server: " + result);
		return result.intValue();

	}

}
