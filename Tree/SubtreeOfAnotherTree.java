package Tree;

/**
* By Comparison of Nodes 
* Time complexity : O(m∗n)
* Space complexity : O(n)
*/
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // it is not possible to be subtree of a null tree
        if (s == null) return false;
        if (isSame(s, t)) return true;
        // chef left and right subtree to find the exact match
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        // both null is true but only one is a false
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}