// Problem: Queue Implementation Using Array (Circular Queue)
// Description:
// Implement a Queue using an array.
//
// Queue follows FIFO (First In First Out).
//
// Operations:
// 1. Enqueue
// 2. Dequeue

/*
Edge Cases:
- Enqueue into a full queue
- Dequeue from an empty queue
- Single element
- Queue becomes empty after dequeue
- Circular wrap-around
*/

class ArrayQueue {

    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    public ArrayQueue(int capacity) {

        this.capacity = capacity;

        arr = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    // Insert element
    public void enqueue(int x) {

        if(size == capacity){

            throw new RuntimeException("Queue full");
        }

        rear = (rear + 1) % capacity;

        arr[rear] = x;

        size++;
    }

    // Remove element
    public int dequeue() {

        if(size == 0){

            throw new RuntimeException("Queue empty");
        }

        int value = arr[front];

        front = (front + 1) % capacity;

        size--;

        return value;
    }
}