// Problem: LeetCode 26 - Remove Duplicates from Sorted Array
// Description:
// Remove duplicates from a sorted array in-place
// such that each unique element appears only once.
// Return the number of unique elements.

/*
Edge Cases:
- Empty array
- Single element
- All elements same
- No duplicates
- Negative numbers
*/


import java.util.*;


/* =======================
   Approach 1: HashSet + Sorting
   ======================= */

class Solution {

    public int removeDuplicates(int[] nums) {

        HashSet<Integer> seen =
            new HashSet<>();

        // store unique elements
        for(int num : nums){

            seen.add(num);
        }

        // convert to list
        List<Integer> unique =
            new ArrayList<>(seen);

        // sort because HashSet loses order
        Collections.sort(unique);

        // copy back into nums
        for(int i = 0;
            i < unique.size();
            i++){

            nums[i] = unique.get(i);
        }

        return unique.size();
    }
}

/*
Explanation:
- HashSet automatically removes duplicates
- Convert set back to list
- Sort because original array must remain sorted
- Copy unique elements into nums

Example:
nums = [1,1,2]

HashSet:
[1,2]

Final nums:
[1,2]

Time Complexity: O(n log n)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: Two Pointers (Optimal)
   ======================= */

class Solution {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;

        int j = 1;

        for(int i = 1; i < n; i++){

            // new unique element found
            if(nums[i] != nums[j - 1]){

                nums[j] = nums[i];

                j++;
            }
        }

        return j;
    }
}

/*
Explanation:
- Array is already sorted
- Duplicates appear consecutively

Pointers:
i → scans array
j → position for next unique element

Example:
nums = [1,1,2,2,3]

Process:
1 stored
skip duplicate 1
2 stored
skip duplicate 2
3 stored

Final:
[1,2,3]

Return:
3

Time Complexity: O(n)
Space Complexity: O(1)
*/