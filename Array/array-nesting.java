// use of visited array to avoid traversing duplicate sequences.
public class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        // since nesting is forming a cycle, this array help to avoid already seen cycles.
        boolean[] visited = new boolean[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i];
                int count = 0;
                do {
                    start = nums[start];
                    count++;
                    // any visited index will be marked as visited, to avoid traversing duplicate sequences again and again.
                    visited[start] = true;
                }
                // when start is equal nums[i] means we are at the starting point position again
                // after this be repetition of the same sequence, so this is the termination point
                while (start != nums[i]);
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
