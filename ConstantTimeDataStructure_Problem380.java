package com.amar.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * 
 * 
 */
public class ConstantTimeDataStructure_Problem380 {

	private Map<Integer, Integer> map;
	private List<Integer> ls;

	public ConstantTimeDataStructure_Problem380() {
		this.map = new HashMap<Integer, Integer>();
		this.ls = new ArrayList<Integer>();
	}

	public boolean insert(int val) {

		if (map.containsKey(val)) {
			return false;
		}

		// insert the item in the map and store the index of the underlying
		// array
		map.put(val, ls.size());

		// insert the item at the end of the array
		ls.add(val);
		return true;

	}

	public boolean remove(int val) {

		System.out.println("Before deletion: " + ls);
		System.out.println("Before deletion: " + map);
		if (!map.containsKey(val)) {
			return false;

		}
		// get the index of the element to be removed
		int index = map.get(val);

		// remove it from the map
		map.remove(val);

		
		if(index < (ls.size()-1))
		{
			// get the value of last element of the array
			int lastElementInArray = ls.get(ls.size() - 1);
			// move the last element to the index where the element is removed
			ls.set(index, lastElementInArray);
			// update the last element index in the map
			map.put(lastElementInArray, index);

		}
		
		// remove the last element from the array
		ls.remove((ls.size() - 1));
		
		return true;

	}

	public int getRandom() {

		Random random = new Random();
		int nextRandom = random.nextInt(ls.size());
		return ls.get(nextRandom);

	}

	public static void main(String args[]) {
		ConstantTimeDataStructure_Problem380 obj = new ConstantTimeDataStructure_Problem380();
		obj.insert(3);
		obj.insert(3);
		obj.insert(1);
	//	obj.insert(45);
	//	obj.insert(30);

		System.out.println("****************DELETION***********");
		System.out.println(obj.remove(3));
		
		obj.insert(0);
		System.out.println(obj.remove(0));
	}

}
