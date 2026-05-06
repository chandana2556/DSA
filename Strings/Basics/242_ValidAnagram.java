// Problem: LeetCode 242 - Valid Anagram
// Description: Check whether two strings are anagrams of each other.

/*
Edge Cases:
- Different lengths
- Empty strings
- Same strings
- Repeated characters
*/


/* =======================
   Approach 1: Sorting
   ======================= */

class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths differ, cannot be anagrams
        if (s.length() != t.length()) return false;

        // Convert strings to character arrays
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        // Sort both arrays
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        // Compare sorted arrays
        return Arrays.equals(sChars, tChars);
    }
}

/*
Explanation:
- Convert both strings into character arrays.
- Sort both arrays.
- If sorted arrays are equal → strings are anagrams.

Time Complexity: O(n log n)
- Sorting takes O(n log n)

Space Complexity: O(n)
- Character arrays used
*/


/* =======================
   Approach 2: Frequency Array
   ======================= */

class Solution {
    public boolean isAnagram(String s, String t) {

        // Different lengths → not anagrams
        if (s.length() != t.length()) return false;

        // Frequency array for a-z
        int[] count = new int[26];

        // Increment for s and decrement for t
        for (int i = 0; i < s.length(); i++) {

            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check whether all values are 0
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}

/*
Explanation:
- Count frequencies of characters in s.
- Simultaneously decrease frequencies using t.
- If both strings are anagrams:
    all counts become 0.

Time Complexity: O(n)
Space Complexity: O(1)
*/


/* =======================
   Approach 3: Frequency Array with Early Exit (Optimal)
   ======================= */

class Solution {
    public boolean isAnagram(String s, String t) {

        // Different lengths → impossible
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        // Count characters of s
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Decrease counts using t
        for (int i = 0; i < t.length(); i++) {

            count[t.charAt(i) - 'a']--;

            // Negative means mismatch
            if (count[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}

/*
Explanation:
- Store frequencies of characters from s.
- Remove frequencies using t.
- If any count becomes negative:
    → t has extra character
    → not an anagram.

Why better?
- Stops immediately when mismatch found.
- No need to check entire frequency array.


Time Complexity: O(n)
Space Complexity: O(1)
*/

