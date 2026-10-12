/*
============================================================
Problem: LeetCode 844 - Backspace String Compare

Description:
Given two strings s and t, compare them after applying
all backspace operations.

The character '#' represents a backspace:
- If a character appears before '#', remove that character.
- If the string is empty, ignore the backspace.
- Return true if both processed strings are equal;
  otherwise, return false.

Concept:
This problem uses the Stack data structure.

Stack follows LIFO (Last In, First Out).
When '#' appears, pop the most recently added character
if the stack is not empty.

Example:

Input:
s = "ab#c"
t = "ad#c"

Processed s = "ac"
Processed t = "ac"

Output:
true
============================================================
*/


/*
============================================================
Approach: Using Two Stacks

- Create two stacks, one for each string.
- Traverse each string character by character.
- If the character is '#', pop from the stack if it is
  not empty.
- Otherwise, push the character onto the stack.
- Compare both stacks and return the result.

Time Complexity: O(n + m)
Space Complexity: O(n + m)

Where:
n = length of s
m = length of t
============================================================
*/

import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!st1.isEmpty()) {
                    st1.pop();
                }
            } else {
                st1.push(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                if (!st2.isEmpty()) {
                    st2.pop();
                }
            } else {
                st2.push(ch);
            }
        }

        return st1.equals(st2);
    }
}