// Problem: LeetCode 303 - Range Sum Query - Immutable
// Description:
// Given an integer array nums,
// return the sum of elements between indices left and right (inclusive).
// Multiple sumRange queries may be performed.

/*
Edge Cases:
- Single element array
- left == right
- Query entire array
- Negative numbers
- Multiple repeated queries
*/


import java.util.*;


/* =======================
   Approach 1: Direct Traversal
   ======================= */

class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {

        this.nums = nums;
    }

    public int sumRange(int left, int right) {

        int sum = 0;

        for(int i = left; i <= right; i++){

            sum += nums[i];
        }

        return sum;
    }
}

/*
Explanation:
- Store original array
- For every query:
    traverse from left to right
    and calculate sum

Example:
nums = [-2,0,3,-5,2,-1]

sumRange(0,2)
= -2 + 0 + 3
= 1

Time Complexity:
Constructor → O(1)
sumRange() → O(n)

Space Complexity: O(1)
*/


/* =======================
   Approach 2: Prefix Sum (Optimal)
   ======================= */

class NumArray {

    private int[] prefix;

    public NumArray(int[] nums) {

        prefix = new int[nums.length + 1];

        for(int i = 0; i < nums.length; i++){

            prefix[i + 1] =
                prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        return prefix[right + 1]
             - prefix[left];
    }
}

/*
Explanation:
- Build prefix sum array

prefix[i]
= sum of elements before index i

Example:
nums = [-2,0,3,-5,2,-1]

prefix:
[0,-2,-2,1,-4,-2,-3]

Query:
sumRange(2,5)

= prefix[6] - prefix[2]
= -3 - (-2)
= -1

Why it works?

prefix[right+1]
contains sum from index 0 to right

prefix[left]
contains sum from index 0 to left-1

Subtracting removes unwanted part.

Time Complexity:
Constructor → O(n)
sumRange() → O(1)

Space Complexity: O(n)
*/