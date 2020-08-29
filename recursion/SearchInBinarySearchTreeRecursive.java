package recursion;

class SearchInBinarySearchTreeRecursive {
    public TreeNode searchBST(TreeNode root, int val) {
        
        // base case
        if (root == null || root.val == val) {
            return root;
        }
        
        if (val < root.val) {
            root = searchBST(root.left, val);
        } else if (val > root.val) {
            root = searchBST(root.right, val);
        }        
        
        return root;
    }
}