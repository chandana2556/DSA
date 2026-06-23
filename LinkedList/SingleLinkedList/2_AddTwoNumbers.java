// Problem: LeetCode 2 - Add Two Numbers
// Description:
// Two non-empty linked lists represent two non-negative integers.
// Digits are stored in reverse order.
// Add the two numbers and return the sum as a linked list.

/*
Edge Cases:
- Different length lists
- Carry generated at last digit
- One list becomes null earlier
- Both lists contain 0
- Multiple consecutive carries
*/


/* =======================
   Approach 1: Iterative (Optimal)
   ======================= */

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;

        while(l1 != null || l2 != null){

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;

            int digit = sum % 10;
            carry = sum / 10;

            tail.next = new ListNode(digit);
            tail = tail.next;

            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }
        }

        if(carry > 0){
            tail.next = new ListNode(carry);
        }

        return dummy.next;
    }
}

/*
Explanation:

Each node stores one digit.

Example:

l1 = 2 -> 4 -> 3
l2 = 5 -> 6 -> 4

Represents:

342 + 465

--------------------------------

2 + 5 = 7

Result:
7

--------------------------------

4 + 6 = 10

Digit = 0
Carry = 1

Result:
7 -> 0

--------------------------------

3 + 4 + 1 = 8

Result:
7 -> 0 -> 8

Represents:

807

Answer:
342 + 465 = 807

Time Complexity: O(max(m,n))
Space Complexity: O(1)
(excluding output list)
*/


/* =======================
   Approach 2: Recursion
   ======================= */

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addWithCarry(l1,l2,0);
    }

    private ListNode addWithCarry(ListNode l1,ListNode l2,int carry) {

        if(l1 == null && l2 == null && carry == 0){
            return null;
        }

        int sum = carry;

        if(l1 != null){
            sum += l1.val;
        }

        if(l2 != null){
            sum += l2.val;
        }

        ListNode node = new ListNode(sum % 10);

        node.next = addWithCarry(
            l1 != null ? l1.next : null,
            l2 != null ? l2.next : null,
            sum / 10
        );

        return node;
    }
}

/*
Explanation:

Same logic as iterative solution.

Instead of loop,
each recursive call processes one digit.

Example:

l1 = 2 -> 4 -> 3
l2 = 5 -> 6 -> 4

Call 1:
2 + 5 = 7

Create:
7

--------------------------------

Call 2:
4 + 6 = 10

Create:
0

Carry = 1

--------------------------------

Call 3:
3 + 4 + 1 = 8

Create:
8

--------------------------------

Result:

7 -> 0 -> 8

Time Complexity: O(max(m,n))

Space Complexity: O(max(m,n))
(Recursion Stack)
*/