// Problem: LeetCode 1854 - Maximum Population Year
// Description:
// Each log = [birth, death]
// A person is alive from birth year
// up to death year - 1.
//
// Return the earliest year with the maximum population.

/*
Edge Cases:
- Single person
- Multiple people born same year
- Multiple people die same year
- Population peak occurs multiple times
- Return earliest year with max population
*/


import java.util.*;


/* =======================
   Approach 1: Check Every Year (Brute Force)
   ======================= */

class Solution {

    public int maximumPopulation(int[][] logs) {

        int maxPop = 0;

        int resultYear = 0;

        // check every year
        for(int year = 1950;
            year <= 2050;
            year++){

            int count = 0;

            for(int[] log : logs){

                // person alive during this year
                if(log[0] <= year &&
                   year < log[1]){

                    count++;
                }
            }

            if(count > maxPop){

                maxPop = count;

                resultYear = year;
            }
        }

        return resultYear;
    }
}

/*
Explanation:
- For each year:
    count how many people are alive

Alive condition:
birth <= year < death

Example:
logs = [[1993,1999],[2000,2010]]

1993-1998:
population = 1

2000-2009:
population = 1

Answer = 1993
(earliest maximum year)

Time Complexity: O(101 * n)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Line Sweep / Difference Array (Optimal)
   ======================= */

class Solution {

    public int maximumPopulation(int[][] logs) {

        int[] years = new int[101];

        for(int[] log : logs){

            // birth increases population
            years[log[0] - 1950]++;

            // death decreases population
            years[log[1] - 1950]--;
        }

        int maxPop = 0;

        int currentPop = 0;

        int resultYear = 1950;

        for(int i = 0; i < 101; i++){

            currentPop += years[i];

            if(currentPop > maxPop){

                maxPop = currentPop;

                resultYear = i + 1950;
            }
        }

        return resultYear;
    }
}

/*
Explanation:

Line Sweep Idea:
- Don't count population for every year separately
- Record only population changes

Birth:
+1

Death:
-1

Example:
logs = [[1950,1961]]

years[0]  += 1
years[11] -= 1

Difference Array:

Year:
1950 1951 1952 ... 1960 1961

Diff:
 +1   0    0  ...  0   -1

Now take running sum:

1950 -> 1
1951 -> 1
1952 -> 1
...
1960 -> 1
1961 -> 0

Population is automatically computed.

Why:
currentPop += years[i]

converts difference array
into actual population counts.

Time Complexity: O(n + 101)
Space Complexity: O(101)
≈ O(1)
*/