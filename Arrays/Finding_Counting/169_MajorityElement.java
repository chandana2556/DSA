// Problem: Find the majority element in an array.
// The majority element is the element that appears more than ⌊n/2⌋ times.
// You may assume that the majority element always exists.

/*
Edge Cases:
- Array size = 1 → return that element
- All elements same → return that element
- Negative numbers allowed
- Large input size
*/

import java.util.*;

/* =======================
   Approach 1: HashMap
   ======================= */

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int threshold = nums.length / 2;

        for(int num : nums){
            int count = counts.getOrDefault(num, 0) + 1;
            counts.put(num, count);

            if(count > threshold){
                return num;
            }
        }

        return -1; // (problem guarantees existence, so this won't happen)
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)

Explanation:
- Count frequency of each element
- Return element whose count > n/2
*/


/* =======================
   Approach 2: Sorting
   ======================= */

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

/*
Time Complexity: O(n log n)
Space Complexity: O(1) (ignoring sort space)

Explanation:
- After sorting, the majority element will always be at index n/2
*/


/* =======================
   Approach 3: Optimal (Moore’s Voting Algorithm)
   ======================= */

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for(int num : nums){
            if(count == 0){
                candidate = num;
                count = 1;
            } 
            else if(num == candidate){
                count++;
            } 
            else {
                count--;
            }
        }

        return candidate;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)

Explanation:
- Cancel out different elements
- Majority element will remain as final candidate
*/