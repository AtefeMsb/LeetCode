/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
	    // Pointer
        Node cur = head; 
        while( cur != null) {
            /* CASE 1: if no child, proceed */
            if (cur.child == null ) {
                cur = cur.next;
                continue;
            }
            /* CASE 2: got child, find the tail of the child and link it to cur.next */
            Node temp = cur.child;
            // Find the tail of the child
            while (temp.next != null ) {
                temp = temp.next;
            }
            // Connect tail with cur.next, if it is not null
            temp.next = cur.next;  
            if (cur.next != null ) {
                cur.next.prev = temp;
            }
            // Connect cur with cur.child, and remove cur.child
            cur.next = cur.child; 
            cur.child.prev = cur;
            cur.child = null;
        }
        return head;
    }
}
