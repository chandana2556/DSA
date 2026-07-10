// Problem: LeetCode 3 - Longest Substring Without Repeating Characters
// Description:
// Given a string s, find the length of the longest substring
// without repeating characters.

/*
Edge Cases:
- Empty string
- Single character
- All characters same
- All characters unique
- Repeating characters in between
*/

import java.util.*;


/* =======================
   Approach 1: Brute Force
   ======================= */

class Solution {

    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;

        for(int i = 0; i < s.length(); i++){

            HashSet<Character> set = new HashSet<>();

            for(int j = i; j < s.length(); j++){

                if(set.contains(s.charAt(j))){
                    break;
                }

                set.add(s.charAt(j));

                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }
}

/*
Explanation:

For every starting index,
try extending the substring until
a duplicate character appears.

HashSet stores all unique characters
present in the current substring.

Example:

s = "abcabcbb"

Start at index 0

Window:

a
ab
abc

Next character:

a

Already exists in HashSet

Stop.

Longest = 3

Start from next index and repeat.

------------------------------------

Why HashSet?

We only need to know

"Is this character already present?"

HashSet provides

contains() -> O(1)
add() -> O(1)
remove() -> O(1)

Time Complexity: O(n²)

Space Complexity: O(n)
*/


/* =======================
   Approach 2: Sliding Window + HashSet
   ======================= */

class Solution {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;

        int maxLength = 0;

        for(int right = 0; right < s.length(); right++){

            // Remove duplicates from window
            while(set.contains(s.charAt(right))){

                set.remove(s.charAt(left));

                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

/*
Explanation:

Maintain a window

[left ........ right]

that always contains unique characters.

If duplicate comes:

Shrink window
from the left
until duplicate disappears.

Example:

s = "abcabcbb"

--------------------------------

right = 0

Window:

a

Length = 1

--------------------------------

right = 1

Window:

ab

Length = 2

--------------------------------

right = 2

Window:

abc

Length = 3

--------------------------------

right = 3

Character = a

Already exists

Remove left characters:

remove a

Window:

bc

Now insert a

Window:

bca

Length still = 3

Continue...

Answer = 3

--------------------------------

Why HashSet?

Because we only need to know

whether a character already exists
inside the current window.

HashSet operations are O(1).

Time Complexity: O(n)

Space Complexity: O(n)
*/


/* =======================
   Approach 3: Sliding Window + HashMap (Optimal)
   ======================= */

class Solution {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        int left = 0;

        int maxLength = 0;

        for(int right = 0; right < s.length(); right++){

            char ch = s.charAt(right);

            if(map.containsKey(ch)){

                left = Math.max(left,
                                map.get(ch) + 1);
            }

            map.put(ch, right);

            maxLength = Math.max(maxLength,
                                 right - left + 1);
        }

        return maxLength;
    }
}

/*
Explanation:

Instead of only storing characters,

HashMap stores

Character -> Last Index

Example:

a -> 0

b -> 1

c -> 2

Now when duplicate appears,

we immediately know

where it appeared last.

So we can jump left pointer directly.

------------------------------------

Example:

s = "abcabcbb"

Initially

Map

a -> 0

b -> 1

c -> 2

--------------------------------

right = 3

Character = a

Map says

a was last seen at index 0

Instead of removing

a

b

c

one by one,

move

left = 0 + 1

left = 1

Window becomes

bca

Very efficient.

--------------------------------

Another Example

s = "abba"

right = 0

a

Map

a -> 0

--------------------------------

right = 1

ab

Map

a -> 0

b -> 1

--------------------------------

right = 2

Character = b

Previously seen at index 1

Move

left = 2

Window

b

Map

b -> 2

--------------------------------

right = 3

Character = a

Previous index

0

Current left = 2

Don't move backwards.

So,

left = Math.max(left,
                previousIndex + 1)

left = Math.max(2,1)

= 2

This is why we use

Math.max()

--------------------------------

Why HashMap?

HashSet only stores

Character

Example

a
b
c

But HashMap stores

a -> last index

b -> last index

c -> last index

HashMap allows us to

jump the left pointer

instead of removing
characters one by one.

--------------------------------

Difference

HashSet

Stores only values

Example

a
b
c

Can answer

"Does this character exist?"

--------------------------------

HashMap

Stores

Character -> Index

Example

a -> 0

b -> 1

c -> 2

Can answer

"Where was this character last seen?"



Time Complexity: O(n)

Space Complexity: O(n)