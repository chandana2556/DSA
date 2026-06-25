// Problem: LeetCode 234 - Palindrome Linked List
// Description:
// Given the head of a singly linked list,
// return true if it is a palindrome,
// otherwise return false.

/*
Edge Cases:
- Empty list
- Single node
- Even number of nodes
- Odd number of nodes
- All nodes same
*/


import java.util.*;


/* =======================
   Approach 1: Extra Array
   ======================= */

class Solution {

    public boolean isPalindrome(ListNode head) {

        List<Integer> vals = new ArrayList<>();

        ListNode curr = head;

        // Store all values
        while(curr != null){

            vals.add(curr.val);

            curr = curr.next;
        }

        int left = 0;
        int right = vals.size() - 1;

        // Compare from both ends
        while(left < right){

            if(!vals.get(left).equals(vals.get(right))){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

/*
Explanation:

Store all node values in an ArrayList.

Example:

1 -> 2 -> 2 -> 1

Array:

[1,2,2,1]

Compare:

1 == 1

2 == 2

Palindrome

Time Complexity: O(n)

Space Complexity: O(n)
*/


/* =======================
   Approach 2: Reverse Second Half (Optimal)
   ======================= */

class Solution {

    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode prev = null;
        ListNode curr = slow;

        while(curr != null){

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        // Compare both halves
        ListNode left = head;
        ListNode right = prev;

        while(right != null){

            if(left.val != right.val){
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }
}

/*
Explanation:

Step 1:
Find the middle using Slow & Fast pointers.

Example:

1 -> 2 -> 2 -> 1

        ↑
      slow

--------------------------------

Step 2:
Reverse the second half.

Original:

1 -> 2 -> 2 -> 1

Second Half:

2 -> 1

After Reverse:

1 -> 2

--------------------------------

Step 3:
Compare both halves.

Left:

1 -> 2

Right:

1 -> 2

All values match.

Answer:
true

--------------------------------

Why reverse only second half?

No extra array is needed.
We compare the first half directly with the reversed second half.

Time Complexity: O(n)

Space Complexity: O(1)
*/