// Problem: LeetCode 977 - Squares of a Sorted Array
// Description:
// Given a sorted integer array nums,
// return an array of the squares of each number sorted in non-decreasing order.

/*
Edge Cases:
- All positive numbers
- All negative numbers
- Mixed positive & negative
- Contains zero
- Single element array
*/


import java.util.*;


/* =======================
   Approach 1: Square + Sort
   ======================= */

class Solution {

    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        // square all elements
        for(int i = 0; i < nums.length; i++){

            result[i] = nums[i] * nums[i];
        }

        // sort squared values
        Arrays.sort(result);

        return result;
    }
}

/*
Explanation:
- Square every element
- Sort the resulting array

Example:
nums = [-4,-1,0,3,10]

Squares:
[16,1,0,9,100]

Sorted:
[0,1,9,16,100]

Time Complexity: O(n log n)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: Two Pointers (Optimal)
   ======================= */

class Solution {

    public int[] sortedSquares(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        int left = 0;
        int right = n - 1;

        // fill result from end
        for(int pos = n - 1; pos >= 0; pos--){

            int leftSq = nums[left] * nums[left];

            int rightSq = nums[right] * nums[right];

            // larger square goes at current position
            if(leftSq > rightSq){

                result[pos] = leftSq;

                left++;
            }

            else{

                result[pos] = rightSq;

                right--;
            }
        }

        return result;
    }
}

/*
Explanation:
- Largest square will come from:
    either leftmost negative
    or rightmost positive

- Compare both squares
- Place larger square at end
- Move corresponding pointer

Example:
nums = [-4,-1,0,3,10]

Compare:
16 vs 100 → place 100
16 vs 9   → place 16
1 vs 9    → place 9

Result:
[0,1,9,16,100]

Time Complexity: O(n)
Space Complexity: O(n)
*/