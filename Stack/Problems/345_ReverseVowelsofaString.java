/*
============================================================
Problem: LeetCode 345 - Reverse Vowels of a String

Description:
Given a string s, reverse only the vowels in the string
and return the modified string.

Vowels:
a, e, i, o, u (both lowercase and uppercase)

All consonants and other characters must remain in their
original positions.

Concept: Stack

- Traverse the string and push every vowel into a stack.
- Convert the string into a character array.
- Traverse the character array again.
- Whenever a vowel is found, replace it with the top
  vowel from the stack using pop().
- Since a stack follows LIFO (Last In, First Out), the
  vowels are placed in reverse order.
- Return the modified character array as a string.

Example:

Input:
s = "hello"

Output:
"holle"

Explanation:
The vowels 'e' and 'o' are pushed into the stack.
Popping them reverses their order.

============================================================
Approach: Stack

Time Complexity: O(n)
Space Complexity: O(n)

The stack and character array require O(n) extra space.
============================================================
*/

import java.util.Stack;

class Solution {
    public String reverseVowels(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                st.push(s.charAt(i));
            }
        }

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                arr[i] = st.pop();
            }
        }

        return new String(arr);
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}