package com.amar.leetCode;

public class RemoveDuplicateFromSortedArray_problem26 {
	
public int removeDuplicates(int[] nums) {
        
	if(nums.length == 0)
		return 0;
        // a variable to store the pointer for next insertion in the array
        int anchor = 0;
               
        for(int i = 1; i < nums.length;i++)
        {
                 
            // if next number is same continue reading the next number and set the anchor
            if(nums[anchor] != nums[i])
            {
            	anchor++;
            	nums[anchor] = nums[i];
            	
            
            }
            
        }
        
        for(int i : nums)
        {
        	System.out.println(i);
        }
        System.out.println("*************************");
        
        return anchor + 1;
        
        
    }

	public static void main(String[] args) {
		RemoveDuplicateFromSortedArray_problem26 obj = new RemoveDuplicateFromSortedArray_problem26();
		
		int[] nums = {1,1,2};
		System.out.println(obj.removeDuplicates(nums));

	}

}
