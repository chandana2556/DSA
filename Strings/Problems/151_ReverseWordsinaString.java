// Problem: LeetCode 151 - Reverse Words in a String
// Description:
// Given an input string s,
// reverse the order of the words.
//
// A word is defined as a sequence of
// non-space characters.
//
// Remove leading, trailing and extra
// spaces between words.

/*
Edge Cases:
- Empty string
- Leading spaces
- Trailing spaces
- Multiple spaces between words
- Single word
*/

import java.util.*;


/* =======================
   Approach 1: Split + Reverse
   ======================= */

class Solution {

    public String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");

        int left = 0;
        int right = words.length - 1;

        while(left < right){

            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            left++;
            right--;
        }

        return String.join(" ", words);
    }
}

/*
Explanation:

Step 1:

Remove leading and trailing spaces.

Step 2:

Split the string into words.

Step 3:

Reverse the words array.

Step 4:

Join the words using one space.

Input:

"the sky is blue"

Output:

"blue is sky the"

----------------------------

Input:

"  hello world  "

Output:

"world hello"

Time Complexity: O(n)

Space Complexity: O(n)
*/


/* =======================
   Approach 2: Traverse from End
   ======================= */

class Solution {

    public String reverseWords(String s) {

        StringBuilder result = new StringBuilder();

        int i = s.length() - 1;

        while(i >= 0){

            // Skip spaces
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }

            if(i < 0){
                break;
            }

            int end = i;

            // Find beginning of current word
            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }

            if(result.length() > 0){
                result.append(' ');
            }

            result.append(s, i + 1, end + 1);
        }

        return result.toString();
    }
}

/*
Explanation:

Start from the last character.

Skip spaces.

Find one complete word.

Append it to the answer.

Repeat until the beginning
of the string.

Input:

"the sky is blue"

Output:

"blue is sky the"

----------------------------

Input:

"a good   example"

Output:

"example good a"

Time Complexity: O(n)

Space Complexity: O(n)
*/


/* =======================
   Approach 3: Reverse Entire String (Optimal)
   ======================= */

class Solution {

    public String reverseWords(String s) {

        char[] chars = s.toCharArray();

        int n = chars.length;

        // Reverse complete string
        reverse(chars, 0, n - 1);

        int write = 0;

        for(int i = 0; i < n; i++){

            if(chars[i] != ' '){

                // Add single space between words
                if(write > 0){
                    chars[write++] = ' ';
                }

                int wordStart = write;

                // Copy current word
                while(i < n && chars[i] != ' '){

                    chars[write++] = chars[i++];
                }

                // Reverse copied word
                reverse(chars, wordStart, write - 1);
            }
        }

        return new String(chars, 0, write);
    }

    private void reverse(char[] chars, int left, int right){

        while(left < right){

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
    }
}

/*
Explanation:

Step 1:

Reverse the entire string.

Example:

Input:

"the sky is blue"

After reverse:

"eulb si yks eht"

--------------------------------

Step 2:

Copy every word while removing
extra spaces.

Current copied string:

"eulb si yks eht"

--------------------------------

Step 3:

Reverse each individual word.

Result:

"blue is sky the"

Input:

"the sky is blue"

Output:

"blue is sky the"

----------------------------

Input:

"  hello   world  "

Output:

"world hello"

Time Complexity: O(n)

Space Complexity: O(1)
(excluding output string)
*/