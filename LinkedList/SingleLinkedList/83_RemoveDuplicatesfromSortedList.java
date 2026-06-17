// Problem: LeetCode 83 - Remove Duplicates from Sorted List
// Description:
// Given the head of a sorted linked list,
// delete all duplicates such that each element appears only once.
// Return the linked list sorted as well.

/*
Edge Cases:
- Empty list
- Single node
- All nodes same
- No duplicates
- Duplicates at beginning/end
*/


import java.util.*;


/* =======================
   Approach 1: HashSet
   ======================= */

class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return null;
        }

        Set<Integer> seen = new HashSet<>();

        seen.add(head.val);

        ListNode curr = head;

        while(curr.next != null){

            if(seen.contains(curr.next.val)){

                curr.next = curr.next.next;
            }

            else{

                seen.add(curr.next.val);

                curr = curr.next;
            }
        }

        return head;
    }
}

/*
Explanation:
- Store visited values in HashSet
- If next node value already exists:
    remove that node
- Otherwise:
    add value to set

Example:
1 -> 1 -> 2 -> 3 -> 3

Result:
1 -> 2 -> 3

Time Complexity: O(n)
Space Complexity: O(n)
*/


/* =======================
   Approach 2: Traversal (Optimal)
   ======================= */

class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while(curr != null &&
              curr.next != null){

            // duplicate found
            if(curr.val == curr.next.val){

                curr.next = curr.next.next;
            }

            else{

                curr = curr.next;
            }
        }

        return head;
    }
}

/*
Explanation:
- List is already sorted
- Duplicates appear adjacent

Example:
1 -> 1 -> 2 -> 3 -> 3

curr = 1

1 == 1
remove second 1

1 -> 2 -> 3 -> 3

3 == 3
remove second 3

Result:
1 -> 2 -> 3

Time Complexity: O(n)
Space Complexity: O(1)
*/