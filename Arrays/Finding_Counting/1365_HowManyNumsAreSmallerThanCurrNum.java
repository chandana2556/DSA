// Problem: LeetCode 1365 - How Many Numbers Are Smaller Than the Current Number
// Description:
// Given an array nums, for each element nums[i],
// return how many numbers in the array are strictly
// smaller than nums[i].

/*
Edge Cases:
- Single element array
- All elements are the same
- Already sorted array
- Reverse sorted array
- Contains minimum value (0)
- Contains maximum value (100)
*/


import java.util.*;


/* =======================
   Approach 1: Brute Force
   ======================= */

class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){

            int count = 0;

            for(int j = 0; j < nums.length; j++){

                if(nums[i] > nums[j]){
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }
}

/*
Explanation:

For every element,
compare it with every other element.

If another element is smaller,
increase the count.

Example:

nums = [8,1,2,2,3]

8 → 4 numbers smaller

1 → 0 numbers smaller

2 → 1 number smaller

2 → 1 number smaller

3 → 3 numbers smaller

Answer:

[4,0,1,1,3]

Time Complexity: O(n²)

Space Complexity: O(n)
(result array)
*/


/* =======================
   Approach 2: Counting Sort / Frequency Array (Optimal)
   ======================= */

class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {

        // Since 0 <= nums[i] <= 100
        int[] freq = new int[101];

        // Count frequency of each number
        for(int num : nums){

            freq[num]++;
        }

        // smaller[i] = count of numbers smaller than i
        int[] smaller = new int[101];

        for(int i = 1; i <= 100; i++){

            smaller[i] = smaller[i - 1] + freq[i - 1];
        }

        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){

            ans[i] = smaller[nums[i]];
        }

        return ans;
    }
}

/*
Explanation:

Step 1:
Store frequency of every number.

Example:

nums = [8,1,2,2,3]

Frequency:

1 -> 1

2 -> 2

3 -> 1

8 -> 1

--------------------------------

Step 2:

Build prefix count.

smaller[i]

stores how many numbers
are smaller than i.

Example:

smaller[2]

=

frequency of 0

+

frequency of 1

=

1

Meaning:
Only one number is smaller than 2.

--------------------------------

Step 3:

For every element,

Answer = smaller[element]

Example:

8 → 4

1 → 0

2 → 1

2 → 1

3 → 3

Answer:

[4,0,1,1,3]

Time Complexity: O(n + 101)
≈ O(n)

Space Complexity: O(101)
≈ O(1)