class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        // put the whole nums1 in a set
        Set<Integer> setNum1 = new HashSet<>();
        for (int num : nums1) {
            setNum1.add(num);
        }
        
        // compare each element of nums 2 with setNums1 to find intersections
        Set<Integer> intersection = new HashSet<>();
        for (int num : nums2) {
            if (setNum1.contains(num)) {
                intersection.add(num);
            }
        }
        
        // prepare the result
        int[] result = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) {
            result[index++] = num;
        }
        
        return result;
    }
}
