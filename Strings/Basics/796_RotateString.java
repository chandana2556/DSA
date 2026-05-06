// Problem: LeetCode 796 - Rotate String
// Description: Return true if and only if s can become goal after some number of shifts.

/*
Edge Cases:
- Different lengths
- Empty strings
- Same strings
- Single character
- Repeated characters
*/

/* =======================
   Approach 1: Generate All Rotations
   ======================= */

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        // try every possible rotation
        for(int k = 0; k < s.length(); k++){
            String rotated = s.substring(k) + s.substring(0, k);

            if(goal.equals(rotated)){
                return true;
            }
        }

        return false;
    }
}

/*
Explanation:
- Generate every possible rotation of s
- Compare each rotation with goal
- If any matches → return true

Time Complexity: O(n²)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: Concatenation Trick (Optimal)
   ======================= */

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        String doubled = s + s;

        return doubled.contains(goal);
    }
}

/*
Explanation:
- Any rotation of s will always be present inside (s + s)

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 3: Manual Circular Matching
   ======================= */

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        for(int k = 0; k < s.length(); k++){
            boolean match = true;

            for(int j = 0; j < s.length(); j++){

                // circular comparison
                if(s.charAt((k + j) % s.length()) != goal.charAt(j)){
                    match = false;
                    break;
                }
            }

            if(match) return true;
        }

        return false;
    }
}

/*
Explanation:
- Try every starting position k
- Compare characters circularly using modulo
- If all characters match → valid rotation

Time Complexity: O(n²)
Space Complexity: O(1)
*/