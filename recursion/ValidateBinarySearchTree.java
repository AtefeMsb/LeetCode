package recursion;

// DFS - top down
// Time complexity : O(N) 
// Space complexity : O(N) 
class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        
        return validate (root, null, null);
    }
    
    private boolean validate(TreeNode root, Integer low, Integer high) {
        
        if (root == null) return true;
        if ( (low != null && root.val <= low) ||
            (high != null && root.val >= high) ) {
            return false;
        }
        
        return validate (root.left, low, root.val) && validate (root.right, root.val, high);
        
    }
}

/// inorder
class Solution {
    // We use Integer instead of int as it supports a null value.
    private Integer prev;
    
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}