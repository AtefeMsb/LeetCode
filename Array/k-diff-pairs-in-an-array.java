// using TWO Set
// works for SORTED array
class Solution {
    public int findPairs(int[] nums, int k) {
        
        Arrays.sort(nums);
        Set<Integer> seenNumbers = new HashSet<>();
        Set<String> seenPairs = new HashSet<>();
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - k;
            System.out.println(nums[i]);
            System.out.println("diff: " + diff);
            // already seen the diffrence and havent seen the pair yet
            if (seenNumbers.contains(diff) && !seenPairs.contains(diff + "," + nums[i])) {
                count++;
                seenPairs.add(diff + "," + nums[i]);
                System.out.println(diff + "," + nums[i]);
               
            }
            seenNumbers.add(nums[i]); 
             System.out.println("*************");
        }
        return count;
    }
}
