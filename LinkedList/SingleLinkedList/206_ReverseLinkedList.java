// Problem: LeetCode 206 - Reverse Linked List
// Description:
// Reverse a singly linked list and return the new head.

/*
Edge Cases:
- Empty list
- Single node
- Two nodes
- Multiple nodes
- Already reversed list
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode reverseList(ListNode head) {

        // Previous node
        ListNode prev = null;

        // Current node
        ListNode curr = head;

        while(curr != null){

            // Save next node
            ListNode next = curr.next;

            // Reverse link
            curr.next = prev;

            // Move pointers
            prev = curr;
            curr = next;
        }

        // New head
        return prev;
    }
}
/*
Explanation:

Original:
1 -> 2 -> 3 -> 4 -> null

Iteration 1:
1 -> null

Iteration 2:
2 -> 1 -> null

Iteration 3:
3 -> 2 -> 1 -> null

Iteration 4:
4 -> 3 -> 2 -> 1 -> null

Key Steps:
1. Save next node
2. Reverse current pointer
3. Move prev forward
4. Move curr forward

Time Complexity: O(n)
Space Complexity: O(1)
*/
// Approach 2: Recursive
class Solution {

    public ListNode reverseList(ListNode head) {

        // Base Case
        if(head == null || head.next == null){
            return head;
        }

        // Reverse remaining list
        ListNode newHead = reverseList(head.next);

        // Reverse current connection
        head.next.next = head;

        // Remove old connection
        head.next = null;

        return newHead;
    }
}

/*
Explanation:

Original:
1 -> 2 -> 3 -> 4 -> null

Recursive Calls:
reverse(1)
    ↓
reverse(2)
    ↓
reverse(3)
    ↓
reverse(4)

Base Case:
4 becomes new head

While Returning:

4 -> 3

4 -> 3 -> 2

4 -> 3 -> 2 -> 1

Key Idea:
- Reverse everything after current node
- Make next node point back to current node
- Break old forward connection

Time Complexity: O(n)
Space Complexity: O(n)

Reason:
Recursive call stack stores n function calls
*/