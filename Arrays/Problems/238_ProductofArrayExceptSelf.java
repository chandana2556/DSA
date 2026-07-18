// Problem: LeetCode 238 - Product of Array Except Self
// Description:
// Given an integer array nums,
// return an array answer such that
// answer[i] is equal to the product of all
// elements except nums[i].
//
// Do not use division.
// Solve in O(n) time.

/*
Edge Cases:
- Contains zero
- Multiple zeros
- Negative numbers
- Single positive/negative numbers
- Large product values
*/

import java.util.*;


/* =======================
   Approach 1: Brute Force
   ======================= */

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        for(int i = 0; i < n; i++){

            int product = 1;

            for(int j = 0; j < n; j++){

                if(i != j){

                    product *= nums[j];
                }
            }

            result[i] = product;
        }

        return result;
    }
}

/*
Explanation:

For every index,

Multiply every element
except itself.

Input:

nums = [1,2,3,4]

Output:

[24,12,8,6]

Time Complexity: O(n²)

Space Complexity: O(n)
*/


/* =======================
   Approach 2: Prefix + Suffix Arrays
   ======================= */

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        // Prefix products
        prefix[0] = 1;

        for(int i = 1; i < n; i++){

            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Suffix products
        suffix[n - 1] = 1;

        for(int i = n - 2; i >= 0; i--){

            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Final answer
        for(int i = 0; i < n; i++){

            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}

/*
Explanation:

Prefix[i]
=
Product of all elements
before i.

Suffix[i]
=
Product of all elements
after i.

Answer

=
Prefix × Suffix

Input:

nums = [1,2,3,4]

Prefix:

[1,1,2,6]

Suffix:

[24,12,4,1]

Output:

[24,12,8,6]

Time Complexity: O(n)

Space Complexity: O(n)
*/


/* =======================
   Approach 3: Prefix + Running Suffix (Optimal)
   ======================= */

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        // Store prefix products directly
        result[0] = 1;

        for(int i = 1; i < n; i++){

            result[i] = result[i - 1] * nums[i - 1];
        }

        // Running suffix product
        int suffixProduct = 1;

        for(int i = n - 1; i >= 0; i--){

            result[i] *= suffixProduct;

            suffixProduct *= nums[i];
        }

        return result;
    }
}

/*
Explanation:

First pass:

Store Prefix Product
inside result array.

Second pass:

Maintain one variable

suffixProduct

Multiply it with
existing prefix product.

No extra suffix array needed.

Input:

nums = [1,2,3,4]

After Prefix Pass:

result

[1,1,2,6]

Second Pass:

suffixProduct = 1

Output:

[24,12,8,6]

Time Complexity: O(n)

Space Complexity: O(1)
(excluding output array)
*/