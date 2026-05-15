// Problem: LeetCode 408 - Valid Word Abbreviation
// Description:
// Return true if abbr is a valid abbreviation of word.

/*
Edge Cases:
- Empty strings
- Leading zero in abbreviation
- Abbreviation longer than word
- Full numeric abbreviation
- Exact same strings
- Multiple digit numbers
*/


import java.util.*;


/* =======================
   Approach 1: Expand Abbreviation
   ======================= */

class Solution {

    public boolean validWordAbbreviation(String word, String abbr) {

        // expanded abbreviation
        List<Character> expanded = new ArrayList<>();

        int j = 0;

        while(j < abbr.length()){

            char c = abbr.charAt(j);

            // normal character
            if(Character.isLetter(c)){

                expanded.add(c);

                j++;
            }

            else{

                // leading zero invalid
                if(c == '0'){
                    return false;
                }

                // build full number
                int num = 0;

                while(j < abbr.length() &&
                      Character.isDigit(abbr.charAt(j))){

                    num = num * 10 +
                          (abbr.charAt(j) - '0');

                    j++;
                }

                // add wildcard placeholders
                for(int k = 0; k < num; k++){

                    expanded.add('*');
                }
            }
        }

        // lengths must match
        if(expanded.size() != word.length()){
            return false;
        }

        // compare characters
        for(int i = 0; i < word.length(); i++){

            if(expanded.get(i) != '*' &&
               expanded.get(i) != word.charAt(i)){

                return false;
            }
        }

        return true;
    }
}

/*
Explanation:
- Expand abbreviation completely
- Numbers represent skipped characters
- '*' acts as wildcard
- Compare expanded abbreviation with word

Example:
word = "internationalization"
abbr = "i12iz4n"

Expanded:
i************iz****n

Matches word → true

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: Two Pointers (Optimal)
   ======================= */

class Solution {

    public boolean validWordAbbreviation(String word,
                                         String abbr) {

        int i = 0;
        int j = 0;

        while(i < word.length() &&
              j < abbr.length()){

            // direct character match
            if(word.charAt(i) == abbr.charAt(j)){

                i++;
                j++;
            }

            // abbreviation contains number
            else if(Character.isDigit(abbr.charAt(j))){

                // leading zero invalid
                if(abbr.charAt(j) == '0'){
                    return false;
                }

                int num = 0;

                // build number
                while(j < abbr.length() &&
                      Character.isDigit(abbr.charAt(j))){

                    num = num * 10 +
                          (abbr.charAt(j) - '0');

                    j++;
                }

                // skip characters in word
                i = i + num;
            }

            else{
                return false;
            }
        }

        return i == word.length() &&
               j == abbr.length();
    }
}

/*
Explanation:
- Use two pointers:
    i → word
    j → abbreviation

- If characters match:
    move both pointers

- If abbreviation contains number:
    skip that many characters in word

- Leading zero is invalid

Example:
word = "apple"
abbr = "a2e"

a matches a
2 → skip "pp"
compare l with e → mismatch

Answer = false

Time Complexity: O(n)
Space Complexity: O(1)
*/