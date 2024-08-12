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
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = mid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode head3 = sortList(head);
        head2 = sortList(head2);

        return merge(head3,head2);
    }

    public ListNode merge(ListNode head,ListNode head2){

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while(head != null && head2 != null){
            if(head.val < head2.val){
                ans.next = head;
                head = head.next;
            }else{
                ans.next = head2;
                head2 = head2.next;
            }
            ans = ans.next;
        }

        while(head != null){
            ans.next = head;
            head = head.next;
            ans = ans.next;
        }

        while(head2 != null){
            ans.next = head2;
            head2 = head2.next;
            ans = ans.next;
        }

        ans.next = null;
        return temp.next;
    }

    public ListNode mid(ListNode head){

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}