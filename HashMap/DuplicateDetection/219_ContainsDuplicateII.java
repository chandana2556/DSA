// Problem: LeetCode 219 - Contains Duplicate II
// Description:
// Return true if there are two distinct indices i and j such that:
//    nums[i] == nums[j]
//    and |i - j| <= k

/*
Edge Cases:
- Empty array
- Single element
- Duplicate outside k range
- Duplicate inside k range
- Multiple duplicates
- k = 0
*/


import java.util.*;


/* =======================
   Approach 1: Nested Loops (Brute Force)
   ======================= */

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        for(int i = 0; i < nums.length; i++){

            for(int j = i + 1; j < nums.length; j++){

                // duplicate within range k
                if(nums[i] == nums[j] &&
                   Math.abs(i - j) <= k){

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
- Check:
    nums[i] == nums[j]
    and distance <= k

Time Complexity: O(n²)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: HashMap (Optimal)
   ======================= */

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> lastSeen = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            // duplicate found within range
            if(lastSeen.containsKey(nums[i]) &&
               i - lastSeen.get(nums[i]) <= k){

                return true;
            }

            // update latest index
            lastSeen.put(nums[i], i);
        }

        return false;
    }
}

/*
Explanation:
- Store last seen index of each number
- If same number appears again:
    check distance between indices

Example:
nums = [1,2,3,1]
k = 3

1 first seen at index 0
1 again at index 3

distance = 3 → true

Time Complexity: O(n)
Space Complexity: O(n)
*/
/*
Approach 3 :- Sliding Window with HashMap
"I'll do this later "
*/