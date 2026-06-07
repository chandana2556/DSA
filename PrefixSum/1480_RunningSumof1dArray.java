// Problem: LeetCode 1480 - Running Sum of 1d Array
// Description:
// The running sum at index i is:
// nums[0] + nums[1] + ... + nums[i]
// Return the running sum array.

/*
Edge Cases:
- Empty array
- Single element
- Negative numbers
- All zeros
- Large values
*/


import java.util.*;


/* =======================
   Approach 1: Nested Loops (Brute Force)
   ======================= */

class Solution {

    public int[] runningSum(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        for(int i = 0; i < n; i++){

            int sum = 0;

            for(int j = 0; j <= i; j++){

                sum += nums[j];
            }

            result[i] = sum;
        }

        return result;
    }
}

/*
Explanation:
- For each index i
- Calculate sum from index 0 to i

Example:
nums = [1,2,3,4]

result[0] = 1
result[1] = 1+2 = 3
result[2] = 1+2+3 = 6
result[3] = 1+2+3+4 = 10

Answer:
[1,3,6,10]

Time Complexity: O(n²)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: Prefix Sum Array
   ======================= */

class Solution {

    public int[] runningSum(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        result[0] = nums[0];

        for(int i = 1; i < n; i++){

            result[i] =
                result[i - 1] + nums[i];
        }

        return result;
    }
}

/*
Explanation:
- Running sum at index i:
    previous running sum + current value

Example:
nums = [1,2,3,4]

result[0] = 1
result[1] = 1 + 2 = 3
result[2] = 3 + 3 = 6
result[3] = 6 + 4 = 10

Answer:
[1,3,6,10]

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 3: In-Place Prefix Sum (Optimal)
   ======================= */

class Solution {

    public int[] runningSum(int[] nums) {

        for(int i = 1; i < nums.length; i++){

            nums[i] =
                nums[i] + nums[i - 1];
        }

        return nums;
    }
}

/*
Explanation:
- Use original array itself
- Each element stores running sum

Example:
nums = [1,2,3,4]

i = 1:
[1,3,3,4]

i = 2:
[1,3,6,4]

i = 3:
[1,3,6,10]

Answer:
[1,3,6,10]

Time Complexity: O(n)
Space Complexity: O(1)
*/