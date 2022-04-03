class Solution {
    public String customSortString(String order, String s) {
        
        Map<Character, Integer> mapS = new HashMap<>();
        for (char c : s.toCharArray()) {
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }
        
        // characters that exist in both s and order
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (mapS.containsKey(c)) {
                int repeat = mapS.get(c);
                for (int i = 0; i < repeat; i++) {
                    sb.append(c);
                }
                
                mapS.remove(c);
            } 
        }
        
        // characters that only exist in s
        for (char c : mapS.keySet()) {
            int repeat = mapS.get(c);
            for (int i = 0; i < repeat; i++) {
                sb.append(c);
            }
        }
        
        
        return sb.toString();
        
    }
}