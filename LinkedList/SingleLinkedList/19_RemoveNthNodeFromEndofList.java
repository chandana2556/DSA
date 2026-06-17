// Problem: LeetCode 19 - Remove Nth Node From End of List
// Description:
// Given the head of a linked list,
// remove the nth node from the end of the list
// and return the head.

/*
Edge Cases:
- Single node list
- Remove head node
- Remove last node
- Remove middle node
- n equals list length
*/


/* =======================
   Approach 1: Length Count
   ======================= */

class Solution {

    public ListNode removeNthFromEnd(ListNode head,
                                     int n) {

        int length = 0;

        ListNode curr = head;

        // find length
        while(curr != null){

            length++;

            curr = curr.next;
        }

        int k = length - n;

        // remove head
        if(k == 0){

            return head.next;
        }

        curr = head;

        // move to previous node
        for(int i = 1; i < k; i++){

            curr = curr.next;
        }

        // delete node
        curr.next = curr.next.next;

        return head;
    }
}

/*
Explanation:
- Find total length
- Convert:
    nth node from end
    → kth node from beginning

Formula:

k = length - n

Move to node before target
and delete it.

Example:
1 -> 2 -> 3 -> 4 -> 5
n = 2

length = 5

k = 5 - 2 = 3

Delete node after 3

Result:
1 -> 2 -> 3 -> 5

Time Complexity: O(n)
Space Complexity: O(1)
*/


/* =======================
   Approach 2: Fast & Slow Pointers (Optimal)
   ======================= */

class Solution {

    public ListNode removeNthFromEnd(ListNode head,
                                     int n) {

        ListNode dummy =
            new ListNode(0, head);

        ListNode slow = dummy;

        ListNode fast = dummy;

        // create gap of n+1
        for(int i = 0; i <= n; i++){

            fast = fast.next;
        }

        // move together
        while(fast != null){

            slow = slow.next;

            fast = fast.next;
        }

        // delete target node
        slow.next = slow.next.next;

        return dummy.next;
    }
}

/*
Explanation:
- Use dummy node to handle
  head deletion easily

- Move fast pointer
  n+1 steps ahead

Gap:

slow ----- fast

(distance = n+1)

- Move both together
- When fast reaches null:

slow will be exactly before
the node to delete

Example:
1 -> 2 -> 3 -> 4 -> 5
n = 2

After gap creation:

dummy -> 1 -> 2 -> 3 -> 4 -> 5
slow
                 fast

Move both:

When fast = null

slow points to 3

Delete:
4

Result:
1 -> 2 -> 3 -> 5

Time Complexity: O(n)
Space Complexity: O(1)
*/