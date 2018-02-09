package com.amar.random.generator;

import java.util.Random;

public class CustomRandomGenerator {

	/*
	 * Takes the start range and the end range. The r.nextInt() is bounded by
	 * using (endRange - startRange) + 1 // inclusive of the boundary
	 * 
	 */
	private static int getRandomNumbeInRange(final int startRange, final int endRange) {
		if (startRange > endRange) {
			throw new IllegalArgumentException("max must be greater than than min");
		}

		Random r = new Random();
		return r.nextInt((endRange - startRange) + 1) + startRange;

	}

	public static void main(String args[]) throws InterruptedException {

		while (true) {
			System.out.println(getRandomNumbeInRange(7, 14));
			Thread.sleep(500);

		}
	}

}
