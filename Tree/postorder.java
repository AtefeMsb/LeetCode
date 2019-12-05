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

    // manipulating the result
    // Iterative push to the begining of array
    // this will result shifting after each push.
    public List<Integer> postorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack();
        List<Integer> results = new ArrayList<>();
        
        if (root == null) {
          return results;
        }

        stack.add(root);
        
        // how we traverse:         top to bottom && left to right
        // what post order wants:   bottom to top && left to right
        while (!stack.isEmpty()) {
            
          TreeNode node = stack.pop();
          results.add(0, node.val);
            
          if (node.left != null) {
            stack.add(node.left);
          }
            
          if (node.right != null) {
            stack.add(node.right);
          }
        }
        return results;
    }

// iterative using set and stack
public List<Integer> postorderTraversal(TreeNode root) {
        
        // one set - one stack
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
    
