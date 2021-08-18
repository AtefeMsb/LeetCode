class Solution {
    public int longestConsecutive(int[] nums) {
        
        // for O(1) lookup use set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int longestStreak = 0;
        
        // check if each num is the begining of a new sequence
        for (int num : nums) {
            // if the immediate left number doesn't exist, this is a new sequence
            if (!set.contains(num - 1)) {
                int currentStart = num;
                int currentStreak = 1;
                
                // find out as much consequtive number possible from the list
                while (set.contains(currentStart + 1)) {
                    currentStart += 1;
                    currentStreak += 1;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);  
            }
        }
        
        return longestStreak;  
    }
}