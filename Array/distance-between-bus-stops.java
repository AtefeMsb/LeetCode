class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        // distance if the bus moved in clockwise
        int clockwise = 0;
        
        // total distances in distance array
        int total = 0;
        for (int dis : distance) {
            total += dis;
        }
        
        // count distance of clockwise travel
        for (int i = 0; i < distance.length; i++) {
           // in case start is before destination
           if (start < destination && (i >= start && i < destination)) {
               clockwise += distance[i];
           }
           // in case start is after destination 
           if (start > destination && (i >= start || i < destination)) {
               clockwise += distance[i];
           }     
        }
   
        // return the minimum
        return Math.min(clockwise, total - clockwise);
    }
}
