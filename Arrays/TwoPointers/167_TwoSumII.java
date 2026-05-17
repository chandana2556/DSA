// Problem: LeetCode 167 - Two Sum II - Input Array Is Sorted
// Description:
// Given a sorted array of integers,
// return the indices (1-indexed) of the two numbers such that they add up to target.
// Exactly one solution exists.

/*
Edge Cases:
- Array size = 2
- Negative numbers
- Duplicate values
- Target at beginning/end
- Large values
*/


import java.util.*;


/* =======================
   Approach 1: Nested Loops (Brute Force)
   ======================= */

class Solution {

    public int[] twoSum(int[] numbers, int target) {

        for(int i = 0; i < numbers.length; i++){

            for(int j = i + 1; j < numbers.length; j++){

                // pair found
                if(numbers[i] + numbers[j] == target){

                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{};
    }
}

/*
Explanation:
- Check every possible pair
- Return indices when sum equals target

Time Complexity: O(n²)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Binary Search
   ======================= */

class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;

        for(int i = 0; i < n - 1; i++){

            int complement = target - numbers[i];

            int left = i + 1;
            int right = n - 1;

            // binary search for complement
            while(left <= right){

                int mid =
                    left + (right - left) / 2;

                if(numbers[mid] == complement){

                    return new int[]{
                        i + 1,
                        mid + 1
                    };
                }

                else if(numbers[mid] < complement){

                    left = mid + 1;
                }

                else{

                    right = mid - 1;
                }
            }
        }

        return new int[]{};
    }
}

/*
Explanation:
- For each number:
    search complement using binary search

- Since array is sorted:
    binary search works efficiently

Example:
numbers = [2,7,11,15]
target = 9

For 2:
complement = 7

Binary search finds 7

Answer:
[1,2]

Time Complexity: O(n log n)
Space Complexity: O(1)
*/


/* =======================
   Approach 3: Two Pointers (Optimal)
   ======================= */

class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while(left < right){

            int sum =
                numbers[left] + numbers[right];

            // need larger sum
            if(sum < target){

                left++;
            }

            // need smaller sum
            else if(sum > target){

                right--;
            }

            // answer found
            else{

                return new int[]{
                    left + 1,
                    right + 1
                };
            }
        }

        return new int[]{};
    }
}

/*
Explanation:
- Array is sorted
- Use two pointers:
    left → smallest
    right → largest

- If sum too small:
    move left forward

- If sum too large:
    move right backward

- If sum equals target:
    return indices

Example:
numbers = [2,7,11,15]
target = 9

2 + 15 = 17 → decrease right
2 + 11 = 13 → decrease right
2 + 7 = 9 → found

Answer:
[1,2]

Time Complexity: O(n)
Space Complexity: O(1)
*/