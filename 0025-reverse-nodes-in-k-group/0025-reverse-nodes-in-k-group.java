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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode start = head;
        ListNode prevStart = null;
        int count = 0;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
            if(count == k){
                if(prevStart == null){
                    head = prev;
                    prev = null;
                    prevStart = start;
                    start = curr;
                    count = 0;
                }else{
                    prevStart.next = prev;
                    prev = null;
                    prevStart = start;
                    start = curr;
                    count = 0;
                }
            }
        }

        
        if(count > 0){
            curr = prev;
            prev = null;
            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            prevStart.next = prev;
        }

        return head;
    }
}