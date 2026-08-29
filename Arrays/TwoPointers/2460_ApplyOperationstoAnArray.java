/*
============================================================
Problem: LeetCode 2460 - Apply Operations to an Array
============================================================

Description:
Given an integer array nums, perform the following operations:

1. If nums[i] == nums[i + 1], multiply nums[i] by 2 and
   set nums[i + 1] to 0.

2. After applying all operations, move all zeroes to the
   end of the array while maintaining the relative order
   of the non-zero elements.

Return the resulting array.

Important:
The operations are performed from left to right.

Example:
Input:
nums = [1,2,2,1,1,0]

After applying operations:
[1,4,0,2,0,0]

After moving zeroes:
[1,4,2,0,0,0]


Edge Cases:
- Empty array
- Single element
- No equal adjacent elements
- All elements are zero
- Multiple consecutive equal elements
*/


/*
============================================================
Approach 1: Extra Array
============================================================

First perform the required operations.

Then create a new array and copy all non-zero elements
into it.

The remaining positions are automatically zero because
a new integer array is initialized with zeroes.

Time Complexity: O(n)
Space Complexity: O(n)
*/


class Solution {
    public int[] applyOperations(int[] nums) {

        int n = nums.length;

        for(int i = 0; i < n - 1; i++){

            if(nums[i] == nums[i + 1]){

                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int[] ans = new int[n];

        int j = 0;

        for(int i = 0; i < n; i++){

            if(nums[i] != 0){

                ans[j] = nums[i];
                j++;
            }
        }

        return ans;
    }
}


/*
============================================================
Approach 2: In-Place Two Pointers
============================================================

First perform the required operations.

Then use j to represent the position where the next
non-zero element should be placed.

Scan the array using i.

If nums[i] is non-zero:
    place it at nums[j]
    move j forward

After all non-zero elements are placed, fill the remaining
positions from j to the end with zeroes.

No extra array is required.

Time Complexity: O(n)
Space Complexity: O(1)

This is the optimal approach.
*/


class Solution {
    public int[] applyOperations(int[] nums) {

        int n = nums.length;

        for(int i = 0; i < n - 1; i++){

            if(nums[i] == nums[i + 1]){

                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }

        int j = 0;

        for(int i = 0; i < n; i++){

            if(nums[i] != 0){

                nums[j] = nums[i];
                j++;
            }
        }

        while(j < n){

            nums[j] = 0;
            j++;
        }

        return nums;
    }
}


/*
============================================================
Execution Example
============================================================

Input:
nums = [1,2,2,1,1,0]

Step 1: Apply Operations

i = 0:
1 != 2
[1,2,2,1,1,0]

i = 1:
2 == 2
2 becomes 4
next element becomes 0

[1,4,0,1,1,0]

i = 2:
0 != 1

i = 3:
1 == 1
1 becomes 2
next element becomes 0

[1,4,0,2,0,0]


Step 2: Move Zeroes

Copy non-zero elements to the front:

[1,4,2,_,_,_]

Fill remaining positions with zeroes:

[1,4,2,0,0,0]


Output:
[1,4,2,0,0,0]


Best Approach:
In-Place Two Pointers

Reason:
The operations themselves take O(n), and we can move the
non-zero elements using the same array without creating
another array.
*/