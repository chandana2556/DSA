// Problem: Find the maximum number of consecutive 1s in a binary array.

/* =======================
   Approach 1: Brute Force
   ======================= */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                int count = 0;
                int j = i;

                while(j < nums.length && nums[j] == 1){
                    count++;
                    j++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}

/*
Time Complexity: O(n^2) in worst case (e.g., many 1s → repeated scans)
Space Complexity: O(1)

Explanation:
- For each 1, expand forward to count consecutive 1s.
- Repeats work → inefficient.
*/


/* =======================
   Approach 2: Optimal (Single Pass)
   ======================= */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for(int num : nums){
            if(num == 1){
                count++;
            } else {
                count = 0;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)

Explanation:
- Keep a running count of consecutive 1s.
- Reset when a 0 appears.
- Track maximum count.
*/