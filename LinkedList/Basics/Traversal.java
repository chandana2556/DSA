/*
 * Topic: Singly Linked List - Traversal
 *
 * Description:
 * Create a linked list with 5 nodes and traverse
 * the linked list using a while loop.
 *
 * Linked List:
 * 10 -> 20 -> 30 -> 40 -> 50 -> null
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Node {
    int data;
    Node next;

    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {

        // Step 1: Create nodes
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);

        // Step 2: Connect nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // Step 3: Set head node
        Node head = n1;

        // Step 4: Traverse and print the linked list
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}