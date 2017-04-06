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

@Service("dimViewService")
public class DimViewService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private OracleDaoImpl oracleDaoImpl;

	@Autowired
	private SQLServerDaoImpl sqlServerDaoImpl;

	@Autowired
	private MapUtility mapUtility;

	public MapCompareResult getCount() throws ClassNotFoundException, SQLException {

		Map<String, String> dimViewMap = (HashMap<String, String>) JMeterConstant
				.getQueryString(this.getClass().getSimpleName());
		Map<String, Integer> dimViewSqlServerCount = new HashMap<String, Integer>();
		Map<String, Integer> dimViewOracleCount = new HashMap<String, Integer>();

		for (Entry<String, String> entry : dimViewMap.entrySet()) {
			String viewName = entry.getKey();
			String query = entry.getValue();
			LOGGER.info("Getting count information for dimension view: {}", viewName);
			dimViewSqlServerCount.put(viewName, sqlServerDaoImpl.getCount(query));
			dimViewOracleCount.put(viewName, oracleDaoImpl.getCount(query));
		}

		MapCompareResult mapCompareResult = mapUtility.mapCompareCount
				(dimViewSqlServerCount, dimViewOracleCount);
		if (mapCompareResult.isMatch()) {
			LOGGER.info("All dimension views for SQL Server and Oracle match");
			
		} else {
			Iterator<MapCountObject> iterMapCompareRes = mapCompareResult.getUnmatchedObjectList().iterator();
			while (iterMapCompareRes.hasNext()) {
				MapCountObject mapCountObject = iterMapCompareRes.next();
				LOGGER.info("Count mismatch for dimension view: {} --> SQLServer: {}  Oracle: {}",
						mapCountObject.getObjectName(), mapCountObject.getCount_1(), mapCountObject.getCount_2());
			}
			
		}
		return mapCompareResult;
	}
}
