package DfsBfs;

class Solution {
    
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        postorder(root);
        return max;
    }
    
    // postorder traversal is used becaus it sees the node from the leaf (down to up)
    private int postorder(TreeNode root) {
        if (root == null) return 0;
        
        // return 0 instead of negative value
        int left = Math.max(postorder(root.left), 0);
        int right = Math.max(postorder(root.right), 0);
        
        // how much is the max path sum in this subtree (when root is the highest node)
        max = Math.max(max, left + root.val + right);
        
        // only return/pick one of the branches (left of right)
        return Math.max(left, right) + root.val;
    }
}