
/*
LeetCode 162: Find Peak Element

Problem Description:
Given an integer array nums, find a peak element and return its index.
A peak element is an element that is strictly greater than its neighbors.

Example 1:
Input: nums = [1,2,3,1]
Output: 2

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5

--------------------------------------------------
Approach 1: Linear Search

Explanation:
1. Traverse the array from index 1 to n-2.
2. Check whether the current element is greater than
   both its left and right neighbors.
3. If true, return its index.
4. Check the first and last elements separately.

Time Complexity: O(n)
Space Complexity: O(1)

Code:

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] &&
                nums[i] > nums[i + 1]) {
                return i;
            }
        }

        if (n == 1) return 0;

        if (nums[0] > nums[1]) return 0;

        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        return -1;
    }
}

--------------------------------------------------
Approach 2: Iterative Binary Search

Explanation:
1. Initialize left = 0 and right = n-1.
2. Calculate mid.
3. If nums[mid] < nums[mid+1], search the right half.
4. Otherwise, search the left half including mid.
5. Continue until left == right.
6. Return left.

Time Complexity: O(log n)
Space Complexity: O(1)

Code:

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

--------------------------------------------------
Approach 3: Recursive Binary Search

Explanation:
1. Pass the array, left and right to the recursive function.
2. If left == right, return left.
3. Calculate mid.
4. If nums[mid] < nums[mid+1], recursively search
   the right half.
5. Otherwise, recursively search the left half
   including mid.

Time Complexity: O(log n)
Space Complexity: O(log n)

Code:

class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] < nums[mid + 1]) {
            return binarySearch(nums, mid + 1, right);
        } else {
            return binarySearch(nums, left, mid);
        }
    }
}

--------------------------------------------------
Complexity Comparison:

Approach 1: Linear Search
TC: O(n)
SC: O(1)

Approach 2: Iterative Binary Search
TC: O(log n)
SC: O(1)

Approach 3: Recursive Binary Search
TC: O(log n)
SC: O(log n)

Best Approach:
Iterative Binary Search because it takes O(log n)
time and O(1) extra space.
*/
