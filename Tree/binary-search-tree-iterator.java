/*
// Approach 1: Flattening the BST
class BSTIterator {

    List<Integer> inorderList = null;
    int curIndex = -1;

    public BSTIterator(TreeNode root) {
        inorderList = new ArrayList<Integer>(); 
        inorder(root, inorderList);
    }
    
    // create arraylist with inorder traversal
    private void inorder(TreeNode root, List list) {
        
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            inorderList.add(cur.val);
            cur = cur.right;
        }        
    }
    
    
    // return the next smallest number
    public int next() {
        curIndex++;
        return inorderList.get(curIndex);
    }

    // return whether we have a next smallest number
    public boolean hasNext() {
        if (curIndex < inorderList.size() - 1) {
            return true;
        }
        return false;
    }
}

*/

// check the leetcode solution
// Approach 2: Controlled Recursion
class BSTIterator {

    Stack<TreeNode> stack = null;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        leftMostInorder(root);    
    }
    
    private void leftMostInorder(TreeNode root) {
        
        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        
        // Node at the top of the stack is the next smallest element
        TreeNode topmostNode = stack.pop();
        
        if (topmostNode.right != null) {
            leftMostInorder(topmostNode.right);
        }
        
        return topmostNode.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }
}
