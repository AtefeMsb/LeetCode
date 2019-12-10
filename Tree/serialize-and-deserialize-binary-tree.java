public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder tree = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null)  return "";
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            
            if (cur == null) {
                tree.append("null,");
                continue;
            } 

            tree.append(cur.val);
            tree.append(",");               

            if (cur.left != null) { queue.offer(cur.left); }
            if (cur.right != null) { queue.offer(cur.right); }
        }
        
        return tree.toString();    
    }

    // using queue and bfs technique
      public TreeNode deserialize(String data) {
          if (data == "") return null;
          Queue<TreeNode> queue = new LinkedList<>();
          String[] values = data.split(",");
          
          TreeNode root = new TreeNode(Integer.parseInt(values[0]));
          
          // add original root to the queue
          queue.offer(root);
          
          // only not-null nodes gets added to queue
          // for each node removed from queue check two items from values
          for (int  i = 1; i < values.length; i++) {
              TreeNode cur = queue.poll();
              
              // check i
              if (!values[i].equals("null")) {
                  TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                  cur.left = left;
                  queue.offer(left);
              }
              
              // check i + 1
               if (!values[++i].equals("null")) {
                  TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                  cur.right = right;
                  queue.offer(right);
              }
          }
    
          return root;
    }
}
