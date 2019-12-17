
    // recursive    
    public TreeNode searchBST(TreeNode root, int val) {
        
        if (root == null || root.val == val) {
            return root;
        }
      
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        
        return searchBST(root.right, val); 
    }
    
 // ---------------------------------------------------------------------------------   
    // iterative
    public TreeNode searchBST(TreeNode root, int val) {
        
        TreeNode cur = root;
        
        while (cur != null && cur.val != val) {
            if (val < cur.val) {
                cur = cur.left;
            } else if (val > cur.val) {
                cur = cur.right;
            }
        }
        
        return cur;
    }
