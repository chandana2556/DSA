// Problem: LeetCode 125 - Valid Palindrome
// Description: Check if a string is a palindrome considering only alphanumeric characters and ignoring cases.

/*
Edge Cases:
- Empty string → true
- String with only symbols → true
- Single character → true
- Mixed case letters
*/


/* =======================
   Approach 1: StringBuilder (Brute Force)
   ======================= */

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();

        // Build cleaned string
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        // Compare with reverse
        String forward = cleaned.toString();
        String backward = cleaned.reverse().toString();

        return forward.equals(backward);
    }
}

/*
Explanation:
- Remove all non-alphanumeric characters.
- Convert everything to lowercase.
- Create a cleaned string.
- Reverse the string and compare with original.
- If both are equal → palindrome.

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: Two Pointers (Optimal)
   ======================= */

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip invalid characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip invalid characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters
            if (Character.toLowerCase(s.charAt(left)) != 
                Character.toLowerCase(s.charAt(right))) {
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
- Use two pointers (left, right).
- Move left forward and right backward.
- Skip non-alphanumeric characters.
- Compare characters after converting to lowercase.
- If mismatch → not palindrome.
- If all match → palindrome.

Time Complexity: O(n)
Space Complexity: O(1)
*/


/* =======================
   Why do we use (left < right) in inner loops?
   ======================= */

/*
- Prevents accessing invalid indices (out of bounds).
- Ensures pointers do not cross while skipping characters.
- Avoids unnecessary comparisons once pointers meet.

Example:
s = "!!!"

Without (left < right):
- left keeps increasing → goes out of bounds → runtime error ❌

With (left < right):
- loop stops safely when pointers meet → no error ✅

Conclusion:
- (left < right) acts as a safety condition.
*/