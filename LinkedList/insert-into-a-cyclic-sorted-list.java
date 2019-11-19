/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        // If the list is empty
        if (head == null) {
            node.next = node;
            return node;
        }
        
        Node pre = head; 
        Node cur = head.next;
    
        while (cur != head) {
            if (pre.val <= insertVal && insertVal <= cur.val) {
                break;
            }
            if (pre.val > cur.val) {
                if (insertVal <= cur.val || insertVal >= pre.val) break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head;
    }
}
