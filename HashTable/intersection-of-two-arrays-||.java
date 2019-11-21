class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        List<Integer> listResult = new ArrayList<>();
        
        // convert one of the arrays to map
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        
        for (int i : nums2) {
            if (map1.get(i) != null && map1.get(i) > 0) {
                listResult.add(i);
                map1.put(i, map1.get(i) - 1);
            }
        }
        
       // convert list<Inetegr> to int[]
        int[] arrResult = new int[listResult.size()];
        for (int i = 0; i < listResult.size(); i++) {
            arrResult[i] = listResult.get(i);
        }
        
        return arrResult;
    }
}
