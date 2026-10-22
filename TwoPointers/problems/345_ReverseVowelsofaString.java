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

Concept: Two Pointers

- Convert the string into a character array.
- Initialize two pointers:
      i = 0
      j = arr.length - 1
- Move i forward until a vowel is found.
- Move j backward until a vowel is found.
- Swap the vowels at both positions.
- Move both pointers inward and repeat.
- Convert the character array back into a string.

Example:

Input:
s = "hello"

Output:
"holle"

Explanation:
The vowels 'e' and 'o' are swapped.

============================================================
Approach: Two Pointers

Time Complexity: O(n)
Space Complexity: O(n)

The character array requires O(n) space.
============================================================
*/

class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            while (i < j && !isVowel(arr[i]))
                i++;

            while (i < j && !isVowel(arr[j]))
                j--;

            if (i < j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return new String(arr);
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}