package DfsBfs;

class Solution {
    private int sum;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
    }
    
    private void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        // prunining happens when calling left and right
        if (root.val > low) {
            dfs(root.left, low, high);
        }
        if (root.val < high) {
            dfs(root.right, low, high);
        }
    }
}