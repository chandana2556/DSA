// Problem: LeetCode 268 - Missing Number
// Description: Given an array containing n distinct numbers in the range [0, n],
// return the only number missing from the array.

/*
Edge Cases:
- Missing number is 0
- Missing number is n
- Single element array
- Unsorted array
- Large values
*/


import java.util.*;


/* =======================
   Approach 1: HashSet
   ======================= */

class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;

        Set<Integer> numSet = new HashSet<>();

        // store all numbers
        for(int num : nums){
            numSet.add(num);
        }

        // check from 0 to n
        for(int i = 0; i <= n; i++){

            if(!numSet.contains(i)){
                return i;
            }
        }

        return -1;
    }
}

/*
Explanation:
- Store all elements in HashSet
- Traverse from 0 to n
- Missing number will not exist in set

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: Sum Formula
   ======================= */

class Solution {
    public int missingNumber(int[] nums) {

        int actualSum = 0;

        // calculate array sum
        for(int num : nums){
            actualSum += num;
        }

        // expected sum from 0 to n
        int expectedSum = nums.length * (nums.length + 1) / 2;

        return expectedSum - actualSum;
    }
}

/*
Explanation:
- Sum of numbers from 0 to n:
    n * (n + 1) / 2

- Missing number =
    expected sum - actual sum

Time Complexity: O(n)
Space Complexity: O(1)
*/


/* =======================
   Approach 3: XOR (Optimal)
   ======================= */

class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int xor = 0;

        for(int i = 0; i < n; i++){

            xor ^= (i + 1) ^ nums[i];
        }

        return xor;
    }
}

/*
Explanation:
- XOR same numbers → 0
    a ^ a = 0

- XOR with 0 keeps value unchanged
    a ^ 0 = a

- XOR all indices and array values
- Duplicate values cancel out
- Remaining value = missing number

Time Complexity: O(n)
Space Complexity: O(1)
*/