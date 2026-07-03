




Brooo 😄 Let's understand the brute-force code step by step.

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
Step 1
StringBuilder sb = new StringBuilder(s);
We convert the string into a StringBuilder.

Why?
Because Java String is immutable.

We cannot delete characters directly from a String.

StringBuilder allows us to:

delete()

insert()

append()

Example:

s = "abbcddcj"

sb = "abbcddcj"
Step 2
boolean found = true;
This variable tells us whether we found any adjacent duplicate in the current pass.

Initially

found = true
so that the while loop runs at least once.

Step 3
while(found)
Meaning:

Continue checking until no adjacent duplicates are found.

Step 4
found = false;
At the beginning of every iteration we assume

"There are no duplicates."

If later we find one,

we'll make it

found = true;
again.

Dry Run
sb = "abbcddcj"
First While Iteration
found = false
Now start

for(int i=0;i<sb.length()-1;i++)
i = 0
Compare

a == b
No.

Move ahead.

i = 1
Compare

b == b
Yes!

Execute

sb.delete(i,i+2);
i = 1

Delete

bb
Now

sb = "acddcj"
Then

found = true;
Meaning

We found duplicates.

Then

break;
Why break?
Very important.

Suppose after deleting

bb
we got

acddcj
Everything shifted.

If we continue the same loop,

indexes become incorrect.

Instead,

restart scanning from the beginning.

That's why

break;
Second While Iteration
Now

sb = "acddcj"
Again

found = false
Compare

a c
Different.

Compare

c d
Different.

Compare

d d
Same.

Delete

dd
Now

sb = "accj"
Again

found = true
Break.

Third While Iteration
Now

sb = "accj"
Compare

a c
No.

Compare

c c
Yes.

Delete

cc
Now

sb = "aj"
Again

found = true
Break.

Fourth While Iteration
Now

sb = "aj"
Compare

a j
Different.

Loop finishes.

No duplicate found.

So

found = false
Now

while(found)
becomes

while(false)
Loop stops.

Return
return sb.toString();
Current

sb = "aj"
Answer

aj
Why do we use
sb.length()-1
instead of

sb.length()
Suppose

sb = "abcd"
Length

4
Indexes

0 1 2 3
If

i = 3
Then

sb.charAt(i+1)
becomes

sb.charAt(4)
❌ Invalid index.

So we stop at

length()-1
Why use
sb.delete(i,i+2)
Suppose

abbc
Indexes

0 1 2 3

a b b c
Duplicate

bb
Starts at

i = 1
Delete

delete(1,3)
Remember:

delete(start, end) removes characters from start up to end - 1.

So

delete(1,3)
removes

index 1
index 2
Exactly

bb
Result

ac
Time Complexity
Outer while loop can run up to O(n) times.

Inner for loop is O(n).

delete() may shift characters, which is also O(n).

Overall:

O(n²)
🔥 Interview Tip
This is called a Brute Force approach because after deleting one pair, you restart scanning the entire string from the beginning.

The Optimal Stack approach avoids restarting. It processes each character only once, which is why its time complexity is O(n).


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
oka box lo neat ga ivvuu push chestha description tc and sc

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

esplain baseball game question

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum =0;
        for(String op : operations){
            if(op="C"){
                stack.pop();
            }else if(op="D"){
                stack.peek()
            }else if(op="+"){

            }else{
                int num = Integer.parseInt(op);
                stack.push(num);
            }
        }
    }
}

Brooo 😄 You're on the right track! I won't give the complete solution yet—let's fix the mistakes one by one.

❌ Mistake 1: Comparing Strings
You wrote:

if(op="C")
In Java, use .equals() to compare strings.

✅ Correct:

if(op.equals("C"))
Similarly:

else if(op.equals("D"))
else if(op.equals("+"))
❌ Mistake 2: "D" Operation
You wrote:

stack.peek();
peek() only returns the value. It doesn't add anything.

The question says:

Double the previous score and record it as a new score.

So think:

Get the top score.

Multiply it by 2.

Push the result back.

❌ Mistake 3: "+" Operation
The question says:

Add the previous two scores.

Think about how to access the last two scores without losing them.

Hint:

int first = stack.pop();
int second = stack.peek();

stack.push(first);

// Now what should you push?
Can you figure out the last line?

❌ Mistake 4: Sum
You declared:

int sum = 0;
But you're never updating it.

The easiest approach is:

After processing all operations,

while(!stack.isEmpty()){
    sum += stack.pop();
}
Finally,

return sum;
Skeleton
for(String op : operations){

    if(op.equals("C")){

    }
    else if(op.equals("D")){

    }
    else if(op.equals("+")){

    }
    else{

    }
}
You're honestly very close. I think you can complete it now.

👉 Try filling only the D and + blocks and paste your updated code. I'll review it without directly giving the full answer.


at mistake 3 we should push the sum

Exactly brooo! 🔥💯

You're correct. After restoring the first popped value, you should push the sum of the last two scores.

Let's understand why.

Suppose the stack is:

Top
↓
10
5
The last two scores are:

First = 10

Second = 5

Now:

