// Problem: LeetCode 448 - Find All Numbers Disappeared in an Array
// Description:
// Given an array nums of size n where nums[i] is in the range [1, n],
// return all numbers in the range [1, n] that do not appear in nums.

/*
Edge Cases:
- Empty array
- No missing numbers
- All numbers same
- Multiple missing numbers
- Missing numbers at beginning/end
*/


import java.util.*;


/* =======================
   Approach 1: HashSet
   ======================= */

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        Set<Integer> seen = new HashSet<>();

        // store existing numbers
        for(int num : nums){
            seen.add(num);
        }

        List<Integer> result = new ArrayList<>();

        // check numbers from 1 to n
        for(int i = 1; i <= nums.length; i++){

            if(!seen.contains(i)){
                result.add(i);
            }
        }

        return result;
    }
}

/*
Explanation:
- Store all array elements in HashSet
- Traverse numbers from 1 → n
- Missing numbers are not present in set

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: Index Marking (Optimal)
   ======================= */

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        // mark corresponding indices negative
        for(int i = 0; i < nums.length; i++){

            int index = Math.abs(nums[i]) - 1;

            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
        }

        List<Integer> result = new ArrayList<>();

        // positive indices = missing numbers
        for(int i = 0; i < nums.length; i++){

            if(nums[i] > 0){
                result.add(i + 1);
            }
        }

        return result;
    }
}

/*
Explanation:
- Use array indices as markers
- For value x:
    mark index (x - 1) negative

- Positive indices after traversal
  correspond to missing numbers

Example:
nums = [4,3,2,7,8,2,3,1]

Visited indices:
3,2,1,6,7

Indices still positive:
4,5

Missing numbers:
5,6

Time Complexity: O(n)
Space Complexity: O(1)
(excluding output list)
*/


/* =======================
   Approach 3: Cyclic Sort
   ======================= */

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        // place numbers at correct positions
        for(int i = 0; i < nums.length; i++){

            while(nums[i] != nums[nums[i] - 1]){

                int correctIndex = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        List<Integer> result = new ArrayList<>();

        // incorrect positions indicate missing numbers
        for(int i = 0; i < nums.length; i++){

            if(nums[i] != i + 1){
                result.add(i + 1);
            }
        }

        return result;
    }
}

/*
Explanation:
- Every number belongs to index:
    value - 1

- Place numbers at correct positions
- If nums[i] != i + 1:
    then (i + 1) is missing

Example:
nums = [4,3,2,7,8,2,3,1]

After cyclic sort:
[1,2,3,4,3,2,7,8]

Wrong positions:
index 4 → missing 5
index 5 → missing 6

Time Complexity: O(n)
Space Complexity: O(1)
*/