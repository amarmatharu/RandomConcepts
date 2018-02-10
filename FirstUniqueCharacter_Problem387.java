package com.amar.leetCode;

/*Given a string, find the first non-repeating character in it and return 
 * it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 * 
 * 
 */
public class FirstUniqueCharacter_Problem387 {

	public int firstUniqChar(String s) {

		int location = s.length();

		for (char c = 'a'; c <= 'z'; c++) {

			if (s.indexOf(c) != -1 && s.indexOf(c) == s.lastIndexOf(c)) {
				location = Math.min(location, s.indexOf(c));

			}

		}
		return location == s.length() ? -1 : location;

	}

	public static void main(String[] args) {

		FirstUniqueCharacter_Problem387 obj = new FirstUniqueCharacter_Problem387();
		System.out.println(obj.firstUniqChar("leetcode"));
	}

}
