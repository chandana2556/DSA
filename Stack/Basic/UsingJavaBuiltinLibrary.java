# Stack Using Java Built-in Library

## What is a Built-in Stack?

Java provides built-in classes and interfaces to implement a Stack without creating it manually.

There are two common ways to implement a Stack in Java:

1. Stack Class (Legacy)
2. Deque Interface (Recommended)

------------------------------------------------------------

## 1. Stack Class (Legacy)

Code:

Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.peek());

System.out.println(stack.pop());

Explanation:

• Stack<Integer> creates a stack that stores Integer values.
• push() inserts an element at the Top of the stack.
• pop() removes and returns the Top element.
• peek() returns the Top element without removing it.
• isEmpty() checks whether the stack is empty.

Example:

Push: 10 → 20 → 30

Stack:

| 30 | ← Top
| 20 |
| 10 |

pop() removes 30.

------------------------------------------------------------

## Operations

push(value)

Purpose:

• Inserts an element at the Top of the stack.

Example:

stack.push(40);

------------------------------------------------------------

pop()

Purpose:

• Removes and returns the Top element.

Example:

int value = stack.pop();

------------------------------------------------------------

peek()

Purpose:

• Returns the Top element without removing it.

Example:

int top = stack.peek();

------------------------------------------------------------

isEmpty()

Purpose:

• Checks whether the stack is empty.

Example:

boolean empty = stack.isEmpty();

------------------------------------------------------------

## Time Complexity

Push      → O(1)
Pop       → O(1)
Peek      → O(1)
isEmpty() → O(1)

------------------------------------------------------------

## 2. Deque Interface (Recommended)

Code:

Deque<Integer> stack = new ArrayDeque<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.peek());

System.out.println(stack.pop());

Explanation:

• Deque stands for **Double Ended Queue**.
• ArrayDeque is the recommended implementation for Stack operations.
• It provides the same push(), pop(), and peek() methods.
• It is faster than the legacy Stack class because it is not synchronized.

------------------------------------------------------------

## Why is ArrayDeque Recommended?

• Better performance than Stack.
• Less overhead because it is not synchronized.
• Recommended by Java documentation for implementing stacks.
• Supports all standard stack operations.

------------------------------------------------------------

## Time Complexity

Push      → O(1)
Pop       → O(1)
Peek      → O(1)
isEmpty() → O(1)

------------------------------------------------------------

## Difference Between Stack and ArrayDeque

Stack (Legacy)

• Older class.
• Synchronized (thread-safe).
• Slightly slower.
• Still works but generally not recommended for new code.

ArrayDeque (Recommended)

• Modern implementation.
• Not synchronized.
• Faster performance.
• Recommended for most applications.

------------------------------------------------------------

## Summary

There are three ways to implement a Stack in Java:

1. Using Arrays
2. Using Linked List
3. Using Java Built-in Library

For built-in implementations:

• Use **Stack** if you are learning basic stack operations or working with older code.
• Use **ArrayDeque (Deque Interface)** for modern Java applications because it provides better performance and is the recommended approach.