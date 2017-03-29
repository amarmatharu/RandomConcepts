package com.bdna.automation.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.bdna.automation.entity.BdnaTechnopediaTag;

@Transactional
public class OracleDIMDaoImpl extends HibernateDaoSupport {

	@Autowired
	private SessionFactory sessionFactoryOracle;

	public void test() {

		getSessionFactory().getCurrentSession();
		System.out.println("tested");
	}

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

		Session session = sessionFactoryOracle.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(query);
		BigDecimal result = (BigDecimal) sqlQuery.list().get(0);
		return result.intValue();

	}

}
