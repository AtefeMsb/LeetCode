class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer,Integer> freqmap = new HashMap<Integer,Integer>();
        int answer = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (freqmap.containsKey(nums[i])) {
                int count = freqmap.get(nums[i]);
                freqmap.put(nums[i], count + 1);
            } else {
                freqmap.put(nums[i], 1);
            }
            if (freqmap.get(nums[i]) > nums.length / 2) {
                answer = nums[i];
                break;
            }
        }

       return answer; 
        
    }
}
