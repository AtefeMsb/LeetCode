// Recursive
    // https://www.youtube.com/watch?v=yEwSGhSsT0U
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer lowerBound, Integer upperBound) {
        
        if (root == null) {
            return true;
        }
        
        if (lowerBound != null && root.val <= lowerBound) return false;
        if (upperBound != null && root.val >= upperBound) return false;
            
        return ( helper(root.left, lowerBound, root.val) &&
                 helper(root.right, root.val , upperBound));
    }
    // -------------------------------------------------------------
    
    // iterative - inorder
    public boolean isValidBST(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;
        
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            // travel to left
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
           // If next element in inorder traversal
           // is smaller than the previous one
           // that's not BST.
           if (cur.val <= inorder) return false;
            
            // update the previous value
           inorder = cur.val;
           cur = cur.right;
        }
 
        return true;
    }
