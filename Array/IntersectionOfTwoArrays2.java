/**
 * using 2 maps
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int count1 = map1.get(key);
                int count2 = map2.get(key);
                int count = Math.min(count1, count2);
                for (int i = 0; i < count; i++) {
                    list.add(key);
                }
            }
        }
        
        System.out.println(list);
        
        int[] result = new int[list.size()];
        int index = 0;
        for (int num : list) {
            result[index] = num;
            index++;
        }
        
        return result;
    }
}
// -------------------------------------------------
/**
 * FACEBOOK followup: if arrays be sorted
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] result = new int[list.size()];
        int index = 0;
        for (int num : list) {
            result[index] = num;
            index++;
        }
        
        return result;
    }
}