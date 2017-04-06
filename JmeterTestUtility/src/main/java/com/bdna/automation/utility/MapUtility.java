package com.bdna.automation.utility;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bdna.automation.entity.MapCompareResult;
import com.bdna.automation.entity.MapCountObject;

@Component
public class MapUtility {

	@Autowired
	private MapCompareResult mapCompareResult;
	
	@Autowired
	private MapCountObject mapCountObject;

	public MapCompareResult mapCompareCount(Map<String, Integer> map_1, Map<String, Integer> map_2) {
		String keyToCompare;
		int map_1_count = 0;
		int map_2_count = 0;
		boolean flag = true;

		for (Entry<String, Integer> entry : map_1.entrySet()) {
			keyToCompare = entry.getKey();
			map_1_count = map_1.get(keyToCompare);
			map_2_count = map_2.get(keyToCompare);
			if (map_1_count != map_2_count) {
				mapCountObject.setObjectName(keyToCompare);
				mapCountObject.setCount_1(map_1_count);
				mapCountObject.setCount_2(map_2_count);
				mapCompareResult.getUnmatchedObjectList().add(mapCountObject);
				flag = false;
			}
		}
		mapCompareResult.setMatch(flag);
		return mapCompareResult;
	}

}
