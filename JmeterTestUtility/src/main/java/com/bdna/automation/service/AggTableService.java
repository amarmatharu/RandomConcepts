package com.bdna.automation.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.bdna.automation.constant.JMeterConstant;
import com.bdna.automation.dao.impl.OracleDIMDaoImpl;
import com.bdna.automation.dao.impl.SQLServerDIMDaoImpl;

public class AggTableService {
	@Autowired
	private OracleDIMDaoImpl oracleDIMDaoImpl;

	@Autowired
	private SQLServerDIMDaoImpl sqlServerDIMDao;
	
	public boolean getCount(String key) throws ClassNotFoundException, SQLException {
		int oracleCount = 0, sqlCount = 0;

		String query = JMeterConstant.getQueryString(AggTableService.class.getSimpleName(), key);
		sqlCount = sqlServerDIMDao.getCount(query);
		oracleCount = oracleDIMDaoImpl.getCount(query);
		System.out.println("Count for: " + key + " SQLServer: " + sqlCount + " Oracle: " + oracleCount);
		if (sqlCount == oracleCount)
			return true;
		else
			return false;

	}
}
