/*
============================================================
Problem: LeetCode 1991 - Find the Middle Index in Array

Description:
Given an integer array nums, find the leftmost middle index.

A middle index is an index where the sum of elements to the
left is equal to the sum of elements to the right.

If no middle index exists, return -1.

Example:

Input:
nums = [1, 7, 3, 6, 5, 6]

Output:
3

Explanation:
For index 3:
Left sum  = 1 + 7 + 3 = 11
Right sum = 5 + 6 = 11

Therefore, index 3 is the middle index.
============================================================
*/


/*
============================================================
Approach 1: Brute Force

For every index, calculate the left sum and right sum
separately using two inner loops.

If both sums are equal, return the current index.

Time Complexity: O(n²)
Space Complexity: O(1)
============================================================
*/

class Solution {
    public int findMiddleIndex(int[] nums) {

        for(int i=0;i<nums.length;i++){

            int leftSum = 0;
            int rightSum = 0;

            for(int j=0;j<i;j++){
                leftSum += nums[j];
            }

            for(int j=i+1;j<nums.length;j++){
                rightSum += nums[j];
            }

            if(leftSum == rightSum){
                return i;
            }
        }

        return -1;
    }
}


/*
============================================================
Approach 2: Total Sum - Optimal

First calculate the total sum of the array.

For every index:
    rightSum = totalSum - leftSum - nums[i]

Then compare leftSum and rightSum.

Time Complexity: O(n)
Space Complexity: O(1)
============================================================
*/

class Solution {
    public int findMiddleIndex(int[] nums) {

        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        int leftSum = 0;

        for(int i=0;i<nums.length;i++){

            int rightSum = totalSum - leftSum - nums[i];

            if(leftSum == rightSum){
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}