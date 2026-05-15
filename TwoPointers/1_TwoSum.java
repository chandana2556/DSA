// Problem: LeetCode 1 - Two Sum
// Description:
// Return indices of the two numbers such that they add up to target.
// Assume exactly one solution exists.

/*
Edge Cases:
- Negative numbers
- Duplicate values
- Target formed by same number twice
- Array size = 2
- Target at beginning/end
*/


import java.util.*;


/* =======================
   Approach 1: Nested Loops (Brute Force)
   ======================= */

class Solution {

    public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++){

            for(int j = i + 1; j < nums.length; j++){

                // pair found
                if(nums[i] + nums[j] == target){

                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
}

/*
Explanation:
- Check every possible pair
- Return indices when sum equals target

Example:
nums = [2,7,11,15]
target = 9

2 + 7 = 9

Answer:
[0,1]

Time Complexity: O(n²)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: HashMap (Optimal)
   ======================= */

class Solution {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> checked =
            new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            int complement = target - nums[i];

            // complement already exists
            if(checked.containsKey(complement)){

                return new int[]{
                    checked.get(complement),
                    i
                };
            }

            // store current number and index
            checked.put(nums[i], i);
        }

        return new int[]{};
    }
}

/*
Explanation:
- For every number:
    complement = target - current number

- Check if complement already exists
- If yes:
    pair found

Example:
nums = [2,7,11,15]
target = 9

i=0:
store 2

i=1:
complement = 2
2 exists → answer found

Time Complexity: O(n)
Space Complexity: O(n)
*/