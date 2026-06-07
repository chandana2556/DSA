// Problem: LeetCode 724 - Find Pivot Index
// Description:
// Return the pivot index where:
// Sum of elements to the left
// equals
// Sum of elements to the right.
//
// If no pivot index exists, return -1.

/*
Edge Cases:
- Single element array
- Pivot at beginning
- Pivot at end
- Negative numbers
- No pivot exists
*/


import java.util.*;


/* =======================
   Approach 1: Brute Force
   ======================= */

class Solution {

    public int pivotIndex(int[] nums) {

        int n = nums.length;

        for(int i = 0; i < n; i++){

            int leftSum = 0;
            int rightSum = 0;

            // calculate left sum
            for(int j = 0; j < i; j++){

                leftSum += nums[j];
            }

            // calculate right sum
            for(int j = i + 1; j < n; j++){

                rightSum += nums[j];
            }

            if(leftSum == rightSum){

                return i;
            }
        }

        return -1;
    }
}

/*
Explanation:
- Consider every index as pivot
- Calculate:
    left sum
    right sum
- If equal → return index

Example:
nums = [1,7,3,6,5,6]

i = 3

leftSum:
1 + 7 + 3 = 11

rightSum:
5 + 6 = 11

Answer = 3

Time Complexity: O(n²)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Prefix Sum (Optimal)
   ======================= */

class Solution {

    public int pivotIndex(int[] nums) {

        int totalSum = 0;

        // total array sum
        for(int num : nums){

            totalSum += num;
        }

        int leftSum = 0;

        for(int i = 0; i < nums.length; i++){

            int rightSum =
                totalSum - leftSum - nums[i];

            if(leftSum == rightSum){

                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}

/*
Explanation:
- First calculate total sum

At every index:

rightSum =
totalSum - leftSum - currentElement

Check:
leftSum == rightSum

If yes:
current index is pivot

Example:
nums = [1,7,3,6,5,6]

totalSum = 28

i = 3

leftSum = 11

rightSum =
28 - 11 - 6
= 11

Answer = 3

Time Complexity: O(n)
Space Complexity: O(1)
*/