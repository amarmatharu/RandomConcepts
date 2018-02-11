import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * 
 * 
 */
public class TwoSum_Problem1 {

	public static int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int remainder = 0;
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			int start = nums[i];
			// what is the remainder we are looking for
			remainder = target - start;
			if (map.containsKey(remainder)) {
				// return the indexes; we have found two numbers
				result[1] = i;
				result[0] = map.get(remainder);

			} else {
				// not found in map then add it in the map
				map.put(start, i);
			}
		}
		return result;
	}
}
