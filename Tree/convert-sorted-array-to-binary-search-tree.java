
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        return constructTreeFromArray(nums, 0, nums.length - 1);  
    }
    
    private TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        
        // base cass
        if (left > right) {
            return null;
        }
        
        // find the middle index 
        // in case of even array, always left will be root here
        int mid = left + (right - left) / 2;
        
        TreeNode current = new TreeNode(nums[mid]);
        current.left = constructTreeFromArray(nums, left, mid - 1);
        current.right = constructTreeFromArray(nums, mid + 1, right);
        
        return current;
    }
}
