class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            // if value already exist in the map
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            // update the map
            map.put(nums[i], i);
        }
        return false;
    }

    /*
It iterates over the array using a sliding window. The front of the window is at i,
the rear of the window is k steps back. The elements within that window are maintained using a Set.
While adding new element to the set, if add() returns false, it means the element already exists in the set.
At that point, we return true. If the control reaches out of for loop, it means that inner return true never executed,
meaning no such duplicate element was found.
*/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
            
        // Set is holding only k elements (sliding window of size at most k)
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            if (set.contains(nums[i])) {
                return true;
            }
            
            set.add(nums[i]);
            
            // remove the oldest element, keep the set only containg less than k element
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        
        return false;
    }

}


