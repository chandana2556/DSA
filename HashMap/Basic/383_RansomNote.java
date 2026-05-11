// Problem: LeetCode 383 - Ransom Note
// Description:
// Return true if ransomNote can be constructed using letters from magazine.
// Each letter in magazine can only be used once.

/*
Edge Cases:
- Empty ransomNote
- Empty magazine
- Missing characters
- Insufficient frequency
- Repeated characters
*/


import java.util.*;


/* =======================
   Approach 1: StringBuilder Simulation
   ======================= */

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        StringBuilder sb = new StringBuilder(magazine);

        for(char c : ransomNote.toCharArray()){

            int index = sb.indexOf(String.valueOf(c));

            // character not found
            if(index == -1){
                return false;
            }

            // remove used character
            sb.deleteCharAt(index);
        }

        return true;
    }
}

/*
Explanation:
- Search each ransomNote character inside magazine
- Remove character once used
- If character not found → impossible

Time Complexity: O(n * m)
Space Complexity: O(m)

Where:
n = ransomNote length
m = magazine length
*/


/* =======================
   Approach 2: Sorting + Two Pointers
   ======================= */

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        char[] rArr = ransomNote.toCharArray();
        char[] mArr = magazine.toCharArray();

        Arrays.sort(rArr);
        Arrays.sort(mArr);

        int i = 0;
        int j = 0;

        while(i < rArr.length && j < mArr.length){

            if(rArr[i] == mArr[j]){
                i++;
                j++;
            }
            else if(rArr[i] > mArr[j]){
                j++;
            }
            else{
                return false;
            }
        }

        return i == rArr.length;
    }
}

/*
Explanation:
- Sort both strings
- Match characters using two pointers
- If all ransomNote characters matched → true

Time Complexity: O(n log n + m log m)
Space Complexity: O(n + m)
*/


/* =======================
   Approach 3: Two Frequency Arrays
   ======================= */

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // count ransomNote characters
        for(int i = 0; i < ransomNote.length(); i++){

            char c = ransomNote.charAt(i);

            freq1[c - 'a']++;
        }

        // count magazine characters
        for(int i = 0; i < magazine.length(); i++){

            char c = magazine.charAt(i);

            freq2[c - 'a']++;
        }

        // compare frequencies
        for(int i = 0; i < 26; i++){

            if(freq1[i] > freq2[i]){
                return false;
            }
        }

        return true;
    }
}

/*
Explanation:
- Store frequencies separately
- If ransomNote frequency exceeds magazine frequency → false

Time Complexity: O(n + m)
Space Complexity: O(1)
*/


/* =======================
   Approach 4: Single Frequency Array (Optimal)
   ======================= */

class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] count = new int[26];

        // count magazine characters
        for(char c : magazine.toCharArray()){

            count[c - 'a']++;
        }

        // consume characters for ransomNote
        for(char c : ransomNote.toCharArray()){

            count[c - 'a']--;

            // insufficient characters
            if(count[c - 'a'] < 0){
                return false;
            }
        }

        return true;
    }
}

/*
Explanation:
- Count magazine characters
- Reduce counts using ransomNote
- Negative count means required character unavailable

Example:
ransomNote = "aa"
magazine = "aab"

a = 2

use first a → 1
use second a → 0

All characters available → true

Time Complexity: O(n + m)
Space Complexity: O(1)
*/