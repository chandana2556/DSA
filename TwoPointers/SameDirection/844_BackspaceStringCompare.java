// Problem: LeetCode 844 - Backspace String Compare
// Description:
// Given two strings s and t containing '#' characters,
// return true if they are equal after processing backspaces.

/*
Edge Cases:
- Empty strings
- Only backspaces
- Consecutive backspaces
- More backspaces than characters
- Same final strings
*/


import java.util.*;


/* =======================
   Approach 1: Build Final Strings
   ======================= */

class Solution {

    public boolean backspaceCompare(String s,
                                    String t) {

        return buildString(s)
                .equals(buildString(t));
    }

    private String buildString(String str){

        StringBuilder stack =
            new StringBuilder();

        for(char c : str.toCharArray()){

            // backspace operation
            if(c == '#'){

                if(stack.length() != 0){

                    stack.deleteCharAt(
                        stack.length() - 1
                    );
                }
            }

            else{

                stack.append(c);
            }
        }

        return stack.toString();
    }
}

/*
Explanation:
- Simulate typing process
- '#' removes previous character
- Build final processed strings
- Compare both results

Example:
s = "ab#c"
t = "ad#c"

Processed:
"ac"
"ac"

Answer = true

Time Complexity: O(n + m)
Space Complexity: O(n + m)
*/


/* =======================
   Approach 2: Two Pointers (Optimal)
   ======================= */

class Solution {

    public boolean backspaceCompare(String s,
                                    String t) {

        int i = s.length() - 1;
        int j = t.length() - 1;

        int skipS = 0;
        int skipT = 0;

        while(i >= 0 || j >= 0){

            // find next valid character in s
            while(i >= 0){

                if(s.charAt(i) == '#'){

                    skipS++;
                    i--;
                }

                else if(skipS > 0){

                    skipS--;
                    i--;
                }

                else{
                    break;
                }
            }

            // find next valid character in t
            while(j >= 0){

                if(t.charAt(j) == '#'){

                    skipT++;
                    j--;
                }

                else if(skipT > 0){

                    skipT--;
                    j--;
                }

                else{
                    break;
                }
            }

            // compare valid characters
            if(i >= 0 && j >= 0){

                if(s.charAt(i) != t.charAt(j)){
                    return false;
                }
            }

            // one string ended earlier
            else if(i >= 0 || j >= 0){
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}

/*
Explanation:
- Traverse strings from end
- Track pending backspaces using skip counters
- Skip invalid characters
- Compare remaining valid characters directly

Example:
s = "ab##"
t = "c#d#"

Both become ""

Answer = true

Why reverse traversal?
- Backspace affects previous characters
- Easier to process backwards

Time Complexity: O(n + m)
Space Complexity: O(1)
*/