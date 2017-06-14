package com.bdna.automation.entity;

import java.util.HashMap;
import java.util.Map;

public class TestNull {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String args[]) {
		
		
		TestNull test = new TestNull();
		test.setName(null);
		test.getName();
		System.out.println(test.getName());
		
		Map<String, Integer> map = new HashMap<String,Integer>();
		
		map.get("amar");
		
		System.out.println("Finding null value in a map: " + map.get(null));

	}

}
