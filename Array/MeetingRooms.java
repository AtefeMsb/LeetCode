package Array;

class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        
        if (intervals.length <= 1) return true;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // compare each interval to the immediate next interval
        for (int i = 0; i < intervals.length - 1; i++) {
            // there is an overlap between two intervals
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        
        return true;  
    }
}