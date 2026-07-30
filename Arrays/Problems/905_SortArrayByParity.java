// Problem: LeetCode 905 - Sort Array By Parity
// Description:
// Given an integer array nums,
// move all even integers to the beginning
// of the array followed by all odd integers.
//
// Return any valid answer.

/*
Edge Cases:
- Empty array
- Single element
- All even numbers
- All odd numbers
- Mixture of even and odd numbers
*/

import java.util.*;


/* =======================
   Approach 1: Two Pointers (Optimal)
   ======================= */

class Solution {

    public int[] sortArrayByParity(int[] nums) {

        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while(left < right){

            if(nums[left] % 2 == 0){

                left++;
            }
            else{

                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

                right--;
            }
        }

        return nums;
    }
}

/*
Explanation:

Use two pointers.

left
starts from the beginning.

right
starts from the end.

If nums[left] is even,

it is already in the correct position,
so move left forward.

If nums[left] is odd,

swap it with the element at right
and move right backward.

Input:

nums = [3,1,2,4]

Possible Output:

[4,2,1,3]

(or)

[2,4,3,1]

Both are correct.

Time Complexity: O(n)

Space Complexity: O(1)
*/


/* =======================
   Approach 2: Extra Array
   ======================= */

class Solution {

    public int[] sortArrayByParity(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        int index = 0;

        // Store even numbers
        for(int i = 0; i < n; i++){

            if(nums[i] % 2 == 0){

                result[index] = nums[i];

                index++;
            }
        }

        // Store odd numbers
        for(int i = 0; i < n; i++){

            if(nums[i] % 2 != 0){

                result[index] = nums[i];

                index++;
            }
        }

        return result;
    }
}

/*
Explanation:

Create a new array.

Step 1:

Traverse the original array
and copy all even numbers.

Step 2:

Traverse again
and copy all odd numbers.

Input:

nums = [3,1,2,4]

Result Array:

After first pass:

[2,4,_,_]

After second pass:

[2,4,3,1]

Output:

[2,4,3,1]

Time Complexity: O(n)

Space Complexity: O(n)
*/