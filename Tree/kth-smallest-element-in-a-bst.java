 // recursive
    public int kthSmallest(TreeNode root, int k) {
        // [0]: result, [1]: how many item so far been visited by inorder
        int[] nums = new int[2];
        inorderFindKthSmallest(root, k, nums);
        return nums[1];
    }
    
    // modified inorder traversal that returns when it reach to the kth element
    private void inorderFindKthSmallest(TreeNode root, int k, int[] nums) {
        if (root == null) {
            return;
        }
        
        inorderFindKthSmallest(root.left, k, nums);
        // process the node
        if (++nums[0] == k) {
            // update nums[1] because it holds our kth smallest value
            nums[1] = root.val;
            // no need to traverse further
            return;
        }
        inorderFindKthSmallest(root.right, k, nums);
    }
    //-----------------------------------------------------------------
    // iterative
    
    public int kthSmallest(TreeNode root, int k) {
        return inorderTraversal(root, k);
    }
    
    private int inorderTraversal(TreeNode root, int k) {
        // [0]: result, [1]: how many item so far been visited by inorder
        int[] result = new int[2];
        Stack<TreeNode> stack = new Stack();

        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {

            // see all the lefts - push all left nodes to stack
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // current is NULL
            cur = stack.pop();
            ++result[0];
            if (result[0] == k) {
                result[1] = cur.val;
                break;
            }
            cur = cur.right;
    }

    return result[1];
    }
