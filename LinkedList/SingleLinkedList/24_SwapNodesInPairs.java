class Solution {
    public ListNode swapPairs(ListNode head) {
        // Base case: fewer than 2 nodes, nothing to swap
        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        // Recursively swap the rest of the list
        first.next = swapPairs(second.next);
        second.next = first;

        // second is now the head of this swapped pair
        return second;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        while(prev.next!=null && prev.next.next!=null){
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            prev.next=second;
            first.next=second.next;
            second.next=first;
            
            prev = first;
        }
        return dummy.next;
    }
}