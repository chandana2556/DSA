// Problem: LeetCode 1512 - Number of Good Pairs
// Description:
// A pair (i, j) is called good if:
//    nums[i] == nums[j] and i < j
// Return the number of good pairs.

/*
Edge Cases:
- Empty array
- Single element
- All elements same
- No pairs
- Multiple duplicates
*/


import java.util.*;


/* =======================
   Approach 1: Nested Loops (Brute Force)
   ======================= */

class Solution {
    public int numIdenticalPairs(int[] nums) {

        int count = 0;

        for(int i = 0; i < nums.length; i++){

            for(int j = i + 1; j < nums.length; j++){

                // good pair found
                if(nums[i] == nums[j]){
                    count++;
                }
            }
        }

        return count;
    }
}

/*
Explanation:
- Compare every pair
- Count pairs where nums[i] == nums[j]

Time Complexity: O(n²)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Frequency Counting
   ======================= */

class Solution {
    public int numIdenticalPairs(int[] nums) {

        int[] freq = new int[101];

        // count frequency
        for(int num : nums){
            freq[num]++;
        }

        int count = 0;

        // calculate pairs using formula
        for(int k : freq){

            count += k * (k - 1) / 2;
        }

        return count;
    }
}

/*
Explanation:
- If a number appears k times,
  number of pairs =
      k * (k - 1) / 2

Example:
freq = 4

Possible pairs:
(1,2), (1,3), (1,4),
(2,3), (2,4),
(3,4)

Total = 6

Time Complexity: O(n)
Space Complexity: O(1)
(Because array size is fixed: 101)
*/


/* =======================
   Approach 3: Running Frequency (Optimal)
   ======================= */

class Solution {
    public int numIdenticalPairs(int[] nums) {

        int[] freq = new int[101];

        int count = 0;

        for(int num : nums){

            // existing occurrences form new pairs
            count += freq[num];

            // update frequency
            freq[num]++;
        }

        return count;
    }
}

/*
Explanation:
- Before incrementing:
    freq[num] = number of previous occurrences

- Every previous occurrence forms a new pair

Example:
nums = [1,1,1]

First 1:
count += 0

Second 1:
count += 1

Third 1:
count += 2

Total = 3 pairs

Time Complexity: O(n)
Space Complexity: O(1)
*/