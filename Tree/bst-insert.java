
    // iterative
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        // traversing pointer
        TreeNode cur = root;
        // trailing/previous pointer
        TreeNode pre = null;
        
        if (cur == null) {
            return new TreeNode(val);
        }
        
        // search for the leaf
        while (cur != null) {
            
            // update the pre
            pre = cur;
            
            if (val > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left; 
            }
        }
        
        // insert the node node after previous node
        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }
    
        return root;
    }
    // -----------------------------------------------------------------------------
    // recursive
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // return a new node if root is null
        // this happens when 1. the original tree is empty
        // 2. when we found the location and want to create the new node
        if (root == null) {
            return new TreeNode(val);   
        }
        
        // insert to the right subtree if val > root->val
        if (root.val < val) {           
            root.right = insertIntoBST(root.right, val);
        
        // insert to the left subtree if val <= root->val
        } else {                        
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
