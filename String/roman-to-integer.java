// NOTE: Roman numerals are usually written LARGEST to SMALEST from LEFT to RIGHT. 
class Solution {
    public int romanToInt(String s) {
        
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        int intValue = 0;
        int len = s.length();

        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        // get the last character integer value 
        intValue = map.get(s.charAt(len - 1));
        
        // backward
        for (int i = len - 2; i >= 0; i--) {
            
            // compare each element to its right hand neighbor if > means they can be sum
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                intValue += map.get(s.charAt(i));
                // if smaller means that its value must be subtarcted from the sum so far
            } else {
                intValue -= map.get(s.charAt(i)); 
            }
            
        }
        return intValue;
    }
}
