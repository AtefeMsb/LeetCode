class Solution {
    /**
     * findSuccesor - Helper function for finding successor
     * In BST, succesor of root is the leftmost child in root's right subtree
     */
    private TreeNode findSuccessor(TreeNode root) {
        root = root.right;
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if (root == null) {
            return root;
        }
        else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        
        // found the node with key val
        else {
            // case 1: No child
            if (root.left == null && root.right == null) {
                root = null;
                return root;
            }

            // case 2: One child
            else if (root.left == null) {
                 return root.right;
            }

            else if (root.right == null) {
                 return root.left;
            }

            // case 3: two children
            // replace root with its successor if root has two children
            TreeNode newNode = findSuccessor(root);
            root.val = newNode.val;
            root.right = deleteNode(root.right, newNode.val);
        }
        
        return root; 
    }
}
