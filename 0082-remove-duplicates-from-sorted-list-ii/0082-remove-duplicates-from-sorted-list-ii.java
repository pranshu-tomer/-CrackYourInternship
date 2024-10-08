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

        if(head == null){
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;

        while(temp != null && temp.next != null){
            if(temp.val != temp.next.val){
                prev = temp;
                temp = temp.next;
            }else{
                int p = temp.val;
                while(temp != null && p == temp.val){
                    temp = temp.next;
                }
                if(prev == null){
                    head = temp;
                }else{
                    prev.next = temp;
                }
            }
        }

        return head;
    }
}