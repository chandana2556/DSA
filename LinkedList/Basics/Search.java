/*
 * Topic: Search an Element in a Singly Linked List
 *
 * Description:
 * Search for a target value in a linked list.
 * Return true if the value is found, otherwise false.
 *
 * Linked List:
 * 10 -> 20 -> 30 -> 40 -> 50 -> null
 *
 * Target:
 * 30
 *
 * Output:
 * true
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class ListNode {
    int val;
    ListNode next;

    // Constructor
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Main {

    // Function to search for a target value
    public static boolean search(ListNode head, int target) {

        ListNode current = head;

        while (current != null) {

            if (current.val == target) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public static void main(String[] args) {

        // Create nodes
        ListNode n1 = new ListNode(10);
        ListNode n2 = new ListNode(20);
        ListNode n3 = new ListNode(30);
        ListNode n4 = new ListNode(40);
        ListNode n5 = new ListNode(50);

        // Connect nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // Head of the linked list
        ListNode head = n1;

        int target = 30;

        boolean found = search(head, target);

        System.out.println(found);
    }
}