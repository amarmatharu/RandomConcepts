package com.bdna.automation.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MapCompareResult {

	private List<MapCountObject> unmatchedObjectList;
	private boolean match;

	public List<MapCountObject> getUnmatchedObjectList() {

		if (unmatchedObjectList == null) {
			unmatchedObjectList = new ArrayList<MapCountObject>();
		}
		return this.unmatchedObjectList;
	}

	public void setUnmatchedObjectList(List<MapCountObject> unmatchedObjectList) {
		this.unmatchedObjectList = unmatchedObjectList;
	}

	public boolean isMatch() {
		return match;
	}

	public void setMatch(boolean match) {
		this.match = match;
	}

}
