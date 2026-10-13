/*
============================================================
Problem: LeetCode 1598 - Crawler Log Folder

Description:
You are given an array of strings logs representing
operations performed by a file system crawler.

Each operation can be:
- "../" : Move to the parent folder.
- "./"  : Remain in the current folder.
- "x/"  : Move into a child folder named x.

The crawler starts in the main folder.

Return the minimum number of operations needed to return
to the main folder from the current folder.

Concept:
This problem can be solved using a Counter or a Stack.

Example:

Input:
logs = ["d1/", "d2/", "../", "d21/", "./"]

Output:
2

Explanation:
"d1/"  -> depth = 1
"d2/"  -> depth = 2
"../"  -> depth = 1
"d21/" -> depth = 2
"./"   -> depth = 2

The crawler is two folders deep, so the answer is 2.
============================================================
*/


/*
============================================================
Approach 1: Counter Approach

Concept:
- Maintain a variable depth, initially 0.
- For "./", do nothing.
- For "../", decrease depth only if depth > 0.
- For a folder operation, increase depth by 1.
- Return depth.

Time Complexity: O(n)
Space Complexity: O(1)

Where n is the number of log operations.
============================================================
*/

class Solution {
    public int minOperations(String[] logs) {

        int depth = 0;

        for (int i = 0; i < logs.length; i++) {

            if (logs[i].equals("./")) {
                continue;
            } else if (logs[i].equals("../")) {
                if (depth > 0) {
                    depth--;
                }
            } else {
                depth++;
            }
        }

        return depth;
    }
}


/*
============================================================
Approach 2: Stack Approach

Concept:
- Create an empty stack to represent the folder path.
- For "./", do nothing.
- For "../", pop a folder if the stack is not empty.
- For a folder operation, push the folder onto the stack.
- Return the stack size.

Time Complexity: O(n)
Space Complexity: O(n)

Where n is the number of log operations.
============================================================
*/

import java.util.Stack;

class Solution {
    public int minOperations(String[] logs) {

        Stack<String> st = new Stack<>();

        for (int i = 0; i < logs.length; i++) {

            if (logs[i].equals("./")) {
                continue;
            } else if (logs[i].equals("../")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(logs[i]);
            }
        }

        return st.size();
    }
}