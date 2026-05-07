// Problem: LeetCode 392 - Is Subsequence
// Description: Return true if string s is a subsequence of string t.
// A subsequence is formed by deleting some characters without changing the order.

/*
Edge Cases:
- s is empty
- t is empty
- Both strings empty
- s longer than t
- All characters match
- Characters not present
*/

/* =======================
   Approach: Two Pointers (Brute Force)
   ======================= */

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while(i < s.length() && j < t.length()){

            // character match
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }

            j++;
        }

        return i == s.length();
    }
}

/*
Explanation:
- Use two pointers:
    i → traverses s
    j → traverses t

- If characters match, move i forward
- Always move j forward
- If i reaches end of s, all characters matched in order

Time Complexity: O(n + m)
Space Complexity: O(1)
*/

/*
Approach 2: Binary Search with preprocessing
Approach 3: Dynamic Programming 
*/