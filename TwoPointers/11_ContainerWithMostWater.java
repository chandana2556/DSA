// Problem: LeetCode 11 - Container With Most Water
// Description:
// Given an array height where each element represents the height of a vertical line,
// find two lines that together with the x-axis form a container
// such that the container holds the maximum amount of water.

/*
Edge Cases:
- Minimum array size
- All heights same
- Increasing heights
- Decreasing heights
- Contains zero heights
*/


import java.util.*;


/* =======================
   Approach 1: Nested Loops (Brute Force)
   ======================= */

class Solution {

    public int maxArea(int[] height) {

        int maxArea = 0;

        int n = height.length;

        // check every possible pair
        for(int i = 0; i < n; i++){

            for(int j = i + 1; j < n; j++){

                int width = j - i;

                int h =
                    Math.min(height[i], height[j]);

                maxArea =
                    Math.max(maxArea, width * h);
            }
        }

        return maxArea;
    }
}

/*
Explanation:
- Try every pair of lines
- Water stored:
    width * minimum height

Example:
height = [1,8,6,2,5,4,8,3,7]

Between:
8 and 7

width = 7
height = 7

Area = 49

Time Complexity: O(n²)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Two Pointers (Optimal)
   ======================= */

class Solution {

    public int maxArea(int[] height) {

        int left = 0;

        int right = height.length - 1;

        int maxArea = 0;

        while(left < right){

            int width = right - left;

            int h =
                Math.min(height[left],
                         height[right]);

            maxArea =
                Math.max(maxArea, width * h);

            // move smaller height
            if(height[left] < height[right]){

                left++;
            }

            else{

                right--;
            }
        }

        return maxArea;
    }
}

/*
Explanation:
- Start with widest container
- Area depends on:
    width * smaller height

- To possibly get larger area:
    move pointer with smaller height

Why?
- Moving taller height cannot increase area
- Width decreases every step
- Only larger minimum height can help

Example:
height = [1,8,6,2,5,4,8,3,7]

left = 1
right = 7

Area = 8

Move left because 1 is smaller

Eventually:
8 and 7 produce max area = 49

Time Complexity: O(n)
Space Complexity: O(1)
*/