package Tree;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        // TreeSet is a height-balanced BST.
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            // The ceiling() method of java.util.TreeSet<E> class is used to return the least element
            // in this set greater than or equal to the given element, or null if there is no such element
            Long s = set.ceiling((long) nums[i]);
            if (s != null && s - nums[i] <= t) return true;

            // Find the predecessor of current element
            Long g = set.floor((long) nums[i]);
            if (g != null && nums[i] - g <= t) return true;

            set.add((long) nums[i]);
            // maintain the size k set
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
        
    }
}