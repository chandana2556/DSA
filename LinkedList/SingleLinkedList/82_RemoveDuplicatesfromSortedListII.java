/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> count =new HashMap<>();
        ListNode current = head;
        while(current!=null){
            count.put(current.val,count.getOrDefault(current.val,0)+1);
            current = current.next;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        while(prev.next!=null){
            if(count.get(prev.next.val)>1){
                prev.next=prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        ListNode curr  = head;
        while(curr!=null){
            if(curr.next!=null && curr.val==curr.next.val){
                while(curr.next!=null && curr.val==curr.next.val){
                    curr=curr.next;
                }
                prev.next = curr.next;
            }else{
                prev=prev.next;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}