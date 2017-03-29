package com.bdna.automation.dao;

import java.util.List;

import com.bdna.automation.entity.BdnaTechnopediaTag;

public interface DIMDao {

	public List<BdnaTechnopediaTag> getBDNATechnopediaTag();

	public int getCount(String query);

}
