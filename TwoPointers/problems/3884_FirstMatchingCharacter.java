/*
============================================================
Problem: 3884 First Matching Index

Description:
Given a string s, compare characters from the beginning
and end of the string.

Return the first index i, starting from the left, where
s.charAt(i) == s.charAt(n - 1 - i).

If no matching pair is found, return -1.

Concept:
Use Two Pointers to compare characters from opposite ends.
If they match, return the left index.
Otherwise, move both pointers toward the center.

Example:

Input:
s = "abca"

Output:
0

Explanation:
s.charAt(0) = 'a'
s.charAt(3) = 'a'

Both characters match, so return index 0.
============================================================
*/


/*
============================================================
Approach 1: Two Pointers - While Loop

- Initialize left = 0 and right = n - 1.
- Compare the characters at both pointers.
- If they match, return left.
- Otherwise, move left forward and right backward.
- If no matching pair is found, return -1.

Time Complexity: O(n)
Space Complexity: O(1)
============================================================
*/

class Solution {
    public int firstMatchingIndex(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                return left;
            } else {
                left++;
                right--;
            }
        }

        return -1;
    }
}


/*
============================================================
Approach 2: For Loop

- Iterate from the beginning to the middle of the string.
- Compare s.charAt(i) with s.charAt(n - 1 - i).
- Return i if the characters match.
- If no matching pair is found, return -1.

Time Complexity: O(n)
Space Complexity: O(1)
============================================================
*/

class Solution {
    public int firstMatchingIndex(String s) {
        int n = s.length();

        for (int i = 0; i <= (n - 1) / 2; i++) {
            if (s.charAt(i) == s.charAt(n - 1 - i)) {
                return i;
            }
        }

        return -1;
    }
}


/*
============================================================
Approach 3: Recursion

- Pass the left and right indices to a recursive function.
- If left > right, return -1 because no matching pair exists.
- If both characters match, return left.
- Otherwise, recursively check the next pair by moving
  left forward and right backward.

Time Complexity: O(n)
Space Complexity: O(n) due to the recursion call stack
============================================================
*/

class Solution {
    public int firstMatchingIndex(String s) {
        return findMatch(s, 0, s.length() - 1);
    }

    private int findMatch(String s, int left, int right) {
        if (left > right) {
            return -1;
        }

        if (s.charAt(left) == s.charAt(right)) {
            return left;
        }

        return findMatch(s, left + 1, right - 1);
    }
}