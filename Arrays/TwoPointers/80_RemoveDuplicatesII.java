// Problem: Remove duplicates in-place such that each element appears at most twice.
// Return the new length.

/* =======================
   Approach 1: Counting
   ======================= */

class Solution {
    public int removeDuplicates(int[] nums) {
        int overwrite = 1;
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                count++;
            } else {
                count = 1;
            }

            if(count <= 2){
                nums[overwrite++] = nums[i];
            }
        }

        return overwrite;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)

Explanation:
- Track frequency using 'count'
- Allow insertion only if count ≤ 2
- Maintains order
*/


/* =======================
   Approach 2: Optimal
   ======================= */

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;

        int overwrite = 2;

        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[overwrite - 2]){
                nums[overwrite++] = nums[i];
            }
        }

        return overwrite;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)

Explanation:
- Compare current element with element at (overwrite - 2)
- If different → safe to include (ensures max 2 duplicates)
- If same → skip
*/