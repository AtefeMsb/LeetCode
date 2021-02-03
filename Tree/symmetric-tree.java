// BFS
    public boolean isSymmetric(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        // [] an empty will return true
        if (root == null) { 
            return true;
        }
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // odd number of nodes in a level
            if (size > 1 && size % 2 == 1) {
                return false;
            }
            
            // create the queue and list of nodes data in each level
            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                
                if (cur.left != null) { 
                    queue.offer(cur.left);
                    nodes.add(cur.left.val);
                } else {
                    nodes.add(-1);
                }
                
                if (cur.right != null) { 
                    queue.offer(cur.right);
                    nodes.add(cur.right.val);
                } else {
                    nodes.add(-1);
                }
            }
            
            // check if the level is symmetrical
            int i = 0; 
            int j = nodes.size() - 1;
            
            while (i < j) {
                if (nodes.get(i) == nodes.get(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
    
        }
        
        return true;
  
    }
    //------------------------------------------------------------------------------------------------------
        // recursive
    // Two trees are a mirror reflection of each other if:

        // - Their two roots have the same value.
        // - The right subtree of each tree is a mirror reflection
        //   of the left subtree of the other tree.
    
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
 
    }
    //------------------------------------------------------------------------------------------------------
        // iterative
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        
        return true;
    }
