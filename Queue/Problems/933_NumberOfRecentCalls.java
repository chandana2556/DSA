// Problem: LeetCode 933 - Number of Recent Calls
// Description:
// You have a RecentCounter class.
// Every call to ping(t) adds a request at time t.
// Return the number of requests that have happened
// in the inclusive range [t - 3000, t].
// It is guaranteed that every call to ping()
// has a strictly increasing value of t.

/*
Edge Cases:
- First ping
- Exactly t - 3000
- Multiple pings in range
- Old pings outside range
- Consecutive increasing timestamps
*/

import java.util.*;


/* =======================
   Approach 1: Brute Force
   ======================= */

class RecentCounter {

    List<Integer> pings;

    public RecentCounter() {

        pings = new ArrayList<>();
    }

    public int ping(int t) {

        pings.add(t);

        int count = 0;

        for(int ping : pings){

            if(ping >= t - 3000){

                count++;
            }
        }

        return count;
    }
}

/*
Explanation:

Store every ping.

Whenever a new ping arrives,

scan the entire list and count
how many timestamps are inside

[t - 3000, t].

Input:

ping(1)

Output:

1

----------------------------

Input:

ping(100)
ping(3001)
ping(3002)

Outputs:

1
2
3

Time Complexity:

ping() → O(n)

Space Complexity:

O(n)
*/


/* =======================
   Approach 2: Queue (Optimal)
   ======================= */

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {

        queue = new LinkedList<>();
    }

    public int ping(int t) {

        queue.add(t);

        while(queue.peek() < t - 3000){

            queue.poll();
        }

        return queue.size();
    }
}

/*
Explanation:

The queue always stores only
valid timestamps.

When a new ping arrives,

1. Add it to the queue.

2. Remove every timestamp
that is smaller than

t - 3000.

The remaining elements are
exactly the recent requests.

Input:

ping(1)

Queue:

[1]

Output:

1

----------------------------

ping(100)

Queue:

[1,100]

Output:

2

----------------------------

ping(3001)

Queue:

[1,100,3001]

Output:

3

----------------------------

ping(3002)

Valid Range:

[2,3002]

Remove:

1

Queue:

[100,3001,3002]

Output:

3

Time Complexity:

Each element is added once
and removed once.

Overall:

O(1) Amortized

Space Complexity:

O(n)
*/


/* =======================
   Approach 3: Binary Search
   ======================= */

class RecentCounter {

    List<Integer> pings;

    public RecentCounter() {

        pings = new ArrayList<>();
    }

    public int ping(int t) {

        pings.add(t);

        int left = 0;
        int right = pings.size() - 1;

        while(left < right){

            int mid = left + (right - left) / 2;

            if(pings.get(mid) < t - 3000){

                left = mid + 1;
            }
            else{

                right = mid;
            }
        }

        return pings.size() - left;
    }
}

/*
Explanation:

Since timestamps are always
added in increasing order,

the list is already sorted.

Use Binary Search to find

the first timestamp

>= (t - 3000)

Everything after that index
belongs to the valid range.

Answer

=

Total Size - First Valid Index

Input:

ping(1)
ping(100)
ping(3001)
ping(3002)

List:

[1,100,3001,3002]

For

t = 3002

Valid Range:

[2,3002]

Binary Search finds

100

(index = 1)

Answer

=

4 - 1

=

3

Time Complexity:

ping() → O(log n)

Space Complexity:

O(n)
*/