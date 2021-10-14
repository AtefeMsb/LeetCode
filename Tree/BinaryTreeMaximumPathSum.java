class Solution {
    // must be -infinity, for cases that tree is only made up negative values
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        postorder(root);
        return max;
    }
    
    // we want to start from bottom to top, to avoid duplicate work
    // dfs/postorder is botton top approach
    private int postorder(TreeNode root) {
        if (root == null) return 0;
        
        int leftMax = postorder(root.left);
        int rightMax = postorder(root.right);
        
        // we must bound the NEGATIVE values, because they don't add to path sum
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);
        
        // caculate max path sum WITH split
        max = Math.max(max, (leftMax + rightMax + root.val));
        
        // calculate return value WITHOUT split, because we can not have more than one branch
        return Math.max(leftMax, rightMax) + root.val;
    }
}