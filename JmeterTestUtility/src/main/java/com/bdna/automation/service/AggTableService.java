package com.bdna.automation.service;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bdna.automation.constant.JMeterConstant;
import com.bdna.automation.dao.impl.OracleDaoImpl;
import com.bdna.automation.dao.impl.SQLServerDIMDaoImpl;

public class AggTableService {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private OracleDaoImpl oracleDaoImpl;

	@Autowired
	private SQLServerDIMDaoImpl sqlServerDaoImpl;

	public boolean getCount(String key) throws ClassNotFoundException, SQLException {
		int oracleCount = 0, sqlCount = 0;
		LOGGER.info("Key: " + key);
		String query = JMeterConstant.getQueryString(AggTableService.class.getSimpleName(), key);
		LOGGER.info("Query: " + query);
		sqlCount = sqlServerDaoImpl.getCount(query);
		oracleCount = oracleDaoImpl.getCount(query);
		LOGGER.info("Count --> SQL Server: {} Oracle: {} ", sqlCount, oracleCount);
		if (sqlCount == oracleCount)
			return true;
		else
			return false;

	}
}
