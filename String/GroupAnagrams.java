/**
 * Categorize by Sorted String
 * hashmap: use the sorted string as the key
 * time: O(n * k * logk)
 * n: length of string array
 * k: maximum length of string
 * space: O(n * k)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // create key using sorted version of the word
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);
            // String key = Arrays.toString(charArr);
            
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            } else {
                map.get(key).add(str);
            }
        }
      
        return new ArrayList<>(map.values());
    }
}

// ------------------------------------------
/**
 * Categorize by Count
 * hashmap: use the character count as the key
 * time: O(n * k + n * 26)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // create key using count characters array
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26;i ++) {
                sb.append(count[i]);
                sb.append('#'); // dilimiter
            }
            
            String key = sb.toString();
            
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            } else {
                map.get(key).add(str);
            }
        }
      
        return new ArrayList<>(map.values());
    }
}