// Problem: Find all elements that appear more than ⌊n/3⌋ times.
// There can be at most 2 such elements.

/*
Edge Cases:
- Array size = 1 → return that element
- Array size = 2 → return both if distinct
- No element > n/3 → return empty list
- Negative numbers allowed
*/

import java.util.*;

/* =======================
   Approach 1: HashMap
   ======================= */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int threshold = n / 3;

        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Count frequency
        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Collect elements > n/3
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            if(entry.getValue() > threshold){
                result.add(entry.getKey());
            }
        }

        return result;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)

Explanation:
- Count frequency using HashMap
- Add elements with count > n/3
*/


/* =======================
   Approach 2: Sorting
   ======================= */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int threshold = n / 3;
        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums);

        int i = 0;
        while(i < n){
            int current = nums[i];
            int count = 0;

            while(i < n && nums[i] == current){
                count++;
                i++;
            }

            if(count > threshold){
                result.add(current);
            }
        }

        return result;
    }
}

/*
Time Complexity: O(n log n)
Space Complexity: O(1)

Explanation:
- Sort array → duplicates become adjacent
- Count occurrences and check threshold
*/


/* =======================
   Approach 3: Optimal (Moore’s Voting - Extended)
   ======================= */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1 = 0, cand2 = 0;
        int count1 = 0, count2 = 0;

        // Step 1: Find candidates
        for(int num : nums){
            if(num == cand1){
                count1++;
            } 
            else if(num == cand2){
                count2++;
            } 
            else if(count1 == 0){
                cand1 = num;
                count1 = 1;
            } 
            else if(count2 == 0){
                cand2 = num;
                count2 = 1;
            } 
            else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify candidates
        count1 = 0;
        count2 = 0;

        for(int num : nums){
            if(num == cand1) count1++;
            else if(num == cand2) count2++;
        }

        List<Integer> result = new ArrayList<>();

        if(count1 > nums.length / 3) result.add(cand1);
        if(count2 > nums.length / 3) result.add(cand2);

        return result;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)

Explanation:
- At most 2 elements can appear > n/3 times
- Use two candidates and cancel out others
- Verify counts in second pass
*/