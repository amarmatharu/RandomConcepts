package com.amar.leetCode;

import java.util.ArrayList;
import java.util.List;

/*You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you 
 * and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and 
 * therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
 * 
 * 
 * 
 */
public class GeneratePossibleNextMoves_Problem293 {

	public List<String> generatePossibleNextMoves(String s) {

		char[] inputArray = s.toCharArray();
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < inputArray.length - 1; i++) {

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
