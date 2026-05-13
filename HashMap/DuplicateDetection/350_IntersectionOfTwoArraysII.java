// Problem: LeetCode 350 - Intersection of Two Arrays II
// Description:
// Return an array of their intersection.
// Each element in the result must appear as many times as it shows in both arrays.

/*
Edge Cases:
- Empty arrays
- No common elements
- All elements same
- Different array sizes
- Duplicate elements
*/


import java.util.*;


/* =======================
   Approach 1: Nested Loops (Brute Force)
   ======================= */

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        int k = 0;

        int[] result =
            new int[Math.min(nums1.length, nums2.length)];

        for(int i = 0; i < nums1.length; i++){

            for(int j = 0; j < nums2.length; j++){

                // common element found
                if(nums1[i] == nums2[j]){

                    result[k] = nums1[i];
                    k++;

                    // mark element as used
                    nums2[j] = -1;

                    break;
                }
            }
        }

        return Arrays.copyOf(result, k);
    }
}

/*
Explanation:
- Compare every element of nums1 with nums2
- When match found:
    add to result
    mark nums2 element as used

Time Complexity: O(n * m)
Space Complexity: O(1)
(excluding output array)
*/


/* =======================
   Approach 2: HashMap
   ======================= */

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        // store frequency from nums1
        for(int num : nums1){

            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] result =
            new int[Math.min(nums1.length, nums2.length)];

        int k = 0;

        for(int i = 0; i < nums2.length; i++){

            // common element available
            if(freq.containsKey(nums2[i]) &&
               freq.get(nums2[i]) > 0){

                result[k] = nums2[i];
                k++;

                // reduce frequency
                freq.put(nums2[i], freq.get(nums2[i]) - 1);
            }
        }

        return Arrays.copyOf(result, k);
    }
}

/*
Explanation:
- Store frequencies of nums1
- Traverse nums2
- If element exists with positive frequency:
    add to result
    reduce frequency

Example:
nums1 = [1,2,2,1]
nums2 = [2,2]

freq:
1 → 2
2 → 2

Result:
[2,2]

Time Complexity: O(n + m)
Space Complexity: O(n)
*/


/* =======================
   Approach 3: Sorting + Two Pointers
   ======================= */

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        List<Integer> result = new ArrayList<>();

        while(i < nums1.length &&
              j < nums2.length){

            // common element found
            if(nums1[i] == nums2[j]){

                result.add(nums1[i]);

                i++;
                j++;
            }

            else if(nums1[i] < nums2[j]){
                i++;
            }

            else{
                j++;
            }
        }

        // convert list to array
        int[] arr = new int[result.size()];

        for(int k = 0; k < result.size(); k++){

            arr[k] = result.get(k);
        }

        return arr;
    }
}

/*
Explanation:
- Sort both arrays
- Use two pointers to compare elements
- Move smaller pointer forward
- Add equal elements to result

Time Complexity: O(n log n + m log m)
Space Complexity: O(1)
(excluding output list)
*/