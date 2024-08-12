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
    public ListNode partition(ListNode head, int x) {
        
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        ListNode smallCurr = small;
        ListNode largeCurr = large;

        while(head != null){
            if(head.val < x){
                smallCurr.next = head;
                smallCurr = smallCurr.next;
            }else{
                largeCurr.next = head;
                largeCurr = largeCurr.next;
            }
            head = head.next;
        }

        largeCurr.next = null;
        smallCurr.next = large.next;

        return small.next;
    }
}