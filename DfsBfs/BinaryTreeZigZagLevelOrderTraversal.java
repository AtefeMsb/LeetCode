package DfsBfs;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        int levelNumber = 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevelValues = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                currentLevelValues.add(cur.val);
                
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            
            // odd level numbers
            if (levelNumber % 2 != 0) { 
                Collections.reverse(currentLevelValues);
            }
            
            result.add(currentLevelValues);
            levelNumber++;
        }
        
        return result;
    }
}
