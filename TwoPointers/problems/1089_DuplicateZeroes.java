/*
============================================================
Problem: LeetCode 1089 - Duplicate Zeros

Description:
Given a fixed-length integer array arr, duplicate each
occurrence of zero, shifting the remaining elements to
the right.

Elements beyond the original array length are discarded.

The modification must be done in-place without returning
anything.

Example:

Input:
arr = [1, 0, 2, 3, 0, 4, 5, 0]

Output:
[1, 0, 0, 2, 3, 0, 0, 4]

Concept:
When a zero is found, it must appear twice.
Since the array length is fixed, elements at the end may
be discarded after shifting.

============================================================
Approach 1: Brute Force - Shifting Elements

- Traverse the array from left to right.
- When a zero is found, shift all subsequent elements
  one position to the right.
- Skip the duplicated zero by incrementing i.
- Continue until the end of the array.

Time Complexity: O(n²)
Space Complexity: O(1)
============================================================
*/

class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
    }
}


/*
============================================================
Approach 2: Two Pointers - Backward Traversal

- Count the total number of zeros in the array.
- Set i to the last original index.
- Set j to the last index of the virtually expanded array.
- Traverse backward and copy elements from i to j.
- Whenever a zero is encountered, write an additional zero.
- Only write when j is within the original array bounds.

This avoids repeatedly shifting elements and is more
efficient than Approach 1.

Time Complexity: O(n)
Space Complexity: O(1)
============================================================
*/

class Solution {
    public void duplicateZeros(int[] arr) {
        int zeroes = 0;

        for (int num : arr) {
            if (num == 0) {
                zeroes++;
            }
        }

        int n = arr.length;
        int i = n - 1;
        int j = n + zeroes - 1;

        while (i >= 0) {
            if (j < n) {
                arr[j] = arr[i];
            }

            if (arr[i] == 0) {
                j--;

                if (j < n) {
                    arr[j] = 0;
                }
            }

            i--;
            j--;
        }
    }
}