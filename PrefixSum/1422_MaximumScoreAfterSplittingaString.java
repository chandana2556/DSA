/*
============================================================
Problem: LeetCode 1422 - Maximum Score After Splitting a String

Description:
Given a binary string s, split it into two non-empty
substrings, left and right.

Calculate the score for each split:
    Score = Number of 0s in left + Number of 1s in right

Return the maximum possible score.

Concept:
This problem can be solved using String Manipulation,
Prefix Sum, and Running Count.

Example:
Input:
s = "00111"

Output:
5

Explanation:
Split: "00" | "111"

Zeros in left  = 2
Ones in right  = 3

Score = 2 + 3 = 5

============================================================
*/


/*
============================================================
Approach 1: Brute Force

- Try every possible split position.
- Create left and right substrings.
- Count zeros in the left substring.
- Count ones in the right substring.
- Calculate the score and update maxScore.

Time Complexity: O(n²)
Space Complexity: O(n)
============================================================
*/

class Solution {
    public int maxScore(String s) {

        int maxScore = 0;

        for (int i = 1; i < s.length(); i++) {

            String left = s.substring(0, i);
            String right = s.substring(i);

            int countLeft = 0;
            int countRight = 0;

            for (int j = 0; j < left.length(); j++) {
                if (left.charAt(j) == '0') {
                    countLeft++;
                }
            }

            for (int j = 0; j < right.length(); j++) {
                if (right.charAt(j) == '1') {
                    countRight++;
                }
            }

            int score = countLeft + countRight;
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}


/*
============================================================
Approach 2: Prefix Sum Arrays

Concept:
Store the number of zeros from the beginning and the number
of ones from the end.

- zeroPrefix[i] stores zeros in s[0...i].
- oneSuffix[i] stores ones in s[i...n-1].
- Try every valid split and calculate the score.

Time Complexity: O(n)
Space Complexity: O(n)
============================================================
*/

class Solution {
    public int maxScore(String s) {

        int n = s.length();

        int[] zeroPrefix = new int[n];
        int[] oneSuffix = new int[n];

        zeroPrefix[0] = s.charAt(0) == '0' ? 1 : 0;

        for (int i = 1; i < n; i++) {
            zeroPrefix[i] = zeroPrefix[i - 1];

            if (s.charAt(i) == '0') {
                zeroPrefix[i]++;
            }
        }

        oneSuffix[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            oneSuffix[i] = oneSuffix[i + 1];

            if (s.charAt(i) == '1') {
                oneSuffix[i]++;
            }
        }

        int maxScore = 0;

        for (int i = 0; i < n - 1; i++) {
            int score = zeroPrefix[i] + oneSuffix[i + 1];
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}


/*
============================================================
Approach 3: Running Count - Optimal

Concept:
- First count all the ones in the string.
- Initially, all ones belong to the right substring.
- Move the split from left to right.
- If the current character is '0', increment countLeft.
- If it is '1', decrement countRight.
- Calculate the score at each valid split and update
  maxScore.

We do not need substring creation or extra arrays.

Time Complexity: O(n)
Space Complexity: O(1)
============================================================
*/

class Solution {
    public int maxScore(String s) {

        int countLeft = 0;
        int countRight = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countRight++;
            }
        }

        int maxScore = 0;

        for (int i = 0; i < s.length() - 1; i++) {

            if (s.charAt(i) == '0') {
                countLeft++;
            } else {
                countRight--;
            }

            int score = countLeft + countRight;
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}