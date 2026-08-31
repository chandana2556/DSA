/*
============================================================
Problem: LeetCode 2351 - First Letter to Appear Twice
============================================================

Description:
Given a string s consisting of lowercase English letters,
return the first character that appears twice..

The answer is guaranteed to exist.

Example:
Input:
s = "abccbaacz"

Output:
"c"

The first character that appears for the second time is 'c'.


Edge Cases:
- Repeated character appears at the beginning
- Repeated character appears near the end
- Same character appears many times
- String contains only one distinct repeated character
*/


/*
============================================================
Approach 1: HashMap
============================================================

Use a HashMap to keep track of characters that have already
appeared.

For every character:

    If it is not present in the HashMap:
        add it.

    If it is already present:
        return that character.

Because we scan from left to right, the first character
we find again is the required answer.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public char repeatedCharacter(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()) {

            if(map.containsKey(ch)) {
                return ch;
            }

            map.put(ch, 1);
        }

        return ' ';
    }
}


/*
============================================================
Approach 2: HashSet
============================================================

A HashSet stores only unique characters.

For every character:

    If the character is already in the Set:
        it is repeated, so return it.

    Otherwise:
        add it to the Set.

We only need to know whether a character appeared before,
so HashSet is simpler than HashMap.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public char repeatedCharacter(String s) {

        HashSet<Character> seen = new HashSet<>();

        for(char ch : s.toCharArray()) {

            if(seen.contains(ch)) {
                return ch;
            }

            seen.add(ch);
        }

        return ' ';
    }
}


/*
============================================================
Approach 3: Frequency Array
============================================================

The string contains only lowercase English letters.

There are only 26 possible characters:

'a' to 'z'

So instead of using a HashMap or HashSet, we can use
an integer array of size 26.

Convert the character into an array index using:

ch - 'a'

For example:

'a' - 'a' = 0
'b' - 'a' = 1
'c' - 'a' = 2

If freq[index] is already greater than 0,
the character has appeared before.

Otherwise, increase its frequency.

Time Complexity: O(n)
Space Complexity: O(1)

The space is O(1) because the array always contains
only 26 positions.
*/

class Solution {
    public char repeatedCharacter(String s) {

        int[] freq = new int[26];

        for(char ch : s.toCharArray()) {

            int index = ch - 'a';

            if(freq[index] > 0) {
                return ch;
            }

            freq[index]++;
        }

        return ' ';
    }
}


/*
============================================================
Approach 4: Boolean Array
============================================================

We don't actually need to store the complete frequency.

We only need to know:

"Have I seen this character before?"

So we can use a boolean array of size 26.

false → character has not appeared
true  → character has already appeared

If seen[index] is already true, return the character.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public char repeatedCharacter(String s) {

        boolean[] seen = new boolean[26];

        for(char ch : s.toCharArray()) {

            int index = ch - 'a';

            if(seen[index]) {
                return ch;
            }

            seen[index] = true;
        }

        return ' ';
    }
}


/*
============================================================
Execution Example
============================================================

Input:
s = "abccbaacz"

Start scanning from left to right.

'a' → first time → store
'b' → first time → store
'c' → first time → store
'c' → already seen → return 'c'

Output:
'c'


============================================================
Approach Comparison
============================================================

Approach 1: HashMap
Time  : O(n)
Space : O(n)

Approach 2: HashSet
Time  : O(n)
Space : O(n)

Approach 3: Frequency Array
Time  : O(n)
Space : O(1)

Approach 4: Boolean Array
Time  : O(n)
Space : O(1) 


Why?

The problem guarantees that the string contains only
lowercase English letters.

Therefore, there are only 26 possible characters.

A boolean array of size 26 is enough to remember
whether each character has appeared.

No HashMap or HashSet is required.
*/
