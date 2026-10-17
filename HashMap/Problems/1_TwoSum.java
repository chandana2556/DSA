/*
============================================================
Problem: LeetCode 1 - Two Sum

Description:
Given an integer array nums and an integer target, return
the indices of two numbers whose sum equals the target.

- Each input has exactly one solution.
- The same element cannot be used twice.
- The answer can be returned in any order.

Concept: HashMap

- Create a HashMap to store each number and its index.
- For every element, calculate its complement:
      complement = target - nums[i]
- If the complement exists in the HashMap, return the
  complement's index and the current index.
- Otherwise, store the current number and its index.
- Storing the current element after checking prevents
  using the same element twice.

Example:

Input:
nums = [2, 7, 11, 15]
target = 9

Output:
[0, 1]

Explanation:
nums[0] + nums[1] = 2 + 7 = 9

Therefore, the answer is [0, 1].

============================================================
Approach: HashMap (One Pass)

Time Complexity: O(n)
Space Complexity: O(n)
============================================================
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}