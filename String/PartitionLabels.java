class Solution {
    public List<Integer> partitionLabels(String s) {
        // save the end occurance index of each character
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        
        List<Integer> list = new ArrayList<>();
        int end = 0;
        int size = 0;
        
        for (int i = 0; i < s.length(); i++) {
            size += 1;
            end = Math.max(end, map.get(s.charAt(i)));
            
            if (i == end) {
                list.add(size);
                size = 0;
            }     
        }
        
        return list;
    }
}