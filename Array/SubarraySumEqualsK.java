// idea is similar to two-sum
// create a sum hashmap, any time add one item to hashmap check to see if the (diffrence between current sum and k) exists in the map.
public class Solution {
    public int subarraySum(int[] nums, int k) {

        int sum = 0;
        int result = 0;
        // key: cumulative sum     value: how many times we seen it
        Map<Integer, Integer> sumFrequency = new HashMap();
        // start by adding sum of zero 
        // sum of zero has been seen once 
        sumFrequency.put(0, 1);
       
        for (int i = 0; i < nums.length; i++) {
            // add to the cumulative sum till now
            sum += nums[i];
            
            // if the diffrence between sum till now and value exists in the map
            // it means that a subarray of sum has been found 
            if (sumFrequency.containsKey(sum - k)) {
                result += sumFrequency.get(sum - k);
            }
            
            sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}
