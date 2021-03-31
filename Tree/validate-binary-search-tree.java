// Recursive
    // https://www.youtube.com/watch?v=yEwSGhSsT0U
/*
* Recursive Traversal with Valid Range
* time complexity: O(n)
* space complexity: O(n)
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        // null indicates there is no minimum and maximum
        return validate(root, null, null);
    }
    
    private boolean validate(TreeNode root, Integer min, Integer max) {
        // null has no conflict in bst definition
        if (root == null) return true;
        
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        
        return validate(root.left, min, root.val) &&
               validate(root.right, root.val, max);   
    }
}
    // -------------------------------------------------------------
    /**
     * inorder - 
     * time complexity: O(n)
     * space complexity: O(n)
     */
    // iterative - inorder
    class Solution {
        public boolean isValidBST(TreeNode root) {
            
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode current = root;
            Integer prev = null;
            
            while (current != null || !stack.isEmpty()) {
                
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                
                // If next element in inorder traversal is smaller than the previous one that's not BST.
                current = stack.pop();
                if (prev != null && current.val <= prev) {
                    return false;
                }
                prev = current.val;
                current = current.right;
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