class Solution {
    int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        // traverse the tree using dfs
        dfs(root, targetSum);
        return result;
    }
    
    public void dfs(TreeNode root, int sum) {
        if (root == null) return;
        // starting at each node, run a serach
        search(root, sum, 0);
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
    
    public void search(TreeNode root, int sum, int cur) {
        if (root == null) {
            return;
        }
        
        cur += root.val;
        if (cur == sum) {
            result++;
        }
        
        search(root.left, sum, cur);
        search(root.right, sum, cur);
        
    }
}