// Problem: LeetCode 881 - Boats to Save People
// Description:
// Each boat can carry at most 2 people
// with total weight at most limit.
// Return the minimum number of boats needed.

/*
Edge Cases:
- Single person
- All people same weight
- Nobody can pair
- Everyone can pair
- Maximum weight equals limit
*/


import java.util.*;


/* =======================
   Approach 1: Greedy Pair Search
   ======================= */

class Solution {

    public int numRescueBoats(int[] people,
                              int limit) {

        int n = people.length;

        boolean[] used = new boolean[n];

        int boats = 0;

        for(int i = 0; i < n; i++){

            // already assigned
            if(used[i]){
                continue;
            }

            used[i] = true;

            boats++;

            // try pairing with next valid person
            for(int j = i + 1; j < n; j++){

                if(!used[j] &&
                   people[i] + people[j] <= limit){

                    used[j] = true;

                    break;
                }
            }
        }

        return boats;
    }
}

/*
Explanation:
- Assign one person to a boat
- Search another unused person
  who can fit within limit

- If found:
    pair them

- Otherwise:
    person goes alone

Time Complexity: O(n²)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: Sorting + Two Pointers (Optimal)
   ======================= */

class Solution {

    public int numRescueBoats(int[] people,
                              int limit) {

        Arrays.sort(people);

        int light = 0;

        int heavy = people.length - 1;

        int boats = 0;

        while(light <= heavy){

            // lightest + heaviest can share
            if(people[light] +
               people[heavy] <= limit){

                light++;
            }

            // heaviest always gets a boat
            heavy--;

            boats++;
        }

        return boats;
    }
}

/*
Explanation:
- Sort people by weight
- Try pairing:
    lightest + heaviest

Why greedy works?
- Heaviest person must go anyway
- Best chance is pairing with lightest

Cases:
1. Pair possible:
    move both pointers

2. Pair not possible:
    heaviest goes alone

Example:
people = [1,2]
limit = 3

1 + 2 <= 3
→ one boat

Example:
people = [3,2,2,1]
limit = 3

Sorted:
[1,2,2,3]

1 + 3 > 3
→ 3 alone

1 + 2 <= 3
→ pair

2 alone

Total = 3 boats

Time Complexity: O(n log n)
Space Complexity: O(1)
(ignoring sorting space)
*/