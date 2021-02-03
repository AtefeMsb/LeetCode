package Tree;

class Solution {
    public Node connect(Node root) {

        if (root == null) {return null;}
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                // pop the node
                Node cur = queue.poll();

                // if more elements left from this level
                if (i < size - 1) {
                    cur.next = queue.peek();
                }
                
                // set the left and right child
                if (cur.left != null) {queue.offer(cur.left);}
                if (cur.right != null) {queue.offer(cur.right);}
                }

            }

        return root;   
    }
}