// Problem: LeetCode 1470 - Shuffle the Array
// Description:
// Given the array nums consisting of 2n elements in the form:
//    [x1,x2,...,xn,y1,y2,...,yn]
// Return the array in the form:
//    [x1,y1,x2,y2,...,xn,yn]

/*
Edge Cases:
- Small array size
- n = 1
- Duplicate values
- All elements same
- Maximum allowed values
*/


import java.util.*;


/* =======================
   Approach 1: Extra Array
   ======================= */

class Solution {

    public int[] shuffle(int[] nums, int n) {

        int[] result = new int[2 * n];

        for(int i = 0; i < n; i++){

            result[2 * i] = nums[i];

            result[2 * i + 1] = nums[n + i];
        }

        return result;
    }
}

/*
Explanation:
- First half contains x values
- Second half contains y values

Place:
x at even indices
y at odd indices

Example:
nums = [2,5,1,3,4,7]
n = 3

Result:
[2,3,5,4,1,7]

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: In-Place Encoding (Optimal)
   ======================= */

class Solution {

    public int[] shuffle(int[] nums, int n) {

        int maxVal = 1001;

        // encode new values
        for(int i = n - 1; i >= 0; i--){

            nums[2 * i + 1] +=
                (nums[n + i] % maxVal) * maxVal;

            nums[2 * i] +=
                (nums[i] % maxVal) * maxVal;
        }

        // decode final values
        for(int i = 0; i < 2 * n; i++){

            nums[i] = nums[i] / maxVal;
        }

        return nums;
    }
}

/*
Explanation:
- Store old and new values together in same index

Formula:
encodedValue =
    oldValue + newValue * maxVal

Why maxVal = 1001?
- Problem constraints:
    nums[i] <= 1000

So:
new value can be extracted safely.

Decoding:
value = encoded / maxVal

Example:
old = 5
new = 3

encoded:
5 + 3*1001 = 3008

decoded:
3008 / 1001 = 3

Time Complexity: O(n)
Space Complexity: O(1)
*/