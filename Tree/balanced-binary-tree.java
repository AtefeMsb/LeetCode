// Bottom-up recursion

/*
Check if the child subtrees are balanced. If they are, use their heights to determine if the current subtree is balanced as well as to calculate the current subtree's height.
*/

/*
  We care about 2 things as our recursion goes upwards after bottoming out:
  - The node's height
  - Whether its left and right subtrees are balanced
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).balanced;
    }
    
    // object to save height and isBalanced properties for each node
    class NodeInfo {
        public int height;
        public boolean balanced;
        
        public NodeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        } 
    }
    
    private NodeInfo isBalancedHelper(TreeNode node) {
        
        // Base case, an empty subtree is balanced and has a height of -1 as we define it
        if (node == null) {
            return new NodeInfo(-1, true);
        }
        
        // Go deep into the left subtree and get a result back
        NodeInfo left = isBalancedHelper(node.left);
        // Left subtree is not balanced. Bubble up failure.
        if (!left.balanced) {
            return new NodeInfo(-1, false); 
        }
        
        
        NodeInfo right = isBalancedHelper(node.right);
        if (!right.balanced) {
            return new NodeInfo(-1, false); 
        }
        
        // Use the height obtained from the recursive calls to
        // determine if the current node is also balanced. 
        boolean subtreesAreBalanced = Math.abs(left.height - right.height) <= 1;
        int height = Math.max(left.height, right.height) + 1;

        return new NodeInfo(subtreesAreBalanced, height);
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