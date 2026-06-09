// Problem: LeetCode 560 - Subarray Sum Equals K
// Description:
// Return the total number of continuous subarrays
// whose sum equals k.

/*
Edge Cases:
- Empty array
- Negative numbers
- k = 0
- Multiple valid subarrays
- Entire array sum equals k
*/


import java.util.*;


/* =======================
   Approach 1: Generate All Subarrays
   ======================= */

class Solution {

    public int subarraySum(int[] nums, int k) {

        int count = 0;

        for(int i = 0; i < nums.length; i++){

            int sum = 0;

            for(int j = i; j < nums.length; j++){

                sum += nums[j];

                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }
}

/*
Explanation:
- Start every subarray from index i
- Extend subarray using j
- Maintain running sum
- If sum == k:
    count++

Example:
nums = [1,1,1]
k = 2

Subarrays:
[1,1]
[1,1]

Answer = 2

Time Complexity: O(n²)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Prefix Sum + HashMap (Optimal)
   ======================= */

class Solution {

    public int subarraySum(int[] nums, int k) {

        int count = 0;

        int prefixSum = 0;

        HashMap<Integer, Integer> prefixCount =
            new HashMap<>();

        // important initialization
        prefixCount.put(0, 1);

        for(int num : nums){

            prefixSum += num;

            // check if a previous prefix exists
            count += prefixCount.getOrDefault(
                        prefixSum - k,
                        0
                    );

            // store current prefix sum
            prefixCount.put(
                prefixSum,
                prefixCount.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }
}

/*
Explanation:

Key Formula:

Current Subarray Sum = k

prefixSum - previousPrefix = k

Therefore:

previousPrefix = prefixSum - k

If such a prefix exists,
then a valid subarray ends at current index.

--------------------------------

Example:

nums = [1,1,1]
k = 2

Start:

prefixCount = {0=1}

--------------------------------

num = 1

prefixSum = 1

Need:
prefixSum - k
= 1 - 2
= -1

Not found

Store:
{0=1, 1=1}

--------------------------------

num = 1

prefixSum = 2

Need:
2 - 2 = 0

Found once

count = 1

Store:
{0=1, 1=1, 2=1}

--------------------------------

num = 1

prefixSum = 3

Need:
3 - 2 = 1

Found once

count = 2

Answer = 2

--------------------------------

Why:
prefixCount stores
how many times each prefix sum appeared.

A repeated prefix sum can create
multiple valid subarrays.

Time Complexity: O(n)

Space Complexity: O(n)
*/