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

	public MapCompareResult mapCompareCount(Map<String, Integer> map_1, Map<String, Integer> map_2) {
		String keyToCompare;
		int map_1_count = 0;
		int map_2_count = 0;
		boolean flag = true;
		System.out.println("map 1 size " + map_1.size());
		System.out.println("map 2 size " + map_2.size());
		for (Entry<String, Integer> entry : map_1.entrySet()) {
			keyToCompare = entry.getKey();
			System.out.println("Key to compare: " + keyToCompare);
		
			map_1_count = map_1.get(keyToCompare);
			if(map_2.get(keyToCompare) != null)
			{
			map_2_count = map_2.get(keyToCompare);
			}
			else
				map_2_count =0;
			System.out.println("Count 1: " + map_1_count + " Count 2: " + map_2_count);
			if (map_1_count != map_2_count) {
				MapCountObject mapCountObject = new MapCountObject();
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
