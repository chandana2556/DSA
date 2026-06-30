# Valid Parentheses (LeetCode 20)

A string is valid if:
• Every opening bracket has a corresponding closing bracket.
• Brackets are closed in the correct order.
• Valid bracket pairs are (), [], and {}.

============================================================
BRUTE FORCE APPROACH (Repeated Replacement)
============================================================

Approach:

• This approach repeatedly removes valid adjacent bracket pairs: (), [], and {}.
• A variable `prev` is used to store the previous version of the string.
• The loop continues until the string no longer changes (i.e., s.equals(prev)).
• In each iteration, all occurrences of (), [], and {} are replaced with an empty string "".
• If the string becomes empty after all replacements, all brackets were matched correctly, so return true.
• Otherwise, return false.

Example:

Input  : "({[]})"
Output : true

Time Complexity:

O(n²)

Reason:
• Each replace() operation scans the entire string in O(n).
• In the worst case, around n/2 iterations are required.
• Therefore, the overall time complexity is O(n²).

Space Complexity:

O(n)

Reason:
• Each replace() creates a new intermediate string.

Edge Cases:

• "" → true
• "()" → true
• "([{}])" → true
• "(]" → false
• "([)]" → false
• "(" → false
• ")" → false

Code:

class Solution {
    public boolean isValid(String s) {
        String prev="";
        while(!s.equals(prev)){
            prev=s;
            s=s.replace("()","").replace("[]","").replace("{}","");
        }
        return s.isEmpty();
    }
}

============================================================
OPTIMAL APPROACH (Using Stack)
============================================================

Approach:

• Create an empty stack to store opening brackets.
• Create a HashMap that stores the matching opening bracket for every closing bracket.
• Traverse the string character by character.
• If the current character is an opening bracket, push it into the stack.
• If the current character is a closing bracket, check whether the stack is empty or whether the top element matches its corresponding opening bracket.
• If it does not match, return false immediately.
• After traversing the entire string, return true only if the stack is empty.

Example:

Input  : "({[]})"
Output : true

Time Complexity:

O(n)

Reason:
• Each bracket is pushed into the stack at most once.
• Each bracket is popped from the stack at most once.
• Therefore, every character is processed only once.

Space Complexity:

O(n)

Reason:
• In the worst case, all opening brackets are stored in the stack.

Edge Cases:

• "" → true
• "()" → true
• "([{}])" → true
• "(]" → false
• "([)]" → false
• "(" → false
• ")" → false

Code:

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> matchMap = Map.of(')','(',']','[','}','{');
        for(char c : s.toCharArray()){
            if(matchMap.containsKey(c)){
                if(stack.isEmpty() || stack.pop()!=matchMap.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}