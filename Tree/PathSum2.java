package Tree;

/**
 * recursive
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<Integer>(), paths);
        return paths;
    }
    
    private void findPaths(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> paths) {
        
        if (root == null) return;
        
        current.add(root.val);
        
        // if hit a leaf that has also sum value of ZERO, we found one answer
        if (root.val == targetSum && root.left == null && root.right == null) {
            paths.add(current);
            return;
        }
        
        // recurse for left node and right node, with new copy of current list
        findPaths(root.left, targetSum - root.val, new ArrayList<Integer>(current), paths);
        findPaths(root.right, targetSum - root.val, new ArrayList<Integer>(current), paths);
    }
}
