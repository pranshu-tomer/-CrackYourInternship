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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverse(add(reverse(l1),reverse(l2)));
    }

    public ListNode add(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(-1,null);
        ListNode temp = head;

        int rem = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val;
            sum = rem + sum;
            ListNode curr = new ListNode(sum%10,null);
            temp.next = curr;
            temp = curr;
            rem = sum/10;
            l1 = l1.next;
            l2  = l2.next;
        }

        while(l1 != null){
            int sum = l1.val + rem;
            ListNode curr = new ListNode(sum%10,null);
            temp.next = curr;
            temp = curr;
            rem = sum/10;
            l1 = l1.next;
        }

        while(l2 != null){
            int sum = l2.val + rem;
            ListNode curr = new ListNode(sum%10,null);
            temp.next = curr;
            temp = curr;
            rem = sum/10;
            l2 =  l2.next;
        }

        if(rem != 0){
            ListNode curr = new ListNode(rem,null);
            temp.next = curr;
        }

        return head.next;
    }

    public ListNode reverse(ListNode l){

        ListNode prev = null;
        ListNode curr = l;
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