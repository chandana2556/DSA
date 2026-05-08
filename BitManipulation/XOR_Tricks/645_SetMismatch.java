// Problem: LeetCode 645 - Set Mismatch
// Description:
// One number in the array appears twice and one number is missing.
// Return [duplicate, missing].

/*
Edge Cases:
- Duplicate at beginning
- Duplicate at end
- Missing number is 1
- Missing number is n
- Small array size
*/


import java.util.*;


/* =======================
   Approach 1: Sorting
   ======================= */

class Solution {
    public int[] findErrorNums(int[] nums) {

        Arrays.sort(nums);

        int duplicate = -1;
        int missing = -1;

        // check if 1 is missing
        if(nums[0] != 1){
            missing = 1;
        }

        for(int i = 1; i < nums.length; i++){

            // duplicate found
            if(nums[i] == nums[i - 1]){
                duplicate = nums[i];
            }

            // missing number found
            else if(nums[i] > nums[i - 1] + 1){
                missing = nums[i - 1] + 1;
            }
        }

        // missing number is n
        if(missing == -1){
            missing = nums.length;
        }

        return new int[]{duplicate, missing};
    }
}

/*
Explanation:
- Sort array
- Duplicate → adjacent equal elements
- Missing → gap between consecutive elements

Time Complexity: O(n log n)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: HashMap
   ======================= */

class Solution {
    public int[] findErrorNums(int[] nums) {

        int n = nums.length;

        Map<Integer, Integer> countMap = new HashMap<>();

        int duplicate = -1;
        int missing = -1;

        // count frequency
        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // find duplicate & missing
        for(int i = 1; i <= n; i++){

            int count = countMap.getOrDefault(i, 0);

            if(count == 2){
                duplicate = i;
            }
            else if(count == 0){
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }
}

/*
Explanation:
- Store frequency of each number
- Frequency 2 → duplicate
- Frequency 0 → missing

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 3: Index Marking (Optimal)
   ======================= */

class Solution {
    public int[] findErrorNums(int[] nums) {

        int n = nums.length;

        int duplicate = -1;
        int missing = -1;

        for(int i = 0; i < n; i++){

            int targetIdx = Math.abs(nums[i]) - 1;

            // already visited → duplicate
            if(nums[targetIdx] < 0){
                duplicate = Math.abs(nums[i]);
            }
            else{
                nums[targetIdx] = -nums[targetIdx];
            }
        }

        // positive index = missing number
        for(int i = 0; i < n; i++){

            if(nums[i] > 0){
                missing = i + 1;
            }
        }

        return new int[]{duplicate, missing};
    }
}

/*
Explanation:
- Use array indices as markers
- Mark visited indices negative
- If already negative → duplicate
- Positive index after traversal → missing number

Time Complexity: O(n)
Space Complexity: O(1)
*/