// Problem: Return the third distinct maximum number in the array.
// If it does not exist, return the maximum number.
/*
Edge Cases:
- Less than 3 distinct elements → return max
- Duplicates → consider distinct only
- All elements same
- Negative values
*/

/* =======================
   Approach 1: Sorting
   ======================= */

import java.util.Arrays;

class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] != nums[i + 1]){
                count++;
            }
            if(count == 3){
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }
}

/*
Time Complexity: O(n log n)
Space Complexity: O(1) (ignoring sort space)

Explanation:
- Sort the array
- Traverse from the end and count distinct elements
*/


/* =======================
   Approach 2: Optimal
   ======================= */

class Solution {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for(int num : nums){
            // skip duplicates
            if(num == first || num == second || num == third){
                continue;
            }

            if(num > first){
                third = second;
                second = first;
                first = num;
            }
            else if(num > second){
                third = second;
                second = num;
            }
            else if(num > third){
                third = num;
            }
        }

        return (third == Long.MIN_VALUE) ? (int)first : (int)third;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)

Explanation:
- Maintain top 3 distinct values
- Use long to handle edge case when nums contains Integer.MIN_VALUE
*/