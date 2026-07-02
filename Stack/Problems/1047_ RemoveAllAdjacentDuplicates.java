# LeetCode 1047 - Remove All Adjacent Duplicates In String

Given a string `s`, repeatedly remove adjacent duplicate characters until no adjacent duplicates remain. Return the final string.

Example:

Input  : "abbcddcj"
Output : "aj"

============================================================
BRUTE FORCE APPROACH (Repeated Deletion using StringBuilder)
============================================================

Approach:

• Convert the given string into a StringBuilder so that characters can be deleted efficiently.
• Use a boolean variable `found` to check whether any adjacent duplicate was removed in the current iteration.
• Traverse the StringBuilder and compare every character with its next character.
• If two adjacent characters are equal, delete both of them using `delete(i, i + 2)`.
• Set `found = true` and restart scanning from the beginning because deleting one pair may create new adjacent duplicates.
• Continue this process until no adjacent duplicates are found.
• Return the final string.

Example:

Input  : "abbcddcj"

abbcddcj
↓

acddcj
↓

accj
↓

aj

Output : "aj"

Time Complexity:

O(n²)

Reason:
• The for loop scans the string in O(n).
• The while loop may run multiple times.
• delete() shifts remaining characters, making the overall complexity O(n²).

Space Complexity:

O(n)

Reason:
• StringBuilder stores a copy of the input string.

Edge Cases:

• "" → ""
• "a" → "a"
• "aa" → ""
• "abba" → ""
• "abbaca" → "ca"
• "aaaa" → ""

Code:

class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean found = true;

        while (found) {
            found = false;

            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);
                    found = true;
                    break;
                }
            }
        }

        return sb.toString();
    }
}

============================================================
OPTIMAL APPROACH (Using Stack)
============================================================

Approach:

• Create an empty stack to store characters.
• Traverse the string character by character.
• If the stack is not empty and the top element is equal to the current character, pop the top element.
• Otherwise, push the current character into the stack.
• After processing all characters, the stack contains the final answer in reverse order.
• Pop all characters into a StringBuilder.
• Reverse the StringBuilder and return the result.

Example:

Input  : "abbcddcj"

Read 'a' → Push

Read 'b' → Push

Read 'b' → Pop

Read 'c' → Push

Read 'd' → Push

Read 'd' → Pop

Read 'c' → Pop

Read 'j' → Push

Final Stack:

a
j

Output : "aj"

Time Complexity:

O(n)

Reason:
• Each character is pushed into the stack at most once.
• Each character is popped at most once.

Space Complexity:

O(n)

Reason:
• In the worst case, all characters are stored in the stack.

Edge Cases:

• "" → ""
• "a" → "a"
• "aa" → ""
• "abba" → ""
• "abbaca" → "ca"
• "aaaa" → ""

Code:

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()==c){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}