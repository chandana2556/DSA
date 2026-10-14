/*
============================================================
Problem: LeetCode 2000 - Reverse Prefix of Word

Description:
Given a string word and a character ch, find the first
occurrence of ch in word.

Reverse the prefix of word from index 0 to the index of ch,
including ch itself.

If ch does not exist in word, return the original word.

Concept:
This problem uses Stack and StringBuilder.

- Find the first occurrence of ch.
- Push all characters from index 0 to that position
  into a stack.
- Pop the characters to reverse the prefix.
- Append the remaining characters without changing
  their order.

Example:

Input:
word = "abcdefd"
ch = 'd'

Output:
"dcbaefd"

Explanation:
The first occurrence of 'd' is at index 3.

Prefix = "abcd"
Reversed Prefix = "dcba"

Remaining String = "efd"

Final Result = "dcbaefd"
============================================================
*/


/*
============================================================
Approach: Using Stack

- Find the first occurrence of ch.
- If ch is not found, return word.
- Push the prefix characters into the stack.
- Pop and append them to StringBuilder.
- Append the remaining characters.
- Return the final string.

Time Complexity: O(n)
Space Complexity: O(n)
============================================================
*/

import java.util.Stack;

class Solution {
    public String reversePrefix(String word, char ch) {

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int var = -1;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                var = i;
                break;
            }
        }

        if (var == -1) {
            return word;
        }

        for (int i = 0; i <= var; i++) {
            st.push(word.charAt(i));
        }

        while (!st.isEmpty()) {
            char c = st.pop();
            sb.append(c);
        }

        for (int i = var + 1; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }

        return sb.toString();
    }
}