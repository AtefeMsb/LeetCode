// Recursive
    // https://www.youtube.com/watch?v=yEwSGhSsT0U
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer lowerBound, Integer upperBound) {
        
        if (root == null) {
            return true;
        }
        
        if (lowerBound != null && root.val <= lowerBound) return false;
        if (upperBound != null && root.val >= upperBound) return false;
            
        return ( helper(root.left, lowerBound, root.val) &&
                 helper(root.right, root.val , upperBound));
    }
    // -------------------------------------------------------------
    
    // iterative - inorder
    class Solution {
        public boolean isValidBST(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            Integer prev = null;
    
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // If next element in inorder traversal
                // is smaller than the previous one
                // that's not BST.
                if (prev != null && root.val <= prev) {
                    return false;
                }
                prev = root.val;
                root = root.right;
            }
            return true;
        }
    }
///////////////////////////////////////////////////////////////////
// recursive - inorder
class Solution2 {
    // We use Integer instead of int as it supports a null value.
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}