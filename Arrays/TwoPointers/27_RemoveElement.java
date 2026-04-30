// Problem: Remove all occurrences of a given value in-place and return the new length.
// The order of elements may change (depending on approach).

/* =======================
   Approach 1: Brute Force
   ======================= */

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int[] result = new int[n];
        int j = 0;

        // Store elements not equal to val
        for(int i = 0; i < n; i++){
            if(nums[i] != val){
                result[j++] = nums[i];
            }
        }

        // Copy back to original array
        for(int i = 0; i < n; i++){
            nums[i] = result[i];
        }

        return j;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
Explanation: Uses an extra array to store valid elements.
*/


/* ===========================
   Approach 2: Two Pointer (Stable)
   =========================== */

class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
Explanation: Keeps non-val elements in order (stable).
*/


/* ===========================
   Approach 3: Optimal (Swap with End)
   =========================== */

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;

        while(i < n){
            if(nums[i] == val){
                nums[i] = nums[n - 1];
                n--;   // reduce array size
            } else {
                i++;
            }
        }

        return n;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
Explanation: Replaces val elements with last element.
Order is NOT maintained but reduces operations.
*/