// recursive
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
      if (root == null) return new TreeNode(val);
  
      // insert into the right subtree
      if (val > root.val) root.right = insertIntoBST(root.right, val);
      // insert into the left subtree
      else root.left = insertIntoBST(root.left, val);
      return root;
    }
  }

  // ----------------------------------------------------------------
  class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur = root;
        
        while (true) {
            
            if (val < cur.val) {
                
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                } else {
                    cur = cur.left;
                }
                
            } else if (val > cur.val) {
                
               if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                } else {
                    cur = cur.right;
                } 
            } 
        }
        
        return root;
    }
}