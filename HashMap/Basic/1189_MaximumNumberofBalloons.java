// Problem: LeetCode 1189 - Maximum Number of Balloons
// Description:
// Return the maximum number of instances of the word "balloon"
// that can be formed using the characters in the string.

/*
Edge Cases:
- Empty string
- Missing required characters
- Multiple repeated characters
- Extra irrelevant characters
- 'l' and 'o' needed twice
*/


import java.util.*;


/* =======================
   Approach 1: Frequency Array (Optimal)
   ======================= */

class Solution {
    public int maxNumberOfBalloons(String text) {

        int[] count = new int[26];

        // count frequency of characters
        for(char c : text.toCharArray()){
            count[c - 'a']++;
        }

        // calculate possible balloons
        int result = count['b' - 'a'];

        result = Math.min(result, count['a' - 'a']);
        result = Math.min(result, count['l' - 'a'] / 2);
        result = Math.min(result, count['o' - 'a'] / 2);
        result = Math.min(result, count['n' - 'a']);

        return result;
    }
}

/*
Explanation:
- Count frequency of all characters
- "balloon" requires:
    b → 1
    a → 1
    l → 2
    o → 2
    n → 1

- Number of balloons depends on minimum possible supply

Example:
text = "loonbalxballpoon"

b = 2
a = 2
l = 4 → 4/2 = 2
o = 4 → 4/2 = 2
n = 2

Answer = 2

Time Complexity: O(n)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: HashMap
   ======================= */

class Solution {
    public int maxNumberOfBalloons(String text) {

        Map<Character, Integer> textCount = new HashMap<>();

        // count frequency in text
        for(char c : text.toCharArray()){
            textCount.put(c, textCount.getOrDefault(c, 0) + 1);
        }

        String target = "balloon";

        Map<Character, Integer> targetCount = new HashMap<>();

        // count required frequency
        for(char c : target.toCharArray()){
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int result = Integer.MAX_VALUE;

        // calculate minimum possible balloons
        for(Map.Entry<Character, Integer> entry : targetCount.entrySet()){

            int supply = textCount.getOrDefault(entry.getKey(), 0);

            int demand = entry.getValue();

            result = Math.min(result, supply / demand);
        }

        return result;
    }
}

/*
Explanation:
- Count characters in text
- Count required characters in "balloon"
- For each character:
    possible = supply / demand
- Minimum value gives final answer

Time Complexity: O(n)
Space Complexity: O(1)
(Because only fixed alphabet size is used)
*/