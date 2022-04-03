class Solution {
    Node head = null;
    Node tail = null;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        
        // make the doubly linkedlist circular
        tail.right = head;
        head.left = tail;
        
        return head;
    }
    
    // inorder traversal
    private void dfs(Node root) {
        
        if (root == null) {
            return;
        }
        
        dfs(root.left);
        
        // add the node right after tail
        if (tail != null) {
            tail.right = root;
            root.left = tail;
        } else {
            head = root;
        }
        
        // move tail one forward
        tail = root;
        
    
        dfs(root.right);
    }
}