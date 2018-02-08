package com.amar.customIterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

public class CustomCollection {
	
	
	public static void main(String args[])
	{
		Collection parent = new ArrayList();
		
		Collection slave1 = new ArrayList();
		slave1.add(10);
		slave1.add(20);
		slave1.add(600);
		
		 Set slave2 = new HashSet();
		 slave2.add(30);
		 slave2.add(40);
		 slave2.add("amar");
		 
		 parent.add(slave1);
		 parent.add(slave2);
		 Set slave3 = null;
		              
		 parent.add(slave3);
		 
		 
		 Set slave4 = new HashSet();
		 slave4.add(70);
		 slave4.add(80);
		 parent.add(slave4);
		// CustomMultiCollectionIterator it = new CustomMultiCollectionIterator(parent);
		 
		 MultiIterator it = new MultiIterator(parent);		 
		 while(it.hasNext())
		 {
			 System.out.println(it.next());
		 }
		 
		
		 
		 
	}

}
