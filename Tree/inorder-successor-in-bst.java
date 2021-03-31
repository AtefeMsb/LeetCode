class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        // 1- If the node has a right child, go one step right and
        // then left till you can. Return the successor.
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p; 
        }
        
        // 2- Otherwise, implement iterative inorder traversal.
        // While there are still nodes in the tree or in the stack:
        Stack<TreeNode> stack = new Stack();
        int predecessor = Integer.MIN_VALUE;
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            // if the previous node was equal to p
            // then the current node is its successor
            if (predecessor == p.val) {
                return cur;
            }
            predecessor = cur.val;
            cur = cur.right;
        }
        
        // 3- If we're here that means the successor doesn't exit. Return null.
        return null;
    }
}

///////////////////////////////////////////////////////////
/**
Here is a much simpler solution to the problem. The idea is pretty straight forward.
We start from the root, utilizing the property of BST:

If current node's value is less than or equal to p's value, we know our answer must be in the right subtree.
If current node's value is greater than p's value, current node is a candidate. Go to its left subtree to see if we can find a smaller one.
If we reach null, our search is over, just return the candidate.
 */

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode successor = null;
        TreeNode cur = root;

        while (cur != null) {
            if (cur.val > p.val) {
                successor = cur;
                cur = cur.left;
            } else {
                // cur.val <= p.val
                cur = cur.right;
            }
        }

        return successor;
    }
}