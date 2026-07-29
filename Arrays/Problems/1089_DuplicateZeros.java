// Problem: LeetCode 1089 - Duplicate Zeros
// Description:
// Given a fixed-length integer array arr,
// duplicate each occurrence of zero,
// shifting the remaining elements to the right.
//
// Elements beyond the length of the original
// array are discarded.
//
// Modify the input array in-place.

/*
Edge Cases:
- No zeros
- All zeros
- Zero at the last index
- Consecutive zeros
- Single element array
*/

import java.util.*;


/* =======================
   Approach 1: Brute Force
   ======================= */

class Solution {

    public void duplicateZeros(int[] arr) {

        int n = arr.length;

        for(int i = 0; i < n; i++){

            if(arr[i] == 0){

                // Shift elements to the right
                for(int j = n - 1; j > i + 1; j--){

                    arr[j] = arr[j - 1];
                }

                // Duplicate the zero
                if(i + 1 < n){

                    arr[i + 1] = 0;
                }

                // Skip duplicated zero
                i++;
            }
        }
    }
}

/*
Explanation:

Whenever a zero is found,

shift all elements to the right
by one position.

Insert another zero
next to the original zero.

Elements beyond array size
are discarded.

Input:

arr = [1,0,2,3,0,4,5,0]

Output:

[1,0,0,2,3,0,0,4]

----------------------------

Input:

arr = [1,2,3]

Output:

[1,2,3]

Time Complexity: O(n²)

Space Complexity: O(1)
*/


/* =======================
   Approach 2: Two Pointers (Optimal)
   ======================= */

class Solution {

    public void duplicateZeros(int[] arr) {

        int zeroes = 0;

        // Count total zeros
        for(int num : arr){

            if(num == 0){

                zeroes++;
            }
        }

        int n = arr.length;

        int i = n - 1;

        // Virtual index after duplication
        int j = n + zeroes - 1;

        while(i >= 0){

            // Copy current element
            if(j < n){

                arr[j] = arr[i];
            }

            // Duplicate zero
            if(arr[i] == 0){

                j--;

                if(j < n){

                    arr[j] = 0;
                }
            }

            i--;
            j--;
        }
    }
}

/*
Explanation:

Imagine the array after duplicating
all zeros.

Example:

Input:

arr = [1,0,2,3,0]

Virtual Array:

[1,0,0,2,3,0,0]

Its size becomes larger than
the original array.

Instead of creating this array,

start copying from the end.

Two pointers:

i -> Original array

j -> Virtual array

Copy values from right to left.

If a zero is found,

write it twice.

Ignore positions where

j >= array length

because they lie outside
the original array.

Input:

arr = [1,0,2,3,0,4,5,0]

Output:

[1,0,0,2,3,0,0,4]

----------------------------

Input:

arr = [1,2,3]

Output:

[1,2,3]

Time Complexity: O(n)

Space Complexity: O(1)
*/