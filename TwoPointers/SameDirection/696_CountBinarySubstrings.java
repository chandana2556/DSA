// Problem: LeetCode 696 - Count Binary Substrings
// Description:
// Count the number of non-empty substrings that contain
// the same number of consecutive 0's and 1's,
// where all 0's and all 1's are grouped consecutively.

/*
Edge Cases:
- Empty string
- Single character
- All same characters
- Alternating characters
- Large grouped sequences
*/


import java.util.*;


/* =======================
   Approach 1: Generate All Substrings (Brute Force)
   ======================= */

class Solution {

    public int countBinarySubstrings(String s) {

        int count = 0;

        int n = s.length();

        // generate all substrings
        for(int i = 0; i < n; i++){

            // only even lengths possible
            for(int len = 2;
                i + len <= n;
                len += 2){

                int half = len / 2;

                char firstChar = s.charAt(i);

                char secondChar =
                    (firstChar == '0') ? '1' : '0';

                boolean valid = true;

                // check first half
                for(int k = i;
                    k < i + half;
                    k++){

                    if(s.charAt(k) != firstChar){

                        valid = false;
                        break;
                    }
                }

                // check second half
                if(valid){

                    for(int k = i + half;
                        k < i + len;
                        k++){

                        if(s.charAt(k) != secondChar){

                            valid = false;
                            break;
                        }
                    }
                }

                // valid substring found
                if(valid){
                    count++;
                }
            }
        }

        return count;
    }
}

/*
Explanation:
- Generate every possible substring
- Valid substring must:
    contain equal consecutive groups
    like:
    "0011"
    "01"
    "1100"

- Check:
    first half all same
    second half all opposite

Time Complexity: O(n³)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Group Sizes
   ======================= */

class Solution {

    public int countBinarySubstrings(String s) {

        List<Integer> groups =
            new ArrayList<>();

        int i = 0;

        int n = s.length();

        // build consecutive groups
        while(i < n){

            char ch = s.charAt(i);

            int groupSize = 0;

            while(i < n &&
                  s.charAt(i) == ch){

                groupSize++;
                i++;
            }

            groups.add(groupSize);
        }

        int count = 0;

        // adjacent groups form valid substrings
        for(int j = 0;
            j < groups.size() - 1;
            j++){

            count += Math.min(
                groups.get(j),
                groups.get(j + 1)
            );
        }

        return count;
    }
}

/*
Explanation:
- Store sizes of consecutive groups

Example:
s = "00110011"

Groups:
[2,2,2,2]

Valid substrings between groups:
min(2,2) + min(2,2) + min(2,2)
= 6

Why min?
- Smaller group limits number of valid pairs

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 3: Constant Space (Optimal)
   ======================= */

class Solution {

    public int countBinarySubstrings(String s) {

        int prevGroupSize = 0;

        int currGroupSize = 1;

        int count = 0;

        for(int i = 1; i < s.length(); i++){

            // same character group
            if(s.charAt(i) == s.charAt(i - 1)){

                currGroupSize++;
            }

            // new group starts
            else{

                prevGroupSize = currGroupSize;

                currGroupSize = 1;
            }

            // valid substring possible
            if(prevGroupSize >= currGroupSize){

                count++;
            }
        }

        return count;
    }
}

/*
Explanation:
- Track only:
    previous group size
    current group size

- Valid substring exists when:
    previous group >= current group

Example:
s = "00110"

Groups:
00 → size 2
11 → size 2
0  → size 1

As current group grows:
count increases while
prevGroupSize >= currGroupSize

Time Complexity: O(n)
Space Complexity: O(1)
*/