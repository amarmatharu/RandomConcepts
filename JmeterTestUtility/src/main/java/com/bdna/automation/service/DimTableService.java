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

@Service("dimTableService")
public class DimTableService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private OracleDaoImpl oracleDaoImpl;

	@Autowired
	private SQLServerDaoImpl sqlServerDaoImpl;

	@Autowired
	private MapUtility mapUtility;

	public boolean getCount() throws ClassNotFoundException, SQLException {

		Map<String, String> dimTableMap = (HashMap<String, String>) JMeterConstant
				.getQueryString(this.getClass().getSimpleName());
		Map<String, Integer> dimTableSqlServerCount = new HashMap<String, Integer>();
		Map<String, Integer> dimTableOracleCount = new HashMap<String, Integer>();

		for (Entry<String, String> entry : dimTableMap.entrySet()) {
			String tableName = entry.getKey();
			String query = entry.getValue();
			LOGGER.info("Getting count information for table: {}", tableName);
			dimTableSqlServerCount.put(tableName, sqlServerDaoImpl.getCount(query));
			dimTableOracleCount.put(tableName, oracleDaoImpl.getCount(query));
		}

		MapCompareResult mapCompareResult = mapUtility.mapCompareCount(dimTableSqlServerCount, dimTableOracleCount);
		if (mapCompareResult.isMatch()) {
			LOGGER.info("All Dimension tables and views for SQL Server and Oracle match");
			return true;
		} else {
			Iterator<MapCountObject> iterMapCompareRes = mapCompareResult.getUnmatchedObjectList().iterator();
			while (iterMapCompareRes.hasNext()) {
				MapCountObject mapCountObject = iterMapCompareRes.next();
				LOGGER.info("Count mismatch for dimension table: {} --> SQLServer: {}  Oracle: {}",
						mapCountObject.getObjectName(), mapCountObject.getCount_1(),
						mapCountObject.getCount_2());
			}
			return false;
		}
	}
}
