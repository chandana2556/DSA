// Problem: Find missing ranges between [lower, upper] given a sorted array.

/*
Edge Cases:
- Empty array
- No missing range
- Missing before first element
- Missing after last element
- Gaps between elements
- Single element array
- Negative values
- Large values (overflow)
*/

/* =======================
   Approach: Gap Traversal (Better)
   ======================= */

import java.util.*;

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Case 1: Empty array
        if(n == 0){
            result.add(Arrays.asList(lower, upper));
            return result;
        }

        // Case 2: Before first element
        if(lower < nums[0]){
            result.add(Arrays.asList(lower, nums[0] - 1));
        }

        // Case 3: Between elements
        for(int i = 0; i < n - 1; i++){
            if((long)nums[i + 1] - nums[i] > 1){
                result.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        // Case 4: After last element
        if(nums[n - 1] < upper){
            result.add(Arrays.asList(nums[n - 1] + 1, upper));
        }

        return result;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1) (excluding output)

Explanation:
- Check gaps before, between, and after elements
- Add missing ranges accordingly
*/