// Problem: LeetCode 58 - Length of Last Word
// Description: Return the length of the last word in the string.
// A word is defined as a sequence of non-space characters.

/*
Edge Cases:
- String with trailing spaces
- Single word
- Only spaces (if allowed)
- Multiple spaces between words
*/

/* =======================
   Approach 1: Split + Trim (Brute Force)
   ======================= */

class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split("\\s+");
        String lastWord = words[words.length - 1];
        return lastWord.length();
    }
}

/*
Explanation:
- Remove trailing spaces using trim()
- Split string into words
- Return length of last word

Time Complexity: O(n)
Space Complexity: O(n) (extra array for split)
*/


/* =======================
   Approach 2: Reverse Traversal (Optimal)
   ======================= */

class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        // skip trailing spaces
        while(i >= 0 && s.charAt(i) == ' '){
            i--;
        }

        int length = 0;

        // count last word length
        while(i >= 0 && s.charAt(i) != ' '){
            length++;
            i--;
        }

        return length;
    }
}

/*
Explanation:
- Start from end of string
- Skip trailing spaces
- Count characters until space appears

Time Complexity: O(n)
Space Complexity: O(1)
*/