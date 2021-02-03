 // BFS
 public int maxDepth(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) {
            return 0;
        }
        
        int level = 0;
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                
                TreeNode cur = queue.poll();
                if (cur.left != null) { queue.offer(cur.left); }
                if (cur.right != null) { queue.offer(cur.right); }
                
            }
            
            level++;
        }
        
        return level;    
    }
    
//-----------------------------------------------------------------------------------------------------

    // recursive - "Bottom-up" Solution - DFS - Movie theatre analogy
    public int maxDepth(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax , rightMax) + 1;
          
    }


/// OR
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }
    
//-----------------------------------------------------------------------------------------------------

    // recursive - "Top-down" Solution
    
     private int answer = 0;
    
    // recursive - top to bottom
    public int maxDepth(TreeNode root) {
        // depth of root is 1
        maximum_depth(root, 1);
        return answer;
    } 
    
    	
    
    private void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // leaf
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }
    
