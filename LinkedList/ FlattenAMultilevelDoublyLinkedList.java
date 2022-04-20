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
        
        LinkedList<Node> stack = new LinkedList<>();
        Node cur = head;
        
        // save all the return points in a stack
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) {
                    stack.push(cur.next);
                    cur.next.prev = null;
                }
                
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
            
            // we want the tail to stay on tail and do not pass it to null
            if (cur.next != null) {
                cur = cur.next;
            } else {
                break;
            }
        }
        
        // connect tail to the return points in stack
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur.next.prev = cur;
            while (cur.next != null) {
                cur = cur.next;
            }            
        }
        
        return head;
        
    }
}