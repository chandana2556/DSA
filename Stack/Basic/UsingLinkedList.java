# Stack Using Linked List (Java)

## What is a Stack?

A Stack is a linear data structure that follows the **LIFO (Last In, First Out)** principle.

- The last element inserted is the first element removed.
- In a linked list implementation, the **head** of the linked list represents the **Top** of the stack.
- All insertion and deletion operations are performed at the **head** of the linked list.

------------------------------------------------------------

## Why Use Linked List?

Unlike arrays, a linked list does not have a fixed size.

Advantages:
• Dynamic memory allocation.
• No Stack Overflow due to fixed capacity (unless memory is exhausted).
• Push and Pop operations are performed in O(1) time.

------------------------------------------------------------

## Time Complexity

Push      → O(1)
Pop       → O(1)
Peek      → O(1)
isEmpty() → O(1)

------------------------------------------------------------

## Structure

class Node{
    int value;
    Node next;

    Node(int value){
        this.value = value;
    }
}

Explanation:

• value → Stores the data.
• next → Stores the address of the next node.
• Node(int value) → Constructor used to create a new node with the given value.

------------------------------------------------------------

## Variables Used

Node head;

Explanation:

• head always points to the Top of the stack.
• If head is null, the stack is empty.

------------------------------------------------------------

## Push Operation

Code:

void push(int value){
    Node node = new Node(value);
    node.next = head;
    head = node;
}

Explanation:

The push operation inserts a new node at the **head** of the linked list because the head represents the Top of the stack.

Step 1:

Node node = new Node(value);

• Create a new node.
• Store the given value inside the node.

Step 2:

node.next = head;

• Connect the new node to the current head.
• The new node points to the previous Top of the stack.

Step 3:

head = node;

• Move the head pointer to the newly created node.
• The new head becomes the Top of the stack.

------------------------------------------------------------

## Pop Operation

Code:

int pop(){
    if(head == null){
        System.out.println("Stack is Underflow");
        return -1;
    }

    int value = head.value;
    head = head.next;
    return value;
}

Explanation:

The pop operation removes the Top element from the stack.

Step 1:

if(head == null)

• Check whether the stack is empty.
• If head is null, there are no elements to remove.
• This condition is called **Stack Underflow**.

Step 2:

int value = head.value;

• Before removing the node, store its value.
• Otherwise, after removing it, the value will be lost.

Step 3:

head = head.next;

• Move the head pointer to the next node.
• The current Top node is removed.
• The next node becomes the new Top of the stack.

Step 4:

return value;

• Return the removed value.
• The value that was removed from the stack is returned.

------------------------------------------------------------

## Peek Operation

Code:

int peek(){
    if(head == null){
        return -1;
    }

    return head.value;
}

Explanation:

• peek() returns the Top element of the stack without removing it.
• If the stack is empty, it returns -1.
• The head node always represents the Top element.

------------------------------------------------------------

## isEmpty() Operation

Code:

boolean isEmpty(){
    return head == null;
}

Explanation:

• Checks whether the stack contains any elements.

Returns:

true  → Stack is empty.

false → Stack contains elements.

------------------------------------------------------------

## Sample Program

LinkedListStack stack = new LinkedListStack();

stack.push(10);
stack.push(20);
stack.push(30);
stack.push(40);
stack.push(50);

System.out.println(stack.peek());

System.out.println(stack.pop());

System.out.println(stack.peek());

System.out.println(stack.isEmpty());

Output:

50
50
40
false

------------------------------------------------------------

## Advantages

• Dynamic size (no fixed capacity).
• No Stack Overflow due to fixed array size.
• Push and Pop operations take O(1) time.
• Efficient memory utilization.

------------------------------------------------------------

## Disadvantages

• Extra memory is required to store the next pointer.
• Slightly more memory is used compared to arrays.
• Random access is not possible.