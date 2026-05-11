// Problem: LeetCode 287 - Find the Duplicate Number
// Description:
// Given an array containing n + 1 integers where each integer is in the range [1, n],
// return the duplicate number.

/*
Edge Cases:
- Duplicate appears multiple times
- Duplicate at beginning/end
- Small array size
- All values within range [1, n]
*/


import java.util.*;


/* =======================
   Approach 1: HashSet
   ======================= */

class Solution {
    public int findDuplicate(int[] nums) {

        Set<Integer> seen = new HashSet<>();

        for(int num : nums){

            // duplicate found
            if(seen.contains(num)){
                return num;
            }

            seen.add(num);
        }

        return -1;
    }
}

/*
Explanation:
- Store elements in HashSet
- If element already exists → duplicate found

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: HashMap
   ======================= */

class Solution {
    public int findDuplicate(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){

            freq.put(num, freq.getOrDefault(num, 0) + 1);

            // duplicate found
            if(freq.get(num) > 1){
                return num;
            }
        }

        return -1;
    }
}

/*
Explanation:
- Count frequency of each number
- Return number whose frequency becomes > 1

Time Complexity: O(n)
Space Complexity: O(n)
*/ww