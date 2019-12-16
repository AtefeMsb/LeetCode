class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        Stack<TreeNode> stack = new Stack();
        int predecessor = Integer.MIN_VALUE;;
        TreeNode cur = root;
        
        // 1- If the node has a right child, go one step right and
        // then left till you can. Return the successor.
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p; 
        }
        
        // 2- Otherwise, implement iterative inorder traversal.
        // While there are still nodes in the tree or in the stack:
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            // if the previous node was equal to p
            // then the current node is its successor
            if (predecessor == p.val) {
                return cur;
            }
            predecessor = cur.val;
            cur = cur.right;
        }
        
        // 3- If we're here that means the successor doesn't exit. Return null.
        return null;
    }
}
