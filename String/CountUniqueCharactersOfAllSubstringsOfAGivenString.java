/*
intuition: for each character the number of times it is unique in substring are calculated by
XAXX -> left:2 -- right: 3 --> total: 2 * 3 = 6
*/
class Solution {
    public int uniqueLetterString(String s) {
        
        int sum = 0;
        
        // find all the occurence of each character in teh string
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        
        for (List<Integer> list : map.values()) {
            for (int i = 0; i < list.size(); i++) {
                
                // if its the first occurence of a character
                int left = (i == 0) ? list.get(i) + 1 : list.get(i) - list.get(i - 1);
                // if its the last occurence of a character
                int right = (i == list.size() - 1) ? s.length() - list.get(i) : list.get(i + 1) - list.get(i);
                
                sum += left * right;
            }
            
            
        }
        
        return sum;
    }
}