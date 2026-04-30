// Problem: Remove duplicates from a sorted array in-place.
// Return the number of unique elements.
// Maintain the relative order of elements.

/* =======================
   Approach: Two Pointers (Optimal)
   ======================= */

class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1; // position for next unique element

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[j - 1]){
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)

Explanation:
- Since the array is sorted, duplicates are adjacent.
- We use pointer 'i' to scan and 'j' to place unique elements.
- Compare current element with previous unique element (nums[j-1]).
- If different → place it at index j.
*/