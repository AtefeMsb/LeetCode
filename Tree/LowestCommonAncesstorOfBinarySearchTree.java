package Tree;

// recursive
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // if p and q both in left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        // if p and q both in right subtree
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
        // we have found the split point or the LCA node
            return root;
        }
    }
}
///////////////////////////////////////////////////
// iterative
class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while (root != null) {
            // If both p and q are smaller than parent
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            // If both p and q are greater than parent
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            // We have found the split point, i.e. the LCA node.
            } else {
                return root;
            }
        }
        
        return null;
    }
}