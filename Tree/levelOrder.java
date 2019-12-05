    // Iterative using queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) {return result;}
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            
            List<Integer> currentLevel = new ArrayList<>();
            // number of elements in the current level
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                
                TreeNode cur = queue.poll();
                currentLevel.add(cur.val);
                
                // add child nodes of the current level
                // in the queue for the next level
                if (cur.left != null) {queue.offer(cur.left);}
                if (cur.right != null) {queue.offer(cur.right);}
            }
        
            result.add(currentLevel);
            
        }
        
        return result;
    }
