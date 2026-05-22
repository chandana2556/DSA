// Problem: LeetCode 443 - String Compression
// Description:
// Compress the array of characters in-place.
// For repeated characters:
//    write character followed by count.
// Return the new length after compression.

/*
Edge Cases:
- Single character
- No repeating characters
- All characters same
- Multi-digit counts
- Empty array
*/


import java.util.*;


/* =======================
   Approach 1: Extra List
   ======================= */

class Solution {

    public int compress(char[] chars) {

        List<Character> result =
            new ArrayList<>();

        int i = 0;

        while(i < chars.length){

            char currentChar = chars[i];

            int count = 0;

            // count consecutive characters
            while(i < chars.length &&
                  chars[i] == currentChar){

                count++;
                i++;
            }

            // add character
            result.add(currentChar);

            // add count if > 1
            if(count > 1){

                for(char c :
                    String.valueOf(count)
                          .toCharArray()){

                    result.add(c);
                }
            }
        }

        // copy back into original array
        for(int j = 0;
            j < result.size();
            j++){

            chars[j] = result.get(j);
        }

        return result.size();
    }
}

/*
Explanation:
- Count consecutive characters
- Store:
    character + frequency

Example:
chars = ['a','a','b','b','c','c','c']

Compressed:
['a','2','b','2','c','3']

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: In-Place Two Pointers (Optimal)
   ======================= */

class Solution {

    public int compress(char[] chars) {

        int write = 0;

        int read = 0;

        while(read < chars.length){

            char currentChar = chars[read];

            int count = 0;

            // count consecutive characters
            while(read < chars.length &&
                  chars[read] == currentChar){

                read++;
                count++;
            }

            // write character
            chars[write++] = currentChar;

            // write count if > 1
            if(count > 1){

                String countstr =
                    String.valueOf(count);

                for(char c :
                    countstr.toCharArray()){

                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}

/*
Explanation:
- read pointer:
    scans groups of characters

- write pointer:
    writes compressed result in-place

Example:
chars = ['a','a','a','b']

Read:
a → count 3
write:
a3

Read:
b → count 1
write:
b

Final:
['a','3','b']

Why convert count to string?
- Multi-digit counts:
    12 → '1','2'

Time Complexity: O(n)
Space Complexity: O(1)
*/