package com.amar.leetCode;

public class JudgingCircle_Problem657 {

	final int UP = 2;
	final int DOWN = -2;
	final int LEFT = -1;
	final int RIGHT = 1;

	public boolean judgeCircle(String moves) {

		int sum = 0;
		if (null == moves || (moves.length() % 2 != 0)) {
			return false;
		}
		for (int i = 0; i < moves.length(); i++) {
			char c = moves.toUpperCase().charAt(i);
			switch (c) {
			case 'L':
				sum += LEFT;
				break;
			case 'R':
				sum += RIGHT;
				break;
			case 'U':
				sum += UP;
				break;
			case 'D':
				sum += DOWN;
				break;
			default:
				throw new IllegalArgumentException("Not a valid move");

			}
		}

		if (sum != 0)
			return false;
		else
			return true;

	}

	public static void main(String[] args) {

		JudgingCircle_Problem657 obj = new JudgingCircle_Problem657();
		System.out.println(obj.judgeCircle(
				"URURUUULLRRDLLDULLUDRRULLRDLRRDRLDLRDLDRDUDULLUUUULRRLDLLLUDLDUULLRUUURDDUDRRDURDLRDUURLRRRDDRDRDDRDDRRLRULLLLLRUDU"));

	}

}
