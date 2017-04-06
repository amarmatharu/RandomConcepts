package com.bdna.automation.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdna.automation.constant.JMeterConstant;
import com.bdna.automation.dao.impl.OracleDaoImpl;
import com.bdna.automation.dao.impl.SQLServerDaoImpl;
import com.bdna.automation.entity.MapCompareResult;
import com.bdna.automation.entity.MapCountObject;
import com.bdna.automation.utility.MapUtility;

@Service("factTableService")
public class FactTableService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private OracleDaoImpl oracleDaoImpl;

	@Autowired
	private SQLServerDaoImpl sqlServerDaoImpl;

	@Autowired
	private MapUtility mapUtility;

	public boolean getCount() throws ClassNotFoundException, SQLException {

		Map<String, String> factTableMap = (HashMap<String, String>) JMeterConstant
				.getQueryString(this.getClass().getSimpleName());
		Map<String, Integer> factTableSqlServerCount = new HashMap<String, Integer>();
		Map<String, Integer> factTableOracleCount = new HashMap<String, Integer>();

		for (Entry<String, String> entry : factTableMap.entrySet()) {
			String tableName = entry.getKey();
			String query = entry.getValue();
			LOGGER.info("Getting count information for fact table: {}", tableName);
			factTableSqlServerCount.put(tableName, sqlServerDaoImpl.getCount(query));
			factTableOracleCount.put(tableName, oracleDaoImpl.getCount(query));
		}

		MapCompareResult mapCompareResult = mapUtility.mapCompareCount(factTableSqlServerCount, factTableOracleCount);
		if (mapCompareResult.isMatch()) {
			LOGGER.info("All fact tables for SQL Server and Oracle match");
			return true;
		} else {
			Iterator<MapCountObject> iterMapCompareRes = mapCompareResult.getUnmatchedObjectList().iterator();
			while (iterMapCompareRes.hasNext()) {
				MapCountObject mapCountObject = iterMapCompareRes.next();
				LOGGER.info("Count mismatch for fact table: {} --> SQLServer: {}  Oracle: {}",
						mapCountObject.getObjectName(), mapCountObject.getCount_1(), mapCountObject.getCount_2());
			}
			return false;
		}
	}
}
