// Problem: LeetCode 136 - Single Number
// Description: Every element appears twice except for one.
// Find the element that appears only once.

/*
Edge Cases:
- Array size = 1
- Negative numbers
- Single number at beginning/end
- All pairs except one
*/


import java.util.*;


/* =======================
   Approach 1: Nested Loops (Brute Force)
   ======================= */

class Solution {
    public int singleNumber(int[] nums) {

        for(int i = 0; i < nums.length; i++){

            boolean foundDuplicate = false;

            for(int j = 0; j < nums.length; j++){

                if(i != j && nums[i] == nums[j]){
                    foundDuplicate = true;
                    break;
                }
            }

            // unique element found
            if(!foundDuplicate){
                return nums[i];
            }
        }

        return -1;
    }
}

/*
Explanation:
- Compare each element with every other element
- If no duplicate found → return that element

Time Complexity: O(n²)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: HashMap
   ======================= */

class Solution {
    public int singleNumber(int[] nums) {

        Map<Integer, Integer> countMap = new HashMap<>();

        // count frequency
        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // find element with frequency 1
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){

            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return -1;
    }
}

/*
Explanation:
- Store frequency of each element
- Return element whose frequency is 1

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 3: XOR (Optimal)
   ======================= */

class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;

        for(int num : nums){
            result ^= num;
        }

        return result;
    }
}

/*
Explanation:
- XOR of same numbers becomes 0
    a ^ a = 0

- XOR with 0 keeps number unchanged
    a ^ 0 = a

- All duplicate pairs cancel out
- Remaining value is the single number

Example:
[2,2,1]

2 ^ 2 = 0
0 ^ 1 = 1

Answer = 1

Time Complexity: O(n)
Space Complexity: O(1)
*/