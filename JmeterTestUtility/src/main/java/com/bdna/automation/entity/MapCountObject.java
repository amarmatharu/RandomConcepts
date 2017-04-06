package com.bdna.automation.entity;

import org.springframework.stereotype.Component;

@Component
public class MapCountObject {

	private String objectName;
	private int count_1;
	private int count_2;

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public int getCount_1() {
		return count_1;
	}

	public void setCount_1(int count_1) {
		this.count_1 = count_1;
	}

	public int getCount_2() {
		return count_2;
	}

	public void setCount_2(int count_2) {
		this.count_2 = count_2;
	}

}
