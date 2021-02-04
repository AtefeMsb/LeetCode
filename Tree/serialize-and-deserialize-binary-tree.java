// using BFS to traverse
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder tree = new StringBuilder();
        
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            
            if (cur == null) {
                tree.append("null,");
                continue;
            }
            tree.append(cur.val);
            tree.append(",");
            
            // even null nodes gets push in the queue
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return tree.toString();
    }

    public TreeNode deserialize(String data) {
        
        if (data == "") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        
        for (int i = 1; i < values.length; i++) {
            
            TreeNode parent = queue.poll();
            
            // i
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            
            // i + 1
            if (!values[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
