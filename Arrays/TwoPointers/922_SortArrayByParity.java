/*
============================================================
Problem: LeetCode 922 - Sort Array By Parity II
============================================================

Description:
Given an array nums containing an equal number of even and
odd integers, rearrange the array so that:

    - Every even index contains an even number.
    - Every odd index contains an odd number.

Return the rearranged array.

The order of the elements does not matter.

Example:
Input:
nums = [4,2,5,7]

Output:
[4,5,2,7]

Index:
0 → even
1 → odd
2 → even
3 → odd


Edge Cases:
- Array is already correctly arranged
- Even and odd numbers are in wrong positions
- Minimum valid array size
*/


/*
============================================================
Approach 1: Separate Even and Odd Arrays
============================================================

Create two arrays:

even → stores all even numbers
odd  → stores all odd numbers

Then place one even and one odd alternately
into the result array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        int n = nums.length;

        int[] even = new int[n / 2];
        int[] odd = new int[n / 2];

        int evenIndex = 0;
        int oddIndex = 0;

        for(int i = 0; i < n; i++){

            if(nums[i] % 2 == 0){
                even[evenIndex] = nums[i];
                evenIndex++;
            }else{
                odd[oddIndex] = nums[i];
                oddIndex++;
            }
        }

        int[] result = new int[n];

        int j = 0;

        for(int i = 0; i < n / 2; i++){

            result[j] = even[i];
            j++;

            result[j] = odd[i];
            j++;
        }

        return result;
    }
}


/*
============================================================
Approach 2: Even/Odd Position Pointers
============================================================

Create a result array.

Use:
    evenIndex = 0 → next even position
    oddIndex  = 1 → next odd position

If the number is even, place it at evenIndex.
If the number is odd, place it at oddIndex.

Move the corresponding index by 2.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        int evenIndex = 0;
        int oddIndex = 1;

        for(int num : nums){

            if(num % 2 == 0){

                result[evenIndex] = num;
                evenIndex += 2;

            }else{

                result[oddIndex] = num;
                oddIndex += 2;
            }
        }

        return result;
    }
}


/*
============================================================
Approach 3: Two Pointers - In-Place
============================================================

This approach does not use an extra result array.

Use two pointers:

i → checks even indices: 0, 2, 4, ...
j → checks odd indices: 1, 3, 5, ...

If nums[i] is already even:
    Move i by 2.

If nums[j] is already odd:
    Move j by 2.

Otherwise:
    nums[i] is odd
    nums[j] is even

Swap them.

Time Complexity: O(n)
Space Complexity: O(1)

This is the optimal approach because the array is
modified in-place.
*/

class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        int n = nums.length;

        int i = 0;
        int j = 1;

        while(i < n && j < n){

            if(nums[i] % 2 == 0){

                i += 2;

            }else if(nums[j] % 2 != 0){

                j += 2;

            }else{

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i += 2;
                j += 2;
            }
        }

        return nums;
    }
}


/*
============================================================
Execution Example
============================================================

Input:
nums = [4,2,5,7]

Even positions:
0 → 4 ✓
2 → 5 ✗

Odd positions:
1 → 2 ✗
3 → 7 ✓

Swap nums[2] and nums[1]:

[4,5,2,7]

Now:

index 0 → 4 → even ✓
index 1 → 5 → odd  ✓
index 2 → 2 → even ✓
index 3 → 7 → odd  ✓

*/