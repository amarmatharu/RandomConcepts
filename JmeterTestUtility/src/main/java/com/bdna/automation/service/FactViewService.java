package com.bdna.automation.service;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdna.automation.constant.JMeterConstant;
import com.bdna.automation.dao.impl.OracleDaoImpl;
import com.bdna.automation.dao.impl.SQLServerDIMDaoImpl;

@Service
public class FactViewService {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private OracleDaoImpl oracleDaoImpl;

	@Autowired
	private SQLServerDIMDaoImpl sqlServerDaoImpl;

	public boolean getCount(String key) throws ClassNotFoundException, SQLException {
		int oracleCount = 0, sqlCount = 0;

		String query = JMeterConstant.getQueryString(this.getClass().getSimpleName(), key);
		System.out.println("query: " + query);
		sqlCount = sqlServerDaoImpl.getCount(query);
		oracleCount = oracleDaoImpl.getCount(query);
		LOGGER.info("--------------------------");
		LOGGER.info("Key: " + key);
		LOGGER.info("Query: " + query);
		LOGGER.info("Count --> SQL Server: " + sqlCount + " " + "Oracle: " + oracleCount);
		LOGGER.info("--------------------------");
		if (sqlCount == oracleCount)
			return true;
		else
			return false;

	}
}
