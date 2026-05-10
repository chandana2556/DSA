// Problem: Check if two arrays contain the same elements
// with the same frequencies.

/*
Edge Cases:
- Different lengths
- Duplicate elements
- Empty arrays
- Negative numbers
*/

import java.util.*;

public boolean haveSameElements(int[] nums1, int[] nums2){

    // Different lengths → cannot be equal
    if(nums1.length != nums2.length){
        return false;
    }

    Map<Integer, Integer> freq = new HashMap<>();

    // Store frequency from nums1
    for(int num : nums1){
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    // Reduce frequency using nums2
    for(int num : nums2){

        // Element not found
        if(!freq.containsKey(num)){
            return false;
        }

        freq.put(num, freq.get(num) - 1);

        // Remove when count becomes 0
        if(freq.get(num) == 0){
            freq.remove(num);
        }
    }

    // If map is empty → arrays contain same elements
    return freq.isEmpty();
}

/*
Explanation:
- Count frequency of elements in nums1
- Reduce counts using nums2
- If frequencies match perfectly, map becomes empty

Example:
nums1 = [1,2,2,3]
nums2 = [2,3,1,2]

Frequency Map:
{1=1, 2=2, 3=1}

After processing nums2:
{}

Map empty → true

Time Complexity: O(n)
Space Complexity: O(n)
*/