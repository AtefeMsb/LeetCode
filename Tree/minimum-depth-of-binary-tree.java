    // bfs
    // We iterate the tree level by level,
    // and the first leaf we reach corresponds to the minimum depth.
    
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) {
            return 0;
        }
        
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            level++;
                
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                
                // first leaf you hit that is the min depth
                if (cur.left == null && cur.right == null) {
                    return level;
                }
                if (cur.left != null) {queue.offer(cur.left);}
                if (cur.right != null) {queue.offer(cur.right);}
            }
        }
        return level;
    }
    
//-----------------------------------------------------------------------------------------------------

    // recursive
    public int minDepth(TreeNode root) {
        
      if (root == null) {return 0;}
      if (root.left == null) {return minDepth(root.right) +1;}
      if (root.right == null) {return minDepth(root.left)+1;}
      return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }

//-----------------------------------------------------------------------------------------------------

    // recursive - using helper function
    public int minDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return helper(root);
    }

    public int helper(TreeNode root) {
        
    if (root == null){
        return Integer.MAX_VALUE;
    }
        
    if (root.left == null && root.right == null){
        return 1;
    }

    int depthLeft = helper(root.left);
    int depthRight = helper(root.right);

    return Math.min(depthLeft, depthRight) + 1;
        
    }

//-----------------------------------------------------------------------------------------------------
    
    // dfs - preorder - MUST visit all the nodes
    // The idea is to visit each leaf with the DFS strategy, while updating the minimum depth
    // when we reach the leaf node.
    
    import javafx.util.Pair;
    public int minDepth(TreeNode root) {
        
        // pair <Node, depth>
        Stack<Pair<TreeNode, Integer>> stack = new Stack();
        if (root == null) {
          return 0;
        } else {
          stack.add(new Pair(root, 1));
        }

        int min_depth = Integer.MAX_VALUE;
        
        while (!stack.isEmpty()) {
            
            Pair<TreeNode, Integer> current = stack.pop();
            root = current.getKey();
            int current_depth = current.getValue();
            
            // The minimum depth is updated at each leaf node
            if ((root.left == null) && (root.right == null)) {
                min_depth = Math.min(min_depth, current_depth);
            }
            if (root.left != null) {
                stack.add(new Pair(root.left, current_depth + 1));
            }
            if (root.right != null) {
                stack.add(new Pair(root.right, current_depth + 1));
            }
            
        }
        
        return min_depth;
  }
