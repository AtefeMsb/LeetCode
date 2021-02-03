package Tree;

class Solution {
    int[] inorder;
    int[] postorder;
    int postIndex;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
           return null; 
        }
		
        this.inorder = inorder;
        this.postorder = postorder;
        // start from last postorder element
        postIndex = this.postorder.length - 1;
        // build a hashmap for inorder (key:element  , value:index)
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1);
        
    }
    
    private TreeNode helper(int inorderLeftIndex, int inorderRightIndex) {
        
       // if there is no elements to construct subtree
        if (inorderLeftIndex > inorderRightIndex) {
            return null;
        }
        
        // choose postIndex element as a root
        int rootVal = postorder[postIndex];
        // create a root node
        TreeNode root = new TreeNode(rootVal);
        
        // root splits inorder list into left and right subtrees
        int index = inorderMap.get(rootVal);
        
        // recursion
        postIndex--;
        
        // build Right subtree
        root.right = helper(index + 1, inorderRightIndex);
        // build LEFT subtree
        root.left = helper(inorderLeftIndex, index - 1);
        
        // return this step root
        return root;

    }
       
}