// Problem: LeetCode 344 - Reverse String
// Description: Reverse the given character array in-place.

/*
Edge Cases:
- Empty array
- Single character
- All characters same
*/

/* =======================
   Approach 1: Extra Array (Brute Force)
   ======================= */

class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        char[] reversed = new char[n];

        // fill reversed array
        for(int i = 0; i < n; i++){
            reversed[i] = s[n - 1 - i];
        }

        // copy back to original array
        for(int i = 0; i < n; i++){
            s[i] = reversed[i];
        }
    }
}

/*
Explanation:
- Create a new array and fill it with elements in reverse order.
- Copy the reversed array back into the original array.

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: Two Pointers (Optimal)
   ======================= */

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

/*
Explanation:
- Use two pointers (left and right).
- Swap elements while moving pointers toward each other.
- Works in-place.

Time Complexity: O(n)
Space Complexity: O(1)
*/


/* =======================
   Approach 3: Recursion
   ======================= */

class Solution {
    public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int left, int right){
        if(left >= right){
            return;
        }

        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        reverse(s, left + 1, right - 1);
    }
}

/*
Explanation:
- Recursively swap elements from both ends.
- Base case: when left >= right.

Time Complexity: O(n)
Space Complexity: O(n) (due to recursion stack)
*/