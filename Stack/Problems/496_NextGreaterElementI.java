/*
============================================================
Problem: LeetCode 496 - Next Greater Element I

Description:
You are given two integer arrays nums1 and nums2, where
nums1 is a subset of nums2.

For every element in nums1, find the first greater element
that appears to its right in nums2.

If no greater element exists, return -1 for that element.

Concept:
This problem can be solved using Brute Force and a
Monotonic Stack with a HashMap.

Example:

Input:
nums1 = [4, 1, 2]
nums2 = [1, 3, 4, 2]

Output:
[-1, 3, -1]

Explanation:
4 has no greater element to its right -> -1
1's next greater element is 3 -> 3
2 has no greater element to its right -> -1
============================================================
*/


/*
============================================================
Approach 1: Brute Force

Concept:
- Traverse each element in nums1.
- Find that element's position in nums2.
- Search the elements to its right.
- Return the first element greater than the current element.
- If no greater element exists, keep the result as -1.

Time Complexity: O(n * m)
Space Complexity: O(n)

Where:
n = length of nums1
m = length of nums2
============================================================
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            int num = nums1[i];
            result[i] = -1;

            for (int j = 0; j < nums2.length; j++) {

                if (nums2[j] == num) {

                    for (int k = j + 1; k < nums2.length; k++) {

                        if (nums2[k] > num) {
                            result[i] = nums2[k];
                            break;
                        }
                    }

                    break;
                }
            }
        }

        return result;
    }
}


/*
============================================================
Approach 2: Monotonic Stack + HashMap

Concept:
- Traverse nums2 from left to right.
- Maintain a stack of elements whose next greater
  element has not been found yet.
- If the current number is greater than the stack's top,
  it is the next greater element for that top element.
- Store this relationship in a HashMap.
- Push the current number onto the stack.
- After traversal, remaining elements have no greater
  element, so map them to -1.
- Use the HashMap to build the result for nums1.

Time Complexity: O(n + m)
Space Complexity: O(m + n)

Where:
n = length of nums1
m = length of nums2
============================================================
*/

import java.util.Stack;
import java.util.HashMap;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] result = new int[nums1.length];

        for (int num : nums2) {

            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}