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
    public void reorderList(ListNode head) {
        
        if(head.next == null){
            return ;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow);
        prev.next = null;

        ListNode head3 = new ListNode(-1);
        slow = head3;
        while(head != null && head2 != null){
            slow.next = head;
            head = head.next;
            slow = slow.next;
            slow.next = head2;
            head2 = head2.next;
            slow = slow.next;
        }

        head = head3.next;
    }

    public ListNode reverse(ListNode head){

        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}