/*
============================================================
Problem: LeetCode 1413 - Minimum Value to Get Positive Step
by Step Sum

Description:
Given an integer array nums, choose the minimum positive
starting value such that the step-by-step sum is always
greater than or equal to 1.

The calculation starts with:

    sum = startValue

Then for every element:
    sum = sum + nums[i]

The value of sum must always remain positive.

Concept:
This problem uses the Prefix Sum concept.

We calculate the running sum of nums and find the minimum
prefix sum.

If the minimum prefix sum is negative, we need a starting
value large enough to make that minimum value at least 1.

Formula:

    minimum start value = 1 - minimum prefix sum

Example:

Input:
nums = [-3, 2, -3, 4, 2]

Prefix sums:
-3, -1, -4, 0, 2

Minimum prefix sum = -4

Minimum start value:
1 - (-4) = 5

Output:
5
============================================================
*/


/*
============================================================
Approach 1: Brute Force

- Start with start = 1.
- Check whether this starting value keeps the running sum
  positive for the entire array.
- If not valid, increase start by 1.
- Repeat until a valid starting value is found.

Time Complexity: O(n * k)
where k is the answer/start value that we try.

Space Complexity: O(1)
============================================================
*/

class Solution {
    public int minStartValue(int[] nums) {

        int start = 1;

        while (true) {

            int sum = start;
            boolean valid = true;

            for (int num : nums) {

                sum += num;

                if (sum <= 0) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                return start;
            }

            start++;
        }
    }
}


/*
============================================================
Approach 2: Prefix Sum Array

- Create a prefix sum array.
- Calculate the running sum of nums.
- Find the minimum prefix sum.
- The required starting value is:

      1 - minSum

This approach explicitly stores all prefix sums.

Time Complexity: O(n)
Space Complexity: O(n)
============================================================
*/

class Solution {
    public int minStartValue(int[] nums) {

        int[] prefix = new int[nums.length];

        int minSum = 0;

        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < prefix.length; i++) {
            minSum = Math.min(minSum, prefix[i]);
        }

        return 1 - minSum;
    }
}


/*
============================================================
Approach 3: Running Sum - Optimal

- We don't need to store the complete prefix sum array.
- Maintain the current running sum.
- Keep track of the minimum running sum.
- Finally calculate:

      answer = 1 - minSum

This gives the same result as Approach 2 but uses O(1)
extra space.

Time Complexity: O(n)
Space Complexity: O(1)
============================================================
*/

class Solution {
    public int minStartValue(int[] nums) {

        int sum = 0;
        int minSum = 0;

        for (int num : nums) {
            sum += num;
            minSum = Math.min(minSum, sum);
        }

        return 1 - minSum;
    }
}