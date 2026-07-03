# LeetCode 1614 - Maximum Nesting Depth of the Parentheses

Given a valid parentheses string `s`, return the maximum nesting depth of the parentheses.

The nesting depth is the maximum number of open parentheses at any point in the string.

Example:

Input  : "(1+(2*3)+((8)/4))+1"
Output : 3

============================================================
APPROACH 1 (Using Stack)
============================================================

Approach:

• Create an empty stack to store opening parentheses.
• Traverse the string character by character.
• If the current character is '(', push it into the stack.
• After every push, update the maximum depth using the current stack size.
• If the current character is ')', pop the top element from the stack.
• Ignore all other characters.
• Return the maximum depth.

Example:

Input:

"(1+(2*3)+((8)/4))+1"

Maximum Stack Size:

3

Output:

3

Time Complexity:

O(n)

Reason:
• Each character is visited exactly once.
• Every opening parenthesis is pushed once and popped once.

Space Complexity:

O(n)

Reason:
• In the worst case, all opening parentheses are stored in the stack.

Edge Cases:

• "" → 0
• "abc" → 0
• "()" → 1
• "(())" → 2
• "((()))" → 3
• "(1)+((2))+(((3)))" → 3

Code:

class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(c);
                maxDepth = Math.max(maxDepth,stack.size());
            }else if(c==')'){
                stack.pop();
            }
        }
        return maxDepth;
    }
}

============================================================
APPROACH 2 (Optimal - Using Counter)
============================================================

Approach:

• Create two variables: `currDepth` and `maxDepth`.
• Traverse the string character by character.
• If the current character is '(', increase `currDepth`.
• Update `maxDepth` using the maximum value between `currDepth` and `maxDepth`.
• If the current character is ')', decrease `currDepth`.
• Ignore all other characters.
• Return `maxDepth`.

Example:

Input:

"(1+(2*3)+((8)/4))+1"

Current Depth:

1 → 2 → 1 → 2 → 3 → 2 → 1 → 0

Maximum Depth:

3

Output:

3

Time Complexity:

O(n)

Reason:
• Each character is processed only once.

Space Complexity:

O(1)

Reason:
• Only two integer variables are used regardless of the input size.

Edge Cases:

• "" → 0
• "abc" → 0
• "()" → 1
• "(())" → 2
• "((()))" → 3
• "(1)+((2))+(((3)))" → 3

Code:

class Solution {
    public int maxDepth(String s) {
        int currDepth = 0;
        int maxDepth = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                currDepth++;
                maxDepth = Math.max(maxDepth,currDepth);
            }else if(c==')'){
                currDepth--;
            }
        }
        return maxDepth;
    }
}