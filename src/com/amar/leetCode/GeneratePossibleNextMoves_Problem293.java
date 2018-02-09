package com.amar.leetCode;

import java.util.ArrayList;
import java.util.List;

public class GeneratePossibleNextMoves_Problem293 {

	public List<String> generatePossibleNextMoves(String s) {

		char[] inputArray = s.toCharArray();
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < inputArray.length-1; i++) {

			if (inputArray[i] == inputArray[i + 1] && inputArray[i] == '+') {
				inputArray[i] = inputArray[i + 1] = '-';
				result.add(String.valueOf(inputArray));
				inputArray[i] = inputArray[i + 1] = '+';

			}

		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
