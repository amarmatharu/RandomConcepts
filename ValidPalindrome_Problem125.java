package com.amar.leetCode;

/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 * 
 */
public class ValidPalindrome_Problem125 {

	public boolean isPalindrome(String s) {

		String regex = "[^A-Za-z0-9]";
		String alphanumeric = s.replaceAll(regex, "").toLowerCase();

		// variable to store start of a string
		int start = 0;
		// stores the string length
		int end = alphanumeric.length() - 1;

		if (alphanumeric.length() < 2) {
			return true;
		}

		while (start < end) {
			if (alphanumeric.charAt(start) != alphanumeric.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}

}
