// Problem: LeetCode 14 - Longest Common Prefix
// Description: Find the longest common prefix string among an array of strings.
// If there is no common prefix, return "".

/*
Edge Cases:
- Empty array
- Single string
- No common prefix
- One string is prefix of another
- All strings same
*/


/* =======================
   Approach 1: Vertical Scanning
   ======================= */

class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) return "";

        // check character by character
        for(int i = 0; i < strs[0].length(); i++){

            char c = strs[0].charAt(i);

            // compare with all other strings
            for(int j = 1; j < strs.length; j++){

                // string ended OR mismatch found
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }

        // entire first string is common
        return strs[0];
    }
}

/*
Explanation:
- Take first string as reference
- Compare characters column by column
- Stop when mismatch occurs

Time Complexity: O(n * m)
Space Complexity: O(1)

Where:
n = number of strings
m = length of shortest string
*/


/* =======================
   Approach 2: Sorting
   ======================= */

class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) return "";

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;

        // compare first and last strings
        while(i < first.length() &&
              i < last.length() &&
              first.charAt(i) == last.charAt(i)){

            i++;
        }

        return first.substring(0, i);
    }
}

/*
Explanation:
- After sorting:
    most different strings become first and last
- Common prefix of first & last =
  common prefix of entire array

Time Complexity: O(n log n + m)
Space Complexity: O(1)
*/


/* =======================
   Approach 3: Divide & Conquer
   ======================= */

class Solution {

    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) return "";

        return findLCP(strs, 0, strs.length - 1);
    }

    private String findLCP(String[] strs, int left, int right){

        // base case
        if(left == right){
            return strs[left];
        }

        int mid = left + (right - left) / 2;

        // solve left half
        String lcpLeft = findLCP(strs, left, mid);

        // solve right half
        String lcpRight = findLCP(strs, mid + 1, right);

        // merge result
        return commonPrefix(lcpLeft, lcpRight);
    }

    private String commonPrefix(String s1, String s2){

        int minLen = Math.min(s1.length(), s2.length());

        for(int i = 0; i < minLen; i++){

            // mismatch found
            if(s1.charAt(i) != s2.charAt(i)){
                return s1.substring(0, i);
            }
        }

        return s1.substring(0, minLen);
    }
}

/*
Explanation:
- Divide array into halves recursively
- Find LCP for each half
- Merge both prefixes

Time Complexity: O(S)
Space Complexity: O(log n)

Where:
S = total characters in all strings
*/