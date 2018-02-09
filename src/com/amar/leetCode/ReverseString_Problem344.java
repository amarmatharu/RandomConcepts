package com.amar.leetCode;

/*
 * Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 * 
 * 
 */
public class ReverseString_Problem344 {

	public String reverseString(String s) {

		char[] charArray = s.toCharArray();
		int endIndex = s.length() - 1;
		int startIndex = 0;
		while (startIndex < endIndex) {
			char tmp = charArray[startIndex];
			charArray[startIndex++] = charArray[endIndex];
			charArray[endIndex--] = tmp;

		}

		return String.valueOf(charArray);

	}

	public static void main(String[] args) {

	}

}
