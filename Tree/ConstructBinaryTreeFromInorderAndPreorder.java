package Tree;

class Solution {
    int[] preorder;
    int[] inorder;
    int preorderIndex;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        
        this.inorder = inorder;
        this.preorder = preorder;
        preorderIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return helper(0, inorder.length - 1);
    }
    
    private TreeNode helper(int inorderLeftIndex, int inorderRightIndex) {
        
        // base case
        if (inorderLeftIndex > inorderRightIndex) {
            return null;
        }
        
        int rootVal = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootVal);
        
        // find the index that splits the inorder
        int index = inorderMap.get(rootVal);
        
        // recursion
        preorderIndex++;
        
        // create left subtree
        root.left = helper(inorderLeftIndex, index - 1);
        // create right subtree
        root.right = helper(index + 1, inorderRightIndex);
        
        // return root
        return root;
     
    }
}