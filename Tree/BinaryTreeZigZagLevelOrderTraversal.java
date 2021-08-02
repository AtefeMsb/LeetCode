class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        
        while(!queue.isEmpty()) {
            
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                
                TreeNode cur = queue.poll();
                currentLevel.add(cur.val); 
                
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                
            }
            
            // for odd rows, reverse
            if (level % 2 != 0) {
                Collections.reverse(currentLevel);
            }
            
            result.add(currentLevel);
            level++;
            
        }
        
        return result;
        
    }
}