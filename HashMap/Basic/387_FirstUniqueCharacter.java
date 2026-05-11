// Problem: LeetCode 387 - First Unique Character in a String
// Description:
// Return the index of the first non-repeating character.
// If no unique character exists, return -1.

/*
Edge Cases:
- Empty string
- All repeating characters
- Single character
- Unique character at beginning/end
- Multiple duplicates
*/


import java.util.*;


/* =======================
   Approach 1: Nested Loops (Brute Force)
   ======================= */

class Solution {

    public int firstUniqChar(String s) {

        for(int i = 0; i < s.length(); i++){

            boolean unique = true;

            for(int j = 0; j < s.length(); j++){

                if(i != j && s.charAt(i) == s.charAt(j)){
                    unique = false;
                    break;
                }
            }

            // first unique character found
            if(unique){
                return i;
            }
        }

        return -1;
    }
}

/*
Explanation:
- Compare every character with all other characters
- If no duplicate exists → return index

Time Complexity: O(n²)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Frequency Array
   ======================= */

class Solution {

    public int firstUniqChar(String s) {

        int[] count = new int[26];

        // count frequency
        for(int i = 0; i < s.length(); i++){

            count[s.charAt(i) - 'a']++;
        }

        // find first unique character
        for(int i = 0; i < s.length(); i++){

            if(count[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}

/*
Explanation:
- Count frequency of each character
- Traverse string again
- First character with frequency 1 is answer

Time Complexity: O(n)
Space Complexity: O(1)
*/


/* =======================
   Approach 3: Frequency Array (Readable Version)
   ======================= */

class Solution {

    public int firstUniqChar(String s) {

        int[] freq = new int[26];

        // count frequency
        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);

            freq[c - 'a']++;
        }

        // check first unique character
        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);

            if(freq[c - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }
}

/*
Explanation:
- Same logic as previous approach
- Uses character variable for readability

Time Complexity: O(n)
Space Complexity: O(1)
*/


/* =======================
   Approach 4: Frequency + indexOf()
   ======================= */

class Solution {

    public int firstUniqChar(String s) {

        int[] count = new int[26];

        // count frequency
        for(int i = 0; i < s.length(); i++){

            count[s.charAt(i) - 'a']++;
        }

        int result = s.length();

        // check characters with frequency 1
        for(int c = 0; c < 26; c++){

            if(count[c] == 1){

                int idx = s.indexOf((char)('a' + c));

                result = Math.min(result, idx);
            }
        }

        return result == s.length() ? -1 : result;
    }
}

/*
Explanation:
- Count character frequencies
- For every unique character:
    find its first index using indexOf()
- Return smallest index

Time Complexity: O(n)
Space Complexity: O(1)
*/