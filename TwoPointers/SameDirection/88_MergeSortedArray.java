// Problem: LeetCode 88 - Merge Sorted Array
// Description:
// Merge nums2 into nums1 as one sorted array.
// nums1 has enough space to hold additional elements from nums2.

/*
Edge Cases:
- nums2 empty
- nums1 empty
- All elements of nums1 smaller
- All elements of nums2 smaller
- Duplicate values
*/


import java.util.*;


/* =======================
   Approach 1: Copy + Sort
   ======================= */

class Solution {

    public void merge(int[] nums1,
                      int m,
                      int[] nums2,
                      int n) {

        // copy nums2 into nums1
        for(int j = 0; j < n; j++){

            nums1[m + j] = nums2[j];
        }

        // sort merged array
        Arrays.sort(nums1);
    }
}

/*
Explanation:
- Insert nums2 elements into empty positions of nums1
- Sort entire array

Example:
nums1 = [1,2,3,0,0,0]
nums2 = [2,5,6]

After copy:
[1,2,3,2,5,6]

After sorting:
[1,2,2,3,5,6]

Time Complexity: O((m+n) log(m+n))
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Three Pointers (Optimal)
   ======================= */

class Solution {

    public void merge(int[] nums1,int m,int[] nums2,int n) {

        int i = m - 1;         // last valid element in nums1
        int j = n - 1;         // last element in nums2
        int k = m + n - 1;     // last position in nums1

        // merge from end
        while(i >= 0 && j >= 0){

            if(nums1[i] > nums2[j]){

                nums1[k] = nums1[i];

                i--;
            }

            else{

                nums1[k] = nums2[j];

                j--;
            }

            k--;
        }

        // copy remaining nums2 elements
        while(j >= 0){

            nums1[k] = nums2[j];

            j--;
            k--;
        }
    }
}

/*
Explanation:
- Start filling nums1 from the end
- Compare largest remaining elements
- Place larger element at index k

Why from end?
- Prevent overwriting existing elements in nums1

Example:
nums1 = [1,2,3,0,0,0]
nums2 = [2,5,6]

Compare:
3 vs 6 → place 6
3 vs 5 → place 5
3 vs 2 → place 3

Final:
[1,2,2,3,5,6]

Time Complexity: O(m + n)
Space Complexity: O(1)
*/