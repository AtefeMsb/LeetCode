class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // print the map
        // map.forEach((key, value) -> System.out.println(key + ":" + value));
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
// -----------------------------------------------
/**
 * Using XOR
 
A	B	A XOR B
---------------
0	0	0
0	1	1
1	0	1
1	1	0

- If we take XOR of zero and some bit, it will return that bit
- If we take XOR of two same bits, it will return 0

*/
class Solution {
    public int singleNumber(int[] nums) {
        
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }
}