// Problem: LeetCode 121 - Best Time to Buy and Sell Stock
// Description:
// Given an array where prices[i] is the stock price on day i,
// choose one day to buy and a later day to sell
// to maximize profit.
// Return the maximum possible profit.
// If no profit is possible, return 0.

/*
Edge Cases:
- Single day
- Prices always decreasing
- Prices always increasing
- Buy and sell on different days only
- Maximum profit is 0
*/

import java.util.*;


/* =======================
   Approach 1: Brute Force
   ======================= */

class Solution {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){

            for(int j = i + 1; j < prices.length; j++){

                int profit = prices[j] - prices[i];

                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}

/*
Explanation:

Try every possible

Buy Day

Sell Day

Calculate profit.

Input:

prices = [7,1,5,3,6,4]

Output:

5

(Buy at 1, Sell at 6)

--------------------------------

Input:

prices = [7,6,4,3,1]

Output:

0

Time Complexity: O(n²)

Space Complexity: O(1)
*/


/* =======================
   Approach 2: Track Minimum Price (Optimal)
   ======================= */

class Solution {

    public int maxProfit(int[] prices) {

        int minPrice = prices[0];

        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++){

            if(prices[i] < minPrice){

                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;

            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}

/*
Explanation:

Keep track of

Minimum Buying Price

Calculate profit every day.

Input:

prices = [7,1,5,3,6,4]

Output:

5

(Buy at 1, Sell at 6)

--------------------------------

Input:

prices = [2,4,1]

Output:

2

(Buy at 2, Sell at 4)

Time Complexity: O(n)

Space Complexity: O(1)
*/


/* =======================
   Approach 3: Kadane's Algorithm
   ======================= */

class Solution {

    public int maxProfit(int[] prices) {

        int current = 0;

        int best = 0;

        for(int i = 1; i < prices.length; i++){

            int diff = prices[i] - prices[i - 1];

            current = Math.max(0, current + diff);

            best = Math.max(best, current);
        }

        return best;
    }
}

/*
Explanation:

Treat daily price changes
as an array.

Find the maximum sum subarray
using Kadane's Algorithm.

Input:

prices = [7,1,5,3,6,4]

Daily Changes:

[-6,4,-2,3,-2]

Maximum Sum = 5

Output:

5

--------------------------------

Input:

prices = [7,6,4,3,1]

Daily Changes:

[-1,-2,-1,-2]

Output:

0

Time Complexity: O(n)

Space Complexity: O(1)
*/