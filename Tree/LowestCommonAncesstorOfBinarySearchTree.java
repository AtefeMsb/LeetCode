package Tree;

// in this answer we are looking for spilit point

/**
 * recursive
 * time: O(n)
 * space: O(n) recursion stack
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // both p and q less than root
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // both p and q more than root
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // We have found the split point, i.e. the LCA node
        return root;
        
    }
}
// -------------------------------------------------------- 
/**
 * iterative
 * time: O(n)
 * space: O(1)
 */
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