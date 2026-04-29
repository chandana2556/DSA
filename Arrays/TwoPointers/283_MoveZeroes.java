// Problem: Move all zeroes to the end while maintaining the relative order of non-zero elements.
// Constraint: Do it in-place.

/* =======================
   Approach 1: Brute Force
   ======================= */

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
        int[] result = new int[n];

        // Collect non-zero elements
        for(int num : nums){
            if(num != 0){
                result[j++] = num;
            }
        }

        // Copy back to original array
        for(int i = 0; i < n; i++){
            nums[i] = result[i];
        }
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
Explanation: Uses an extra array to store non-zero elements, then copies back.
*/


/* ============================
   Approach 2: Two Pointer Swap
   ============================ */

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
Explanation: Moves non-zero elements forward using swapping.
Drawback: Performs unnecessary swaps when i == j.
*/


/* =======================
   Approach 3: Optimal
   ======================= */

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(i != j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
Explanation: Places non-zero elements at correct position and fills remaining with zeroes.
Avoids unnecessary swaps → more efficient.
*/