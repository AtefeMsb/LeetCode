package LinkedList;

/**
 * using 2 passes
 * time complexity: O(n)
 * space complexity: O(n)
 */
class Solution {
    public Node copyRandomList(Node head) {
        
        // first pass - create a copy of the nodes and put them in a hashmap
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;
        }
        
        // second pass - set next and random pointers
        cur = head;
        while (cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }
        
        return map.get(head);
        
    }
}