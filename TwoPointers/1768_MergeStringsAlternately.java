// Problem: LeetCode 1768 - Merge Strings Alternately
// Description:
// Merge two strings by adding letters in alternating order.
// If one string is longer, append the remaining characters at the end.

/*
Edge Cases:
- One string empty
- Both strings empty
- Same length strings
- Different length strings
- Single character strings
*/


/* =======================
   Approach 1: While Loops
   ======================= */

class Solution {

    public String mergeAlternately(String word1, String word2) {

        StringBuilder result = new StringBuilder();

        int i = 0;

        // merge alternately while both strings have characters
        while(i < word1.length() &&
              i < word2.length()){

            result.append(word1.charAt(i));
            result.append(word2.charAt(i));

            i++;
        }

        // append remaining characters of word1
        while(i < word1.length()){

            result.append(word1.charAt(i));

            i++;
        }

        // append remaining characters of word2
        while(i < word2.length()){

            result.append(word2.charAt(i));

            i++;
        }

        return result.toString();
    }
}

/*
Explanation:
- Add characters alternately from both strings
- After one string ends:
    append remaining characters of longer string

Example:
word1 = "abc"
word2 = "pqrstu"

Result:
"apbqcrstu"

Time Complexity: O(n + m)
Space Complexity: O(n + m)
*/


/* =======================
   Approach 2: Single Loop
   ======================= */

class Solution {

    public String mergeAlternately(String word1, String word2) {

        StringBuilder result = new StringBuilder();

        int maxLen =
            Math.max(word1.length(), word2.length());

        for(int i = 0; i < maxLen; i++){

            // append from word1 if available
            if(i < word1.length()){

                result.append(word1.charAt(i));
            }

            // append from word2 if available
            if(i < word2.length()){

                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }
}

/*
Explanation:
- Traverse up to maximum length
- Add characters from both strings whenever valid

Example:
word1 = "ab"
word2 = "pqrs"

i=0 → a + p
i=1 → b + q
i=2 → r
i=3 → s

Result:
"apbqrs"

Time Complexity: O(n + m)
Space Complexity: O(n + m)
*/