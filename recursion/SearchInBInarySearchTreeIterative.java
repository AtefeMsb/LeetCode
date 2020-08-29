package recursion;

class SearchInBInarySearchTreeIterative {
    public TreeNode searchBST(TreeNode root, int val) {
        
        while (root != null && root.val != val) {
            
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return root;
    }
}