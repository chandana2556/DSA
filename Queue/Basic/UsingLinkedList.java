// Problem: Queue Implementation Using Linked List
// Description:
// Implement a Queue using a Linked List.
//
// Queue follows FIFO (First In First Out).
//
// Operations:
// 1. Enqueue
// 2. Dequeue

/*
Edge Cases:
- Enqueue into an empty queue
- Dequeue from an empty queue
- Single element
- Queue becomes empty after dequeue
*/

class ListQueue {

    class Node {

        int val;
        Node next;

        Node(int val){

            this.val = val;
        }
    }

    Node head;
    Node tail;

    // Insert element
    public void enqueue(int x) {

        Node newNode = new Node(x);

        if(tail != null){

            tail.next = newNode;
        }

        tail = newNode;

        if(head == null){

            head = newNode;
        }
    }

    // Remove element
    public int dequeue() {

        if(head == null){

            throw new RuntimeException("Queue empty");
        }

        int value = head.val;

        head = head.next;

        if(head == null){

            tail = null;
        }

        return value;
    }
}