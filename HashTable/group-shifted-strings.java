class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        List<List<String>> shiftedGroups = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        // key must be String with some delimiter, since if we just go with integer, strings 
        // like bb and b will be pushesh into the same groups
        for (String str : strings) {
            String key = "";
            for (int i = 1; i < str.length(); i++) {
                int diff = str.charAt(i) - str.charAt(i - 1);
                key += (diff < 0) ? diff + 26 : diff;
                key += ",";
            }
             
            // for the first time key gets added to the map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            
            map.get(key).add(str);
        }
        
        shiftedGroups.addAll(map.values());
        return shiftedGroups;    
    }
}
