// Problem: Rotate the array to the right by k steps.
// Constraint: Do it in-place if possible.

/* =======================
   Approach 1: Brute Force
   ======================= */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle large k

        for(int i = 0; i < k; i++){
            int last = nums[n - 1];

            // shift elements right
            for(int j = n - 1; j > 0; j--){
                nums[j] = nums[j - 1];
            }

            nums[0] = last;
        }
    }
}

/*
Time Complexity: O(n * k)
Space Complexity: O(1)

Explanation:
- Each rotation shifts all elements by 1.
- Repeated k times → O(n * k)
*/


/* =======================
   Approach 2: Extra Array
   ======================= */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        k = k % n;

        for(int i = 0; i < n; i++){
            temp[(i + k) % n] = nums[i];
        }

        // copy back
        for(int i = 0; i < n; i++){
            nums[i] = temp[i];
        }
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)

Explanation:
- Directly places each element in its correct rotated position.
*/


/* =======================
   Approach 3: Optimal (Reversal)
   ======================= */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);     // reverse whole array
        reverse(nums, 0, k - 1);     // reverse first k elements
        reverse(nums, k, n - 1);     // reverse remaining
    }

    private void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)

Explanation:
- Reverse whole array → elements come in reverse order
- Reverse first k → correct front part
- Reverse remaining → correct rest
*/