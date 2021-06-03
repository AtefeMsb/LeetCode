/** updating the excisting tree
 * recursion
 * preorder
 * Time complexity : O(m). A total of m nodes need to be traversed. Here, m represents the minimum number of nodes from the two given trees.
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
        
    }
}

/**
 * creating a new tree
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        if (root1 == null && root2 == null) return null;
        
        int val1 = (root1 == null) ? 0 : root1.val;
        int val2 = (root2 == null) ? 0 : root2.val;
        
        TreeNode node = new TreeNode(val1 + val2);
        
        node.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        node.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        
        return node;
    }
}