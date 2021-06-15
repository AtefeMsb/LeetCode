/**
 * no limitation of space 
 */
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
//--------------------------------------------------------------
/** FACEBOOK version
 * Arrays are sorted
 * space complexity must be O(1)
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while (i < nums2.length && j < nums1.length) {
            
            // skip the duplicates
            while (i > 0 && i < nums2.length && nums2[i] == nums2[i - 1]) {
                i++;
            }
             while (j > 0 && j < nums1.length && nums1[j] == nums1[j - 1]) {
                j++;
            }
            
            if (i < nums2.length && j < nums1.length) {
                int n = nums2[i];
                int m = nums1[j];
                
                if (m == n) {
                    list.add(n);
                    i++;
                    j++;
                }
                else if (m > n) i++;
                else j++;
            }
        }
        
        // convert list result to array result
        int[] result = new int[list.size()];
        int index = 0;
        for (int num : list) {
            result[index] = num;
            index++;
        }
        return result;
    }
}