package BST;

// recursive
class SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        
        if (root == null || val == root.val) return root;
  
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
  }

  //////////////////////////////////////

  // iterative
  class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null && val != root.val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
  }