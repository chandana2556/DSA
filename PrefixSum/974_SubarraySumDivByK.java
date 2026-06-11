// Problem: LeetCode 974 - Subarray Sums Divisible by K
// Description:
// Return the number of subarrays whose sum is divisible by k.

/*
Edge Cases:
- Negative numbers
- k = 1
- Entire array divisible by k
- Multiple valid subarrays
- Prefix sum becomes negative
*/


import java.util.*;


/* =======================
   Approach 1: Generate All Subarrays
   ======================= */

class Solution {

    public int subarraysDivByK(int[] nums, int k) {

        int count = 0;

        for(int i = 0; i < nums.length; i++){

            int sum = 0;

            for(int j = i; j < nums.length; j++){

                sum += nums[j];

                if(sum % k == 0){

                    count++;
                }
            }
        }

        return count;
    }
}

/*
Explanation:
- Generate every possible subarray
- Calculate running sum
- If sum % k == 0:
    valid subarray found

Example:
nums = [4,5,0,-2,-3,1]
k = 5

Valid subarrays:
[5]
[5,0]
[0]
[-2,-3]
...

Answer = 7

Time Complexity: O(n²)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Prefix Sum + HashMap (Optimal)
   ======================= */

class Solution {

    public int subarraysDivByK(int[] nums, int k) {

        Map<Integer, Integer> remainderCount =
            new HashMap<>();

        // empty prefix
        remainderCount.put(0, 1);

        int prefixSum = 0;

        int count = 0;

        for(int num : nums){

            prefixSum += num;

            // handle negative remainders
            int remainder =
                ((prefixSum % k) + k) % k;

            // same remainder seen before
            count += remainderCount
                        .getOrDefault(
                            remainder,
                            0
                        );

            remainderCount.put(
                remainder,
                remainderCount.getOrDefault(
                    remainder,
                    0
                ) + 1
            );
        }

        return count;
    }
}

/*
Explanation:

Key Observation:

If:

prefixSum1 % k
=
prefixSum2 % k

Then:

(prefixSum2 - prefixSum1)
is divisible by k

--------------------------------

Example:

nums = [4,5,0,-2,-3,1]
k = 5

Prefix Sums:

4
9
9
7
4
5

Remainders:

4
4
4
2
4
0

Notice:
remainder 4 appears multiple times

Every pair of equal remainders
creates a valid subarray.

--------------------------------

Why?

Suppose:

prefix1 % k = r

prefix2 % k = r

Then:

(prefix2 - prefix1) % k = 0

So subarray sum is divisible by k.

--------------------------------

Why this formula?

((prefixSum % k) + k) % k

Java can produce negative remainders.

Example:

-2 % 5 = -2

We convert it to:

((-2 + 5) % 5)
= 3

Valid remainder range:
0 to k-1

--------------------------------

Example:

nums = [4,5,0,-2,-3,1]
k = 5

Remainder frequencies:

4 appears 4 times

Number of subarrays formed:
C(4,2) = 6

Plus remainder 0 case

Answer = 7

Time Complexity: O(n)

Space Complexity: O(min(n, k))
*/