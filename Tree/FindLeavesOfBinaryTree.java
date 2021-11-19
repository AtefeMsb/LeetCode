class Solution {
  
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        return result;
    }
    
    private int dfs(TreeNode root) {
        
        // return -1 for null nodes
        if (root == null) {
            return -1;
        }
        
        // first calculate the height of the left and right children
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        
        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        
        if (result.size() == currHeight) {
            result.add(new ArrayList<>());
        }
        
        result.get(currHeight).add(root.val);
        
        return currHeight;
    }
}