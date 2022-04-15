class Solution {
    public String stringShift(String s, int[][] shift) {
        
        int n = s.length();
        
        for (int[] move : shift) {
            int dir = move[0];
            int count = move[1] % n;
            
            if (dir == 0) {
                s = s.substring(count) + s.substring(0, count);
            } else if (dir == 1) {
                s = s.substring(n - count) + s.substring(0, n - count);
            }
        }
        
        return s;
    }
}

// ------------------------------------------------------
class Solution {
    public String stringShift(String s, int[][] shift) {
        
        int n = s.length();
        int count = 0;
        for (int[] move : shift) {
            int dir = move[0];
            int iteration = move[1];
            if (dir == 0) {
                count -= iteration;
            } else {
                count += iteration;
            }
        }
        
        count = count % n;
        
        // left iteration
        if (count < 0) {
            count = Math.abs(count);
            s = s.substring(count) + s.substring(0, count);
            
        // right iteration
        } else {
            s = s.substring(n - count) + s.substring(0, n - count);
        }
       
        return s; 
    }
}