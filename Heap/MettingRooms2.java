/**
 * Intuition: we can keep all the rooms in a min heap where the key for the min heap would be the ending time of meeting.
 * time: O(nlog(n))
 * space: O(n)
 */

class Solution {
  public int minMeetingRooms(int[][] intervals) {
      
      // 1. Sort the given meetings by their start time
      Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
      
      // 2. Initialize a new min-heap and add the first meeting's ending time to the heap.
      // We simply need to keep track of the ending times as that tells us when a meeting room will get free.
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      minHeap.add(intervals[0][1]);
      
      // 3. For every meeting room check if the minimum element of the heap i.e. the room
      // at the top of the heap is free or not.
      // 4. If the room is free, then we extract the topmost element and
      // add it back with the ending time of the current meeting we are processing.
      // 5. If not, then we allocate a new room and add it to the heap.
      for (int i = 1; i < intervals.length; i++) {
          int currentMeetingStart = intervals[i][0];
          int earliestEndingTime = minHeap.peek();
          if (currentStart >= earliestEnding) {
              minHeap.poll();
          } 
          // if old room is alocated or new room assigned, anyway the earliest ending time must be updated.
          minHeap.add(intervals[i][1]);
      }
      
      // 6. After processing all the meetings, the size of the heap will tell us
      // the number of rooms allocated. This will be the minimum number of rooms needed 
      // to accommodate all the meetings.
      return minHeap.size();
  }
}