class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        Map<Character, List<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.putIfAbsent(c, new ArrayList<String>());
        }
        
        for (String word : words) {
            map.get(word.charAt(0)).add(word);
        }
        
        for (char c : s.toCharArray()) {
            
            List<String> list = map.get(c);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                // remove the first word from the list
                String word = list.remove(0);
                // if the length is 1, it will be empty string after
                if (word.length() == 1) {
                    
                    result++;
                    
                // length is more than 1 and we remove the first character and add the remaining to the correct bucket
                } else {
                    
                    map.get(word.charAt(1)).add(word.substring(1));
                    
                }
                
            }        
        }
        
        return result;
    }
}
