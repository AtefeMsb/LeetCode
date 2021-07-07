/**
 * using hashmap and key is sorted version of the string
 * time: O(n*k*logk) n:length of input array, k:max length of string
 * space: O(n*k)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // store diffrent group of anagrams
        // key: sorted string,   value: list of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        // 1. create a map of anagrams
        for (String str : strs) {
            String sorted = sortString(str);
            
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                map.put(sorted, new ArrayList<String>());
                map.get(sorted).add(str);
            }
        }
        
        // 2. assemble the result
        List<List<String>> result = new ArrayList<>();
        for (List list : map.values()) {
            result.add(list);
        }
        
        return result;
    }
    
    // sort each string
    private String sortString(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr); 
    }
}
// ------------------------------------------------
/**
 * using hashmap and key is the number of occurance of each letter
 * time: O(n*k + n*a) a: size of the charset
 * space: O(n*k + n*a)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]);
                sb.append('#');
            }
            
            String key = sb.toString();
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values()); 
    }
}