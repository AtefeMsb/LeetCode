class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        LinkedList<int[]> list = new LinkedList<>();
        
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            
            // less than
            if (newInterval[1] < interval[0]) {
                
                list.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }
                return list.toArray(new int[list.size()][]);
                
            // more than
            } else if (newInterval[0] > interval[1]) {
                
                list.add(interval);
                
            // overlap
            } else {
                
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                
            }
               
        }
        
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
        
    }
}