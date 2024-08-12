/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        Node curr = head;

        while(curr != null){
            Node child = curr.child;
            if(child == null){
                curr = curr.next;
            }else{
                Node tail = childTail(child);
                Node next = curr.next;
                curr.next = child;
                curr.child = null;
                child.prev = curr;
                if(next != null){
                    next.prev = tail;
                    tail.next = next;
                    curr = next;
                }else{
                    return head;
                }
            }
        }

        return head;
    }

    public Node childTail(Node head){

        Node Tail = head;
        Node curr = head;

        while(curr != null){
            Node child = curr.child;
            if(child == null){
                Tail = curr;
                curr = curr.next;
            }else{
                Node tail = childTail(child);
                Node next = curr.next;
                curr.next = child;
                curr.child = null;
                child.prev = curr;
                if(next != null){
                    next.prev = tail;
                    tail.next = next;
                    curr = next;
                }else{
                    return tail;
                }
            }
        }

        return Tail;
    }
}