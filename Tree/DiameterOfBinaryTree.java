package Tree;

/**
 * DFS
 * Time Complexity: O(n)
 * Space Complexity: O(n) - The space complexity depends on the size of our implicit call stack during our DFS, which relates to the height of the tree.
 * In the worst case, the tree is skewed so the height of the tree is O(N). If the tree is balanced, it'd be O(logN).


 */
class Solution {
    
    // is the the maximum depth
    int diameter;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        diameter = 0;
        maxDepth(root);
        return diameter;
        
    }
    
    // dfs
    private int maxDepth(TreeNode root) {
        
        // base case
        if (root == null) {
            return 0;
        }
        // recursively find the longest path in
        // both left child and right child
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // update the diameter if leftDepth plus rightDepth is larger
        diameter = Math.max(diameter, leftDepth+rightDepth);
        
        // return the longest one between leftDepth and rightDepth
        // remember to add 1 for the path connecting the node and its parent
        return Math.max(leftDepth, rightDepth) + 1;
        
        
    }
}
