package com.amar.leetCode;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 * 
 * 
 * 
 */
public class BestTimetoBuyStock_Problem121 {

	public static int maxProfit(int[] prices) {

		// if we dont find more than two entries then we cannot make a trade
		if (prices.length < 2) {
			return 0;

		}

		// to keep track of the buy price
		int buyPriceIndx = 0;
		int profit = 0;

		for (int i = 1; i < prices.length; i++)

		{

			// if we find that we have a price that is lower than the current
			// buy price
			if (prices[i] < prices[buyPriceIndx])

			{
				// make that as the new buy price
				buyPriceIndx = i;

			}
			// we find a price that is greater than our buying price
			else {

				// calculate the profit and take the max value
				profit = Math.max(profit, prices[i] - prices[buyPriceIndx]);

			}

		}

		return profit;

	}

}
