/**
 * using hashmap
 * time complexity: O(n)
 * space complexity: O(n)
 */
class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        // update the frequency map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int limit = nums.length / 2;
        
        // check which frequency is bigger than limit
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > limit) {
                return entry.getKey();
            }
        }
        
        return -1;
    }
}

/**
 *  Boyer-Moore Voting Algorithm
 * time complexity: O(n)
 * space complexity: O(1)
 */
class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        Integer candidate = null;
        
        for (int num : nums) {
            // if count is zero, pick the current as new candidate
            if (count == 0) {
                candidate = num;
            }
            
            // if the cur equal the current candidate, add one to count
            count += (num == candidate) ? 1 : -1;
        }
        
        return candidate; 
    }
}

// ----------------------------------------------
class Solution {
    public int majorityElement(int[] nums) {
        
        int result = 0;
        int count = 0;
        
        for (int num : nums) {
            if (count == 0) result = num;
            
            if (num == result) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        
        return result;  
    }
}