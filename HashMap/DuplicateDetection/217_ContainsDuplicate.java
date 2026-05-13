// Problem: LeetCode 217 - Contains Duplicate
// Description:
// Return true if any value appears at least twice in the array.
// Return false if every element is distinct.

/*
Edge Cases:
- Empty array
- Single element
- All elements same
- No duplicates
- Negative numbers
*/


import java.util.*;


/* =======================
   Approach 1: Nested Loops (Brute Force)
   ======================= */

class Solution {

    public boolean containsDuplicate(int[] nums) {

        for(int i = 0; i < nums.length; i++){

            for(int j = i + 1; j < nums.length; j++){

                // duplicate found
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }

        return false;
    }
}

/*
Explanation:
- Compare every pair of elements
- If any two elements are equal → duplicate exists

Time Complexity: O(n²)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Sorting
   ======================= */

class Solution {

    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);

        // duplicates become adjacent after sorting
        for(int i = 1; i < nums.length; i++){

            if(nums[i] == nums[i - 1]){
                return true;
            }
        }

        return false;
    }
}

/*
Explanation:
- Sort array
- Check adjacent elements for duplicates

Time Complexity: O(n log n)
Space Complexity: O(1)
(ignoring sorting space)
*/


/* =======================
   Approach 3: HashSet (Optimal)
   ======================= */

class Solution {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> seen = new HashSet<>();

        for(int num : nums){

            // duplicate found
            if(seen.contains(num)){
                return true;
            }

            seen.add(num);
        }

        return false;
    }
}

/*
Explanation:
- Store elements in HashSet
- If element already exists:
    duplicate found

Example:
nums = [1,2,3,1]

seen = {1,2,3}

Encounter 1 again → true

Time Complexity: O(n)
Space Complexity: O(n)
*/