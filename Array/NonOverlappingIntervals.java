class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int n = 0;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        // end of first interval
        int previousEnd = intervals[0][1];  
        
        for (int i = 1; i < intervals.length; i++) {
            // no overlap
            if (intervals[i][0] >= previousEnd) {
                
                previousEnd = intervals[i][1];
                
            // overlap: remove the one that ends earlier to minimize the risk of future overlaps
            } else {
                 
                n++;
                previousEnd = Math.min(previousEnd, intervals[i][1]);
                
            }
        }
      
        return n;
    }
}