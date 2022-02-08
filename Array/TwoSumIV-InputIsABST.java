// inorder traversal + two pointers
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        int left = 0;
        int right = list.size() - 1;
        
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            }
        }
        
        return false;
        
    }
    
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

// ---------------------------------------------------------
// using hashset
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }
    
    public boolean find(TreeNode root, int k, Set<Integer> set) {
        
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
        
    }
}