package com.bdna.automation.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdna.automation.constant.JMeterConstant;
import com.bdna.automation.dao.impl.OracleDaoImpl;
import com.bdna.automation.dao.impl.OracleDaoImplSecondary;
import com.bdna.automation.entity.MapCompareResult;
import com.bdna.automation.entity.MapCountObject;
import com.bdna.automation.utility.MapUtility;

@Service("orc2OrcCmprisonService")
public class Orc2OrcCmprisonService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private OracleDaoImpl oracleDaoImpl;
	@Autowired
	private OracleDaoImplSecondary oracleDaoImplSecondary;

	@Autowired
	private MapUtility mapUtility;

	private Map<String, Integer> primaryTableMap = new HashMap<String, Integer>();
	private Map<String, Integer> secondaryTableMap = new HashMap<String, Integer>();

	public void getTableCountPrimary(List<String> tableName) {

		for (String tabNm : tableName) {
			primaryTableMap.put(tabNm, oracleDaoImpl.getCount(JMeterConstant.SELECT_QUERY + tabNm));
		}
		//printMap(primaryTableMap);
	}

	public void getTableCountSecondary(List<String> tableName) {

		System.out.println("running for Secondary");
		for (String tabNm : tableName) {
			secondaryTableMap.put(tabNm, oracleDaoImplSecondary.getCount(JMeterConstant.SELECT_QUERY + tabNm));
		}
		printMap(secondaryTableMap);
	}

	public MapCompareResult fetchAndCompareCount() {
		getTableCountPrimary(oracleDaoImpl.getAllTableName());
		getTableCountSecondary(oracleDaoImplSecondary.getAllTableName());
		System.out.println("Size of map1: " + primaryTableMap );
		System.out.println(" Size of map 2: " + secondaryTableMap);
		
		MapCompareResult mapCompareResult = mapUtility.mapCompareCount(primaryTableMap, secondaryTableMap);
		if (mapCompareResult.isMatch()) {
			LOGGER.info("All tables for the two database match");

		} else {
			Iterator<MapCountObject> iterMapCompareRes = mapCompareResult.getUnmatchedObjectList().iterator();
			while (iterMapCompareRes.hasNext()) {
				MapCountObject mapCountObject = iterMapCompareRes.next();
				LOGGER.info("Count mismatch for aggregate table: {} --> Primary: {}  Secondary: {}",
						mapCountObject.getObjectName(), mapCountObject.getCount_1(), mapCountObject.getCount_2());
			}

		}
		return mapCompareResult;

	}

	public void printMap(Map map) {
		Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> pair = it.next();
			System.out.println(pair.getKey() + ": " + pair.getValue());
		}
	}

}
