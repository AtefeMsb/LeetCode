// NOTE: in the specific, the returned answers (both index1 and index2) are not zero-based. --> i + 1
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] result = new int[2];
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
            
            if (freqMap.containsKey(target - numbers[i])) {
                result[0] = freqMap.get(target - numbers[i]);
                result[1] = i + 1;
                break;
            }
            
            freqMap.put(numbers[i], i + 1);
        }
        
        return result;
    }
}
