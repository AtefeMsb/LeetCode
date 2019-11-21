class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        Map<String, Integer> map2 = new HashMap<>();
        List<String> result = new ArrayList<>();
  
        // put list 2 values and indeces in a map
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        
        // compare list1 elements against list2 map
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            String str = list1[i];
            
            if (map2.containsKey(str)) {
                int sum = i + map2.get(str);
                
                // start the result array all over
                if (sum < minSum) {
                    result.clear();
                    result.add(str);
                    minSum = sum;
                } else if (sum == minSum) {
                    result.add(str);
                }  
                
            }
        }
        
        String[] arr = new String[result.size()];
        arr = result.toArray(arr);
        
        return arr;
    }
}
