// Problem: LeetCode 1732 - Find the Highest Altitude
// Description:
// A biker starts at altitude 0.
// gain[i] represents the net gain/loss in altitude
// between point i and i+1.
//
// Return the highest altitude reached.

/*
Edge Cases:
- All gains positive
- All gains negative
- Contains zeros
- Highest altitude is starting altitude (0)
- Single element array
*/


import java.util.*;


/* =======================
   Approach 1: Brute Force
   ======================= */

class Solution {

    public int largestAltitude(int[] gain) {

        int max = 0;

        for(int i = 0; i < gain.length; i++){

            int altitude = 0;

            // calculate altitude at index i
            for(int j = 0; j <= i; j++){

                altitude += gain[j];
            }

            max = Math.max(max, altitude);
        }

        return max;
    }
}

/*
Explanation:
- Start at altitude 0
- For every position:
    calculate altitude from scratch
- Keep track of maximum altitude

Example:
gain = [-5,1,5,0,-7]

Altitudes:
0
-5
-4
1
1
-6

Maximum = 1

Time Complexity: O(n²)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Prefix Sum Array
   ======================= */

class Solution {

    public int largestAltitude(int[] gain) {

        int[] prefixSum =
            new int[gain.length];

        prefixSum[0] = gain[0];

        int max =
            Math.max(0, prefixSum[0]);

        for(int i = 1; i < gain.length; i++){

            prefixSum[i] =
                prefixSum[i - 1] + gain[i];

            max =
                Math.max(max, prefixSum[i]);
        }

        return max;
    }
}

/*
Explanation:
- Altitude at each point is simply
  the running sum of gains.

Example:
gain = [-5,1,5,0,-7]

Prefix Sum:
[-5,-4,1,1,-6]

Altitudes:
0,-5,-4,1,1,-6

Highest Altitude = 1

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 3: Running Prefix Sum (Optimal)
   ======================= */

class Solution {

    public int largestAltitude(int[] gain) {

        int altitude = 0;

        int maxAltitude = 0;

        for(int g : gain){

            altitude += g;

            maxAltitude =
                Math.max(maxAltitude,
                         altitude);
        }

        return maxAltitude;
    }
}

/*
Explanation:
- No need to store entire prefix array
- Maintain current altitude directly
- Update maximum altitude while traversing

Example:
gain = [-5,1,5,0,-7]

Start:
altitude = 0

After -5:
altitude = -5

After 1:
altitude = -4

After 5:
altitude = 1

After 0:
altitude = 1

After -7:
altitude = -6

Maximum = 1

Time Complexity: O(n)
Space Complexity: O(1)
*/