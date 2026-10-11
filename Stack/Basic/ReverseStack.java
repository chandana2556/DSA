/*
============================================================
Problem: Reverse a Stack

Description:
Given a stack of integers, reverse the order of its elements.

The top element should become the bottom element, and the
bottom element should become the top element.

Concept:
Stack follows LIFO (Last In, First Out).

Reversing a stack means changing the order of its elements
so that popping them produces the reverse order.

Example:

Input Stack (Bottom -> Top):
[10, 20, 30, 40]

Output Stack (Bottom -> Top):
[40, 30, 20, 10]
============================================================
*/


/*
============================================================
Approach 1: Using an Auxiliary Stack

- Create an empty temporary stack.
- Pop each element from the original stack.
- Push each popped element into the temporary stack.
- Return the temporary stack.

Since elements are popped in reverse order and pushed into
another stack, the order of elements gets reversed.

Time Complexity: O(n)
Space Complexity: O(n)
============================================================
*/

import java.util.Stack;

public class Main {

    public static Stack<Integer> reverseStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        return temp;
    }
}


/*
============================================================
Approach 2: Using Stack Indexing and an Auxiliary Stack

- Create a stack named reversed.
- Copy elements from the original stack using get(i).
- Create another stack named result.
- Pop elements from reversed and push them into result.
- Return result.

Note:
This approach uses indexed access and two additional stacks.
It is less efficient than Approach 1.

Time Complexity: O(n)
Space Complexity: O(n)
============================================================
*/

import java.util.Stack;

public class Main {

    static Stack<Integer> reverseStack(Stack<Integer> stack) {
        Stack<Integer> reversed = new Stack<>();

        for (int i = 0; i < stack.size(); i++) {
            reversed.push(stack.get(i));
        }

        Stack<Integer> result = new Stack<>();

        while (!reversed.isEmpty()) {
            result.push(reversed.pop());
        }

        return result;
    }
}