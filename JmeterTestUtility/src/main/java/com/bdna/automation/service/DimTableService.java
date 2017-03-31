package com.bdna.automation.service;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdna.automation.constant.JMeterConstant;
import com.bdna.automation.dao.impl.OracleDIMDaoImpl;
import com.bdna.automation.dao.impl.SQLServerDIMDaoImpl;


@Service
public class DimTableService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DimTableService.class.getName());
	@Autowired
	private OracleDIMDaoImpl oracleDIMDaoImpl;

	@Autowired
	private SQLServerDIMDaoImpl sqlServerDIMDao;

	public boolean getCount(String key) throws ClassNotFoundException, SQLException {
		int oracleCount = 0, sqlCount = 0;
		
		LOGGER.info("Key requested: " + key);

		String query = JMeterConstant.getQueryString(this.getClass().getSimpleName(), key);
		LOGGER.info("query retrieved: " + query);
		sqlCount = sqlServerDIMDao.getCount(query);
		oracleCount = oracleDIMDaoImpl.getCount(query);
		System.out.println("Count for: " + key + " SQLServer: " + sqlCount + " Oracle: " + oracleCount);
		if (sqlCount == oracleCount)
			return true;
		else
			return false;

	}

}