int first = stack.pop();   // first = 10
Stack becomes:

Top
↓
5
Now,

int second = stack.peek(); // second = 5
We use peek() because we don't want to remove the second score.

Now restore the first score:

stack.push(first);
Stack becomes:

Top
↓
10
5
Now push their sum:

stack.push(first + second);
Stack becomes:

Top
↓
15
10
5
This is exactly what the question wants because "+" means:

Record a new score that is the sum of the previous two scores.

So yes, your thinking is correct. ✅

Now try completing the code yourself. I think you'll solve the whole problem without needing the full solution. 💪


class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum =0;
        for(String op : operations){
            if(op.equals("C")){
                stack.pop();
            }else if(op.equals("D")){
                stack.peek();
            }else if(op.equals("+")){
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first+second);
            }else{
                int num = Integer.parseInt(op);
                stack.push(num);
            }
            while(!stack.isEmpty()){
                sum+=stack.pop();
            }
        }
        return sum;
    }
}

Brooo 😄🔥 You're very close. Only 2 mistakes remain.

❌ Mistake 1: "D" block
You wrote:

stack.peek();
This doesn't do anything.

For "D":

Get the last score.

Double it.

Push it.

Think like this:

int last = stack.peek();
stack.push(last * 2);
❌ Mistake 2 (Very Important)
You wrote:

for(String op : operations){

    ...

    while(!stack.isEmpty()){
        sum += stack.pop();
    }
}
❌ This is the biggest mistake.

Why?

Let's dry run.

Input:

["5","2"]
First iteration
Push 5

Stack:

5
Immediately your while loop executes.

It pops 5.

Stack becomes

Empty
sum = 5

Second iteration
Push 2

Stack

2
Again while loop executes.

Pop 2

sum = 7

Now imagine next operation is

"D"
Your stack is already empty.

So

stack.peek();
💥 Runtime Error (EmptyStackException)

Correct Structure
The while loop should be after the for loop.

Like this:

for(String op : operations){

    // process operations

}

while(!stack.isEmpty()){
    sum += stack.pop();
}

return sum;
So only these two changes:
✅ Fix "D"

✅ Move the while loop outside the for loop.

Bro... seriously 😄 I'm impressed.

Earlier you used to ask:

"Bro, code ivvu."

Now you're writing 95% of the solution yourself, and the mistakes are only about where to place the loop or what to do in one block.

That's exactly how DSA improvement looks. Keep solving like this instead of copying solutions—you'll become much stronger at problem solving. 💪


class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum =0;
        for(String op : operations){
            if(op.equals("C")){
                stack.pop();
            }else if(op.equals("D")){
                int last = stack.peek();
                stack.push(last *2);
            }else if(op.equals("+")){
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first+second);
            }else{
                int num = Integer.parseInt(op);
                stack.push(num);
            }
        }
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
cutiepie dhiniki description tc sc and edge cases ivvu maa

# LeetCode 682 - Baseball Game

You are given an array of strings `operations`, where each operation represents a score in a baseball game.

Operations:
• Integer → Record a new score.
• "+" → Record a new score that is the sum of the previous two scores.
• "D" → Record a new score that is double the previous score.
• "C" → Remove the previous score.

Return the sum of all the scores after performing all the operations.

Example:

Input  : ["5","2","C","D","+"]
Output : 30

============================================================
OPTIMAL APPROACH (Using Stack)
============================================================

Approach:

• Create an empty stack to store the valid scores.
• Traverse each operation in the given array.
• If the operation is an integer, convert it into an integer and push it into the stack.
• If the operation is "C", remove the last valid score by popping the top element from the stack.
• If the operation is "D", get the previous score using `peek()`, double it, and push the result into the stack.
• If the operation is "+", find the last two valid scores, calculate their sum, and push the new score into the stack.
• After processing all the operations, pop every score from the stack and calculate the total sum.
• Return the final sum.

Example:

Input:

["5","2","C","D","+"]

Process:

5  → Push

2  → Push

C  → Remove 2

D  → Double 5 → Push 10

+  → 5 + 10 = 15 → Push

Stack:

5
10
15

Sum:

5 + 10 + 15 = 30

Output:

30

Time Complexity:

O(n)

Reason:
• Each operation is processed exactly once.
• Every score is pushed and popped at most one time.

Space Complexity:

O(n)

Reason:
• In the worst case, all valid scores are stored in the stack.

Edge Cases:

• ["5"] → 5
• ["5","D"] → 15
• ["5","2","+"] → 14
• ["5","2","C"] → 5
• ["5","-2","4","C","D","9","+","+"] → 27

Code:

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum =0;
        for(String op : operations){
            if(op.equals("C")){
                stack.pop();
            }else if(op.equals("D")){
                int last = stack.peek();
                stack.push(last *2);
            }else if(op.equals("+")){
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first+second);
            }else{
                int num = Integer.parseInt(op);
                stack.push(num);
            }
        }
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
Great job, cutiepie! 💖 This solution is correct, follows the optimal stack approach, and is exactly the kind of explanation that looks neat in a GitHub DSA repository. Keep this same format for your future problem solutions too. 🚀


