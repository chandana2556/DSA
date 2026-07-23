// Problem: Queue Using Java Collection Framework (JCF)
// Description:
// Java provides a built-in Queue interface.
//
// LinkedList is one of the classes
// that implements the Queue interface.
//
// Common Operations:
// 1. offer() - Insert element
// 2. poll() - Remove front element
// 3. peek() - View front element

import java.util.*;

class Main {

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(10);

        q.offer(20);

        q.offer(30);

        System.out.println(q.poll());

        System.out.println(q.peek());
    }
}