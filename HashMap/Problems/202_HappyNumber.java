/*
============================================================
Problem: LeetCode 202 - Happy Number

Description:
A happy number is a number that eventually becomes 1 when
repeatedly replaced by the sum of the squares of its digits.

If the process continues forever in a cycle and never
reaches 1, the number is not a happy number.

Concept:
For every digit:
    digit = n % 10
    sum = sum + digit * digit
    n = n / 10

Repeat the process using the calculated sum.

Example:
Input:
n = 19

Process:
1² + 9² = 82
8² + 2² = 68
6² + 8² = 100
1² + 0² + 0² = 1

Output:
true
============================================================
*/


/*
============================================================
Approach 1: Repeated Digit-Square Calculation

- Calculate the sum of the squares of the digits.
- Replace n with the calculated sum.
- Repeat until n becomes 1.
- If n becomes 1, return true.

Limitation:
This approach can enter an infinite loop for an unhappy
number because it does not detect repeated values.

Time Complexity: O(log n) per digit-square calculation
Space Complexity: O(1)

Note:
There is no guaranteed finite overall time complexity for
this implementation because it can loop forever.
============================================================
*/

class Solution {
    public boolean isHappy(int n) {
        while (n != 1) {
            int sum = 0;

            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }

            n = sum;
        }

        return true;
    }
}


/*
============================================================
Approach 2: HashSet - Cycle Detection

- Store every number encountered in a HashSet.
- Calculate the sum of the squares of its digits.
- If n becomes 1, the number is happy.
- If n appears again in the set, a cycle exists.
- Return true only if n becomes 1.

Time Complexity: O(log n) per digit-square calculation
Space Complexity: O(log n) for the set in the usual
                  complexity analysis of this problem
============================================================
*/

import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);

            int sum = 0;

            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }

            n = sum;
        }

        return n == 1;
    }
}