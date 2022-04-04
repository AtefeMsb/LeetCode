class Solution {
    public boolean isCompleteTree(TreeNode root) {
        
        if (root == null) return false;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();

                // the first null node encounter, means all the nodes after MUST be NULL
                if (cur == null) {
                    
                    flag = true;
                    
                } else if (cur != null) {
                    
                    // if we saw not null node while flag is true
                    if (flag == true) {
                        return false;
                    } 

                    queue.add(cur.left);
                    queue.add(cur.right);
                    
                }
            }
        }
        
        return true;
    }
}