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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode curr = head;
        for(int i=1; i<left; i++){
            curr = curr.next;
        }
        ListNode temp = curr;

        ListNode prev = null;
        ListNode next = null;

        for(int i=0; i<(right-left+1); i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr = head;
        for(int i=1; i<left-1; i++){
            curr = curr.next;
        }
        if(left == 1){
            head = prev;
        }else{
            curr.next = prev;
        }
        temp.next = next;

        return head;
    }
}