// Time Complexity: O(nlogn)
// Space Complexity: O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        
        // sort the list based on the first element (begining of the interval)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // merged output
        LinkedList<int[]> merged = new LinkedList<>();
        
        for (int[] interval: intervals) {
            
            // the output is empty OR the new interval is not overlapping with the last interval, simply append it
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
                // otherwise, there is an overlap, merge the current and previous intervals by updating the last interval in the list
            } else {
                merged.getLast()[1] = Math.max(interval[1], merged.getLast()[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
        
    }
}

// -----------------------------------------------------------
class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.getLast();
            int[] cur = intervals[i];
            
            // overlap
            if (cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]);
            // non overlap
            } else {
                merged.add(cur);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }    
}