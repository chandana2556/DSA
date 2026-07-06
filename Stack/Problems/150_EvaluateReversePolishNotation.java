# LeetCode 150 - Evaluate Reverse Polish Notation

Reverse Polish Notation (RPN), also called Postfix Notation, is an expression where the operator comes after its operands.

Example:

Infix:

2 + 3

Postfix:

2 3 +

You are given an array of strings representing a valid Reverse Polish Notation expression. Evaluate the expression and return the result.

Example:

Input:

["2","1","+","3","*"]

Evaluation:

2 + 1 = 3

3 * 3 = 9

Output:

9

============================================================
APPROACH (Using Stack)
============================================================

Approach:

• Create an empty stack to store numbers.
• Traverse each token in the given array.
• If the token is a number, convert it into an integer and push it into the stack.
• If the token is an operator (+, -, *, /):
    - Pop the first operand from the stack.
    - Pop the second operand from the stack.
    - Perform the operation as:
        • second + first
        • second - first
        • second * first
        • second / first
    - Push the result back into the stack.
• Continue until all tokens are processed.
• The final answer will be the only element remaining in the stack.

Example:

Input:

["2","1","+","3","*"]

Process:

Push 2

Push 1

'+' → 2 + 1 = 3 → Push 3

Push 3

'*' → 3 × 3 = 9 → Push 9

Output:

9

Time Complexity:

O(n)

Reason:
• Every token is processed exactly once.
• Each push and pop operation takes O(1).

Space Complexity:

O(n)

Reason:
• In the worst case, all numbers are stored in the stack.

Edge Cases:

• Single number → ["5"] → 5
• Negative numbers → ["4","-2","/"] → -2
• Division always truncates toward zero.
• Expressions containing all four operators.
• Large valid postfix expressions.

Code:

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
                int first = stack.pop();
                int second = stack.pop();
                if(token.equals("+")){
                    int ans=first+second;
                    stack.push(ans);
                }else if(token.equals("-")){
                    int ans=second-first;
                    stack.push(ans);
                }else if(token.equals("*")){
                    int ans=first*second;
                    stack.push(ans);
                }else{
                    int ans=second/first;
                    stack.push(ans);
                }
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}