/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        
        // find all ancestors of node p
        Set<Node> pAncestors = new HashSet<>();
        
        while (p != null) {
            pAncestors.add(p);
            p = p.parent;
        }
        
        // look for a common ancestor of q in ancestors set of p
        while (!pAncestors.contains(q)) {
            q = q.parent;
        }
        
        return q;  
    }
}