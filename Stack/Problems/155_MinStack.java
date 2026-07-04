# LeetCode 155 - Min Stack

Design a stack that supports the following operations in constant time.

Requirements:

• push(int val) → Push the element onto the stack.
• pop() → Remove the top element.
• top() → Return the top element.
• getMin() → Return the minimum element in the stack.

All operations should be performed as efficiently as possible.

============================================================
APPROACH 1 (Brute Force - Using ArrayList)
============================================================

Approach:

• Store all elements in an ArrayList.
• push() inserts an element at the end of the list.
• pop() removes the last element.
• top() returns the last element.
• getMin() traverses the entire list to find the minimum element.
• Since getMin() scans every element, it is not an optimal solution.

Example:

Operations:

push(5)

push(3)

push(7)

getMin()

Output:

3

Time Complexity:

push()    → O(1)

pop()     → O(1)

top()     → O(1)

getMin()  → O(n)

Reason:
• getMin() traverses the entire list to find the minimum value.

Space Complexity:

O(n)

Reason:
• The ArrayList stores all the elements.

Edge Cases:

• Push only one element.
• Duplicate minimum values.
• Negative numbers.
• Calling getMin() after multiple pop operations.

Code:

class MinStack {
    List<Integer> stack;
    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int value) {
        stack.add(value);
    }

    public void pop() {
        stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        int mini = stack.get(0);
        for(int value : stack){
            mini = Math.min(mini, value);
        }
        return mini;
    }
}

============================================================
APPROACH 2 (Optimal - Using Two Stacks)
============================================================

Approach:

• Use one stack to store all the elements.
• Use another stack to store the minimum element corresponding to every position.
• During push(), insert the value into the main stack.
• If the new value is smaller than or equal to the current minimum, push it into the min stack.
• Otherwise, push the current minimum again into the min stack.
• During pop(), remove the top element from both stacks.
• top() returns the top element from the main stack.
• getMin() returns the top element of the min stack.
• Since the minimum value is always available at the top of the min stack, getMin() works in O(1).

Example:

Operations:

push(5)

push(3)

push(7)

push(2)

Main Stack:

5
3
7
2

Min Stack:

5
3
3
2

getMin()

Output:

2

Time Complexity:

push()    → O(1)

pop()     → O(1)

top()     → O(1)

getMin()  → O(1)

Reason:
• Every operation accesses only the top element of the stacks.

Space Complexity:

O(n)

Reason:
• Two stacks are maintained.

Edge Cases:

• Push only one element.
• Duplicate minimum values.
• Negative numbers.
• Calling getMin() after multiple pop operations.

Code:

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if(minStack.isEmpty() || value <= minStack.peek()){
            minStack.push(value);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

============================================================
APPROACH 3 (Optimal - Using One Stack)
============================================================

Approach:

• Use a single stack that stores an integer array of size two.
• Each array stores:
    [actualValue, minimumValueTillCurrentPosition]
• During push(), calculate the current minimum using the previous minimum stored in the stack.
• Push both the actual value and the current minimum as an array.
• pop() removes the top array.
• top() returns the first element of the array (actual value).
• getMin() returns the second element of the array (minimum value).
• Since every node already stores its minimum value, getMin() works in O(1).

Example:

Operations:

push(5)

push(3)

push(7)

push(2)

Stack:

[5,5]

[3,3]

[7,3]

[2,2]

getMin()

Output:

2

Time Complexity:

push()    → O(1)

pop()     → O(1)

top()     → O(1)

getMin()  → O(1)

Reason:
• Every operation accesses only the top element of the stack.

Space Complexity:

O(n)

Reason:
• One stack stores an array containing the value and the minimum value for every element.

Edge Cases:

• Push only one element.
• Duplicate minimum values.
• Negative numbers.
• Calling getMin() after multiple pop operations.

Code:

class MinStack {
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int value) {
        int currentMin = stack.isEmpty() ? value : Math.min(value, stack.peek()[1]);
        stack.push(new int[]{value, currentMin});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}