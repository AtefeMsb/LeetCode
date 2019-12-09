class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        
        // put inorder val and index in hashmap
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(inorder, 0, inorder.length-1,
                      postorder, 0, postorder.length-1,
                      map);
        
    }
    
    /*
    1- The post order array will give you the root, the last one.
    2-  With the root, you can go to the in order array, notice the traverse sequence: left, root, right.
       Then we know the left child array size, right child array size.
    3- With the size, we can then divide the post order array: left, right, root.
    */
    private TreeNode helper(int[] inorder, int iStart, int iEnd,
                            int[] postorder, int pStart, int pEnd, 
                            Map<Integer,Integer> map) {
        
        if (pStart > pEnd || iStart > iEnd) return null;
        
        // always the last element in postorder is the root
        TreeNode root = new TreeNode(postorder[pEnd]);
        
        // which index of inorder contains the root
        int index = map.get(root.val);
        
        // number of elements in the left subtree
        int numberOfLeft = index - iStart;
        
        TreeNode leftchild = helper(inorder, iStart, index - 1,
                                    postorder, pStart, pStart + numberOfLeft - 1,
                                    map);
        TreeNode rightchild = helper(inorder,index + 1, iEnd,
                                     postorder, pStart + numberOfLeft , pEnd - 1,
                                     map);
        
        root.left = leftchild;
        root.right = rightchild;
        
        return root;
        
    }
    
}
