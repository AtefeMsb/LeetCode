/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
 /* Clone hashmap - map the original node to its clone */
 // 1st pass: Give all nodes their clone in the mapping.
 // 2nd pass.Reset the curr pointer to the head of the original list. 
 // Give all clones their next and random pointer assignments.
class Solution {
    public Node copyRandomList(Node head) {
      
        if (head == null) {
            return null;
        }
        // 1st pass
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            Node cloneNode = new Node(cur.val);
            map.put(cur, cloneNode);
            cur = cur.next;
        }
          
        // 2nd pass
        cur = head;
        
        while (cur != null) {
            // set the next field
            // cloneMap.get(curr).next -> Set the next of curr's clone to...
            // cloneMap.get(curr.next) -> The clone of curr's next.
            map.get(cur).next = map.get(cur.next);
            
            // set the randome field
            // cloneMap.get(curr).random -> Set the random of curr's clone to...
            // cloneMap.get(curr.random) -> The clone node that curr.random is pointing to.
            map.get(cur).random = map.get(cur.random);
            
            cur = cur.next;
        }
        
        return map.get(head);
    }
}
