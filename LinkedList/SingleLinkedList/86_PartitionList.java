// Problem: LeetCode 86 - Partition List
// Description:
// Given the head of a linked list and an integer x,
// partition the list such that all nodes with values
// less than x come before nodes with values
// greater than or equal to x.
//
// The relative order of nodes in each partition
// should remain the same.

/*
Edge Cases:
- Empty list
- Single node
- All nodes less than x
- All nodes greater than or equal to x
- Duplicate values
*/


import java.util.*;


/* =======================
   Approach 1: Extra Lists
   ======================= */

class Solution {

    public ListNode partition(ListNode head, int x) {

        // Store values into two lists
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        ListNode current = head;

        while(current != null){

            if(current.val < x){

                less.add(current.val);
            }

            else{

                greater.add(current.val);
            }

            current = current.next;
        }

        // Build new linked list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(int val : less){

            tail.next = new ListNode(val);

            tail = tail.next;
        }

        for(int val : greater){

            tail.next = new ListNode(val);

            tail = tail.next;
        }

        return dummy.next;
    }
}

/*
Explanation:

Separate values into two lists.

less:
values < x

greater:
values >= x

Then create a new linked list.

Example:

1 -> 4 -> 3 -> 2 -> 5 -> 2
x = 3

less:
1 2 2

greater:
4 3 5

Result:

1 -> 2 -> 2 -> 4 -> 3 -> 5

Time Complexity: O(n)

Space Complexity: O(n)
*/


/* =======================
   Approach 2: Two Linked Lists (Optimal)
   ======================= */

class Solution {

    public ListNode partition(ListNode head, int x) {

        // Dummy heads
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        ListNode lessTail = lessHead;
        ListNode greaterTail = greaterHead;

        ListNode current = head;

        // Partition nodes
        while(current != null){

            if(current.val < x){

                lessTail.next = current;
                lessTail = lessTail.next;
            }

            else{

                greaterTail.next = current;
                greaterTail = greaterTail.next;
            }

            current = current.next;
        }

        // Join both lists
        lessTail.next = greaterHead.next;

        // Prevent cycle
        greaterTail.next = null;

        return lessHead.next;
    }
}

/*
Explanation:

Create two linked lists.

List 1:
Nodes with value < x

List 2:
Nodes with value >= x

Finally connect both lists.

Example:

Input:

1 -> 4 -> 3 -> 2 -> 5 -> 2

x = 3

--------------------------------

Less List:

1 -> 2 -> 2

--------------------------------

Greater List:

4 -> 3 -> 5

--------------------------------

Join:

1 -> 2 -> 2 -> 4 -> 3 -> 5

Notice:
Relative order is preserved.

--------------------------------

Why set:

greaterTail.next = null ?

Because original nodes still point to their
old next nodes.

Without this line,
the final linked list may contain a cycle
or unwanted nodes.

Time Complexity: O(n)

Space Complexity: O(1)
(excluding dummy nodes)
*/