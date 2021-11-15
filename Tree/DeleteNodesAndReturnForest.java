class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> remaining = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : to_delete) {
            set.add(num);
        }
        helper(root, set, remaining);
        // add the root itself
        if (!set.contains(root.val)) {
            remaining.add(root);
        }
        return remaining;
    }
    
    public TreeNode helper(TreeNode root, Set<Integer> set, List<TreeNode> remaining) {
        
        if (root == null) return null;
        
        root.left = helper(root.left, set, remaining);
        root.right = helper(root.right, set, remaining);
        
        // if it should be deleted
        if (set.contains(root.val)) {
            // before deleting check for children
            if (root.left != null) {remaining.add(root.left);}
            if (root.right != null) {remaining.add(root.right);}
            return null;
        }
        
        // if it should NOT be deleted
        return root;  
    }
}