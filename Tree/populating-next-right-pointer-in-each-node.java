  /**
   * bfs - iterative
   * time: O(n)
   */
  public Node connect(Node root) {


      if (root == null) {return null;}
      Queue<Node> queue = new LinkedList<>();
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
 
 //---------------------------------------------------------------------------------------------
 
  // Using previously established next pointers
  public Node connect(Node root) {

      if (root == null) {
          return root;
      }

      // Start with the root node. There are no next pointers
      // that need to be set up on the first level
      Node leftmost = root;

      // Once we reach the final level, we are done
      while (leftmost.left != null) {

          // Iterate the "linked list" starting from the head
          // node and using the next pointers, establish the 
          // corresponding links for the next level
          Node head = leftmost;

          while (head != null) {

              // CONNECTION 1 - establish the next pointers between the two children of a given node.
              head.left.next = head.right;

              // CONNECTION 2 - set-up the correct pointers between nodes which have a different parent
              if (head.next != null) {
                  head.right.next = head.next.left;
              }

              // Progress along the list (nodes on the current level)
              head = head.next;
          }

          // Move onto the next level
          leftmost = leftmost.left;
      }
      return root;
  }
