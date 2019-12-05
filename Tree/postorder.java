    // one set - one stack
    public List<Integer> postorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack();
        Set<TreeNode> set = new HashSet<>();
        List<Integer> results = new ArrayList<>();
        
        if (root == null) {
            return results;
        }
        
        stack.push(root); 
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            
            if (!set.contains(cur)) {
                stack.push(cur);
                
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                
                if (cur.left != null) {
                    stack.push(cur.left);
                } 
                
                set.add(cur);
                
            } else {
                results.add(cur.val);
            }
        }
        return results;
    }
}

    // recursive
    private void postorderTraversal(TreeNode root, List result) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }
    
