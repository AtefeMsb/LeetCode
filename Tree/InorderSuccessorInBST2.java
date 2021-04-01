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
    public Node inorderSuccessor(Node node) {
        
        // case 1: if node has a right child
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            
            return node;
        }
        
        // case 2: if node has no right child
        // chase the trail of parents upward till you get to a node that its val is more than node.val
        // that is the successor
        Node ancestor = node.parent;
        while (ancestor != null && ancestor.val < node.val) {
            ancestor = ancestor.parent;
        }
        
        return ancestor;

        // -----------------------------------------
        // case 2: Node has no right child, and hence its successor is somewhere upper in the tree.
        // Go up till the node that is left child of its parent. The answer is the parent.
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
        // -----------------------------------------
        
    }
}