# LeetCode 2390 - Removing Stars From a String

You are given a string `s` containing lowercase English letters and `'*'`.

For every `'*'`, remove:
• The closest non-star character to its left.
• The `'*'` itself.

Return the final string after removing all stars.

Example:

Input  : "leet**cod*e"
Output : "lecoe"

============================================================
APPROACH 1 (Brute Force - Using StringBuilder)
============================================================

Approach:

• Convert the given string into a StringBuilder.
• Traverse the StringBuilder using an index.
• Whenever a '*' is found:
    - Delete the '*' character.
    - Delete the character immediately before it.
    - Move the index back to check for newly formed adjacent stars.
• Continue until the entire StringBuilder is processed.
• Return the final string.

Example:

Input:

"leet**cod*e"

Process:

leet**cod*e

↓

lee*cod*e

↓

lecod*e

↓

lecoe

Output:

lecoe

Time Complexity:

O(n²)

Reason:
• Each deleteCharAt() operation shifts the remaining characters.
• Multiple deletions make the overall complexity O(n²).

Space Complexity:

O(n)

Reason:
• StringBuilder stores a copy of the original string.

Edge Cases:

• "erase*****" → ""
• "abc" → "abc"
• "ab**" → ""
• "leet**cod*e" → "lecoe"
• "a*b*c*" → ""

Code:

class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i=0;
        while(i<sb.length()){
            if(sb.charAt(i)=='*'){
                sb.deleteCharAt(i);
                sb.deleteCharAt(i-1);
                i=Math.max(0,i-2);
            }else{
                i++;
            }
        }
        return sb.toString();
    }
}

============================================================
APPROACH 2 (Optimal - Using Stack)
============================================================

Approach:

• Create an empty stack.
• Traverse the string character by character.
• If the current character is not '*', push it into the stack.
• If the current character is '*', pop the top element from the stack.
• After processing all characters, the stack contains the final answer.
• Pop all characters into a StringBuilder.
• Reverse the StringBuilder because a stack follows LIFO order.
• Return the final string.

Example:

Input:

"leet**cod*e"

Process:

Push l

Push e

Push e

Push t

* → Pop t

* → Pop e

Push c

Push o

Push d

* → Pop d

Push e

Stack:

l
e
c
o
e

Output:

lecoe

Time Complexity:

O(n)

Reason:
• Every character is pushed and popped at most once.

Space Complexity:

O(n)

Reason:
• In the worst case, all characters are stored in the stack.

Edge Cases:

• "erase*****" → ""
• "abc" → "abc"
• "ab**" → ""
• "leet**cod*e" → "lecoe"
• "a*b*c*" → ""

Code:

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c!='*'){
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

============================================================
APPROACH 3 (Optimal - In-Place Stack Simulation)
============================================================

Approach:

• Convert the string into a character array.
• Use a variable `write` to represent the top of a virtual stack.
• Traverse each character in the array.
• If the character is not '*':
    - Store it at index `write`.
    - Increment `write`.
• If the character is '*':
    - Decrement `write` to remove the previously stored character.
• After processing all characters, the first `write` characters of the array contain the final answer.
• Return a new string using only the valid portion of the array.

Example:

Input:

"leet**cod*e"

Process:

Read l → Store

Read e → Store

Read e → Store

Read t → Store

* → write--

* → write--

Read c → Store

Read o → Store

Read d → Store

* → write--

Read e → Store

Final Array:

l e c o e

Output:

lecoe

Time Complexity:

O(n)

Reason:
• Every character is processed exactly once.

Space Complexity:

O(1)

Reason:
• The algorithm reuses the input character array and only uses one integer variable (`write`) as extra space.

Edge Cases:

• "erase*****" → ""
• "abc" → "abc"
• "ab**" → ""
• "leet**cod*e" → "lecoe"
• "a*b*c*" → ""

Code:

class Solution {
    public String removeStars(String s) {
        char [] arr = s.toCharArray();
        int write = 0;
        for(char c: arr){
            if(c=='*'){
                write--;
            }else{
                arr[write]=c;
                write++;
            }
        }
        return new String(arr,0,write);
    }
}