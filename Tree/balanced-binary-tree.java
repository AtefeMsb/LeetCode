/**
 * Bottom-up recursion
 * time complexity: O(n)
 * space complexity: O(n)
 */
// since the height of a tree is always greater than or equal to 0
// we use -1 as a flag to indicate if the subtree is not balanced
class Solution {
    public boolean isBalanced(TreeNode root) {
    
        if (getHeight(root) == -1) {
            return false;
        }
        
        // else
        return true;
    }
    
    private int getHeight(TreeNode node) {
        
        if (node == null) return 0;
        
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        
        // left or right subtree is unbalanced or cur tree is unbalanced
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        
        // return the actual height
        return Math.max(left, right) + 1;
    }
}
///////////////////////////////////////////////////////////////
// top down 

class Solution {
    // calculate maximum depth of binary tree
    public int height(TreeNode root) {
       if (root == null) return 0;
       int left = height(root.left);
       int right = height(root.right);
       return Math.max(left, right) + 1;
   }
   
   public boolean isBalanced(TreeNode root) {
       if (root == null) return true;
       
       return Math.abs(height(root.left) - height(root.right)) < 2 
           && isBalanced(root.left)
           && isBalanced(root.right);
       
   }
}