// Problem: LeetCode 28 - Find the Index of the First Occurrence in a String (strStr)
// Description: Return the index of the first occurrence of "needle" in "haystack".
// If needle is not found, return -1.

/*
Edge Cases:
- needle is empty → return 0
- needle length > haystack length → return -1
- both strings are same
- repeated characters
*/


/* =======================
   Approach 1: Brute Force (Naive)
   ======================= */

class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();

        // Try every possible starting index
        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            // Compare characters one by one
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // If all characters matched
            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}

/*
Explanation:
- We try every starting index i in haystack.
- For each i, we compare characters of needle with haystack.
- If all characters match → return i.
- If mismatch → move to next index.

Time Complexity: O(n * m)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: KMP (Optimal - Concept Only)
   ======================= */

/*
Explanation (Simple Understanding):

- Brute force restarts comparison after mismatch → waste of work.
- KMP avoids this by using previous match information.

- It uses LPS array (Longest Prefix which is also Suffix).

Key Idea:
- When mismatch happens, instead of starting from 0,
  jump to a position using LPS.

Why faster?
- We never move backward in haystack.
- Each character is processed only once.

Time Complexity: O(n + m)
Space Complexity: O(m)

NOTE:
 - I'll do it later
*/