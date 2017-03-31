package com.bdna.automation.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdna.automation.constant.JMeterConstant;
import com.bdna.automation.dao.impl.OracleDIMDaoImpl;
import com.bdna.automation.dao.impl.SQLServerDIMDaoImpl;


@Service
public class AggViewService {
	@Autowired
	private OracleDIMDaoImpl oracleDIMDaoImpl;

	@Autowired
	private SQLServerDIMDaoImpl sqlServerDIMDao;

	public boolean getCount(String key) throws ClassNotFoundException, SQLException {
		int oracleCount = 0, sqlCount = 0;

		String query = JMeterConstant.getQueryString(this.getClass().getSimpleName(), key);
		System.out.println("query: " + query);
		sqlCount = sqlServerDIMDao.getCount(query);
		oracleCount = oracleDIMDaoImpl.getCount(query);
		System.out.println("Count for: " + key + " SQLServer: " + sqlCount + " Oracle: " + oracleCount);
		if (sqlCount == oracleCount)
			return true;
		else
			return false;

	}
}
