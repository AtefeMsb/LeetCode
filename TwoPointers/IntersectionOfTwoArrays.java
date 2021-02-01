package TwoPointers;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }

         for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }
        
        int[] resultArr = new int[result.size()];
        int index = 0;
        
        for (int num : result) {
            resultArr[index] = num;
            index++;
        }

        return resultArr; 
    }
}