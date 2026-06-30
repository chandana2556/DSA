# Stack Using Arrays (Java)

## What is a Stack?

A Stack is a linear data structure that follows the **LIFO (Last In, First Out)** principle.

- The last element inserted is the first element removed.
- Insertion and deletion are performed only at one end called the **Top**.

Example:

Push: 10 → 20 → 30

Stack:
| 30 | ← Top
| 20 |
| 10 |

Pop → 30 is removed first.

------------------------------------------------------------

## Ways to Implement a Stack

1. Using Arrays
2. Using Linked List
3. Using Java Collections Framework (Stack/Deque)

This implementation uses **Arrays**.

------------------------------------------------------------

## Time Complexity

Push      → O(1)
Pop       → O(1)
Peek      → O(1)
isEmpty() → O(1)

------------------------------------------------------------

## Variables Used

int[] stack;
int top;
int capacity;

Explanation:

stack[]   → Stores all stack elements.
top       → Stores the index of the top element.
capacity  → Maximum number of elements the stack can store.

Initially,

top = -1;

This indicates that the stack is empty.

------------------------------------------------------------

## Constructor

ArrayStack(int size){
    stack = new int[size];
    top = -1;
    capacity = size;
}

Purpose:

• Creates an array of the given size.
• Initializes top to -1.
• Stores the maximum capacity of the stack.

------------------------------------------------------------

## Push Operation

void push(int value){
    if(top == capacity - 1){
        System.out.println("Stack is Overflow");
        return;
    }

    top++;
    stack[top] = value;
}

Explanation:

Before inserting an element, check whether the stack is full.

Condition:

top == capacity - 1

If this condition is true, the stack is full.

This condition is called **Stack Overflow** because no more elements can be inserted.

Otherwise,

1. Increment top.
2. Insert the value at stack[top].

------------------------------------------------------------

## Pop Operation

int pop(){
    if(top == -1){
        System.out.println("Stack is Underflow");
        return -1;
    }

    return stack[top--];
}

Explanation:

Before removing an element, check whether the stack is empty.

Condition:

top == -1

If this condition is true, there are no elements to remove.

This condition is called **Stack Underflow**.

Otherwise,

1. Return the top element.
2. Decrement top.

------------------------------------------------------------

## Peek Operation

int peek(){
    if(top == -1){
        System.out.println("Stack is Empty");
        return -1;
    }

    return stack[top];
}

Explanation:

peek() returns the top element without removing it from the stack.

If the stack is empty, it returns -1.

------------------------------------------------------------

## isEmpty() Operation

boolean isEmpty(){
    return top == -1;
}

Explanation:

Checks whether the stack contains any elements.

Returns:

true  → Stack is empty.
false → Stack contains elements.

------------------------------------------------------------

## Sample Program

ArrayStack stack = new ArrayStack(5);

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.peek());

System.out.println(stack.pop());

System.out.println(stack.peek());

System.out.println(stack.isEmpty());

Output:

30
30
20
false

------------------------------------------------------------

## Advantages

• Simple to implement.
• Push and Pop operations take O(1) time.
• Fast memory access because arrays store elements in contiguous memory.

------------------------------------------------------------

## Disadvantages

• Fixed size.
• Stack Overflow occurs when the array becomes full.
• Memory size cannot increase dynamically.

------------------------------------------------------------

## Complete Source Code

class ArrayStack{
    int[] stack;
    int top;
    int capacity;

    ArrayStack(int size){
        stack = new int[size];
        top = -1;
        capacity = size;
    }

    void push(int value){
        if(top == capacity - 1){
            System.out.println("Stack is Overflow");
            return;
        }

        stack[++top] = value;
    }

    int pop(){
        if(top == -1){
            System.out.println("Stack is Underflow");
            return -1;
        }

        return stack[top--];
    }

    int peek(){
        if(top == -1){
            System.out.println("Stack is Empty");
            return -1;
        }

        return stack[top];
    }

    boolean isEmpty(){
        return top == -1;
    }
}

public class Main{

    public static void main(String[] args){

        ArrayStack stack = new ArrayStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}