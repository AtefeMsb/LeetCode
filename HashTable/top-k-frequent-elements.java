class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        
        // key: num     value: frequency
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // bucket keys based on their frequencies - ex: keys with frequency 5 will be store in INDEX 5.
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        
        // start from the end of bucket array and add top k frequent keys to the results
        int size = bucket.length;
        for (int i = size - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        
        return result;
    }
}
