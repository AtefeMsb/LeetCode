    // iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> stack = new ArrayDeque();
        
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            
            // see all the lefts - push all left nodes to stack
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // current is NULL
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        
        return result;
    } 
    // ---------------------------------------------------------
     // recursive
    private void inorderTraversal(TreeNode root, List result) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
