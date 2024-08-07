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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        if(size == 0){
            return head;
        }
        if(size-n-1 < 0){
            return head.next;
        }
        temp = head;
        for(int i=0; i<(size-n-1); i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}