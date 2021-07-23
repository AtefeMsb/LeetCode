/**
 * using hashmap
 * time: O(n ^ 2)
 */
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        // put the sum of all comibinations of nums1 and nums2 with their frequency in the map 
        for (int i : nums1) {
            for (int j : nums2) {
                int sum1 = i + j;
                map.put(sum1, map.getOrDefault(sum1, 0) + 1);
            }
        }
        
        // count the number of -(num3 + num4) that exist in the map
        for (int k : nums3) {
            for (int l : nums4) {
                int sum2 = k + l;
                count += map.getOrDefault(-(sum2), 0);
            }
        }
    
        return count;
    }
}