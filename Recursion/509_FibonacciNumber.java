/*
============================================================
Problem: LeetCode 509 - Fibonacci Number
============================================================

Description:
Given an integer n, return the nth Fibonacci number.

Fibonacci sequence:
F(0) = 0
F(1) = 1
F(n) = F(n-1) + F(n-2)

Example:
Input:  n = 5
Output: 5

Fibonacci sequence:
0, 1, 1, 2, 3, 5
*/


/*
============================================================
Approach 1: Iterative
============================================================

We maintain only the previous two Fibonacci numbers
using variables a and b.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int fib(int n) {

        int a = 0;
        int b = 1;

        for(int i = 0; i < n; i++){

            int c = a + b;
            a = b;
            b = c;
        }

        return a;
    }
}


/*
============================================================
Approach 2: Dynamic Programming (Tabulation)
============================================================

We use an array to store all previously calculated
Fibonacci values.

This avoids recalculating values and builds the answer
from smaller subproblems.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public int fib(int n) {

        int[] f = new int[n + 1];

        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        else {

            f[0] = 0;
            f[1] = 1;

            for(int i = 2; i <= n; i++){

                f[i] = f[i - 1] + f[i - 2];
            }
        }

        return f[n];
    }
}


/*
============================================================
Execution Example
============================================================

Input:
n = 5

f[0] = 0
f[1] = 1
f[2] = 1
f[3] = 2
f[4] = 3
f[5] = 5

Output:
5


============================================================
Approach Comparison
============================================================

Iterative:
Time Complexity  : O(n)
Space Complexity : O(1)

Dynamic Programming:
Time Complexity  : O(n)
Space Complexity : O(n)

The Iterative approach is more space efficient because
it only stores the previous two Fibonacci values.

The DP approach stores all Fibonacci values in an array.
*/