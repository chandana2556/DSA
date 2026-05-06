// Problem: LeetCode 680 - Valid Palindrome II
// Description: Return true if the string can become a palindrome
// after deleting at most one character.

/*
Edge Cases:
- Empty string
- Single character
- Already palindrome
- String needing one deletion
- String impossible to convert into palindrome
*/


/* =======================
   Approach 1: Brute Force
   ======================= */

class Solution {
    public boolean validPalindrome(String s) {

        // Try removing each character one by one
        for (int i = 0; i < s.length(); i++) {

            // Build string without character at index i
            String modified = s.substring(0, i) + s.substring(i + 1);

            // Check if modified string is palindrome
            if (isPalindrome(modified)) {
                return true;
            }
        }

        return false;
    }

    // Helper function to check palindrome
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

/*
Explanation:
- Traverse every index of the string.
- Remove one character at a time.
- Check whether the remaining string is palindrome.
- If any modified string is palindrome → return true.
- Otherwise return false.

Time Complexity: O(n²)
- Loop runs n times
- Palindrome check takes O(n)

Space Complexity: O(n)
- New string created every iteration
*/


/* =======================
   Approach 2: Two Pointers (Optimal)
   ======================= */

class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Mismatch found
            if (s.charAt(left) != s.charAt(right)) {

                // Try skipping either left or right character
                return isPalindrome(s, left + 1, right) ||
                       isPalindrome(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    // Check palindrome within given range
    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

/*
Explanation:
- Use two pointers from both ends.
- If characters match → move inward.
- If mismatch occurs:
    1. Skip left character
    2. Skip right character
- If either remaining substring is palindrome → return true.

Why do we check both?
- We do not know which character is causing the mismatch.
- So we try removing either one.

Time Complexity: O(n)
- Single traversal
- At most one extra palindrome check

Space Complexity: O(1)
- No extra space used
*/
