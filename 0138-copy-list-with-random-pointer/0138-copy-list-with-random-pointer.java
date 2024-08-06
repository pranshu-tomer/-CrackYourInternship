/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null){
            return null;
        }
        
        Node temp = head;
        while(temp != null){
            Node curr = new Node(temp.val);
            Node next = temp.next;
            temp.next = curr;
            curr.next = next;
            temp = next; 
        }

        temp = head;
        while(temp != null){
            if(temp.random == null){
                temp.next.random = null;
            }else{
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node newHead = temp.next;
        while(temp != null){
            Node next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            if(temp != null){
                next.next = temp.next;
            }else{
                next.next = null;
            }
        }

        return newHead;
    }
}