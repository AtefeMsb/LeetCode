// calculate slope for the first two lines
// slopes between all the lines MUST be equal for the line to be considered straight
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        if (coordinates.length == 2) {
            return true;
        }
        
        boolean isStraight = true;
           
        double slope = calculateSlope(coordinates[0], coordinates[1]);
        
        System.out.println(slope);
        for (int i = 2; i < coordinates.length; i++) {
           
            if (calculateSlope(coordinates[i - 1], coordinates[i]) != slope) {
                isStraight = false;
                break;
            } 
           
        }

        return isStraight;
    }
    
    public double calculateSlope(int[] p1, int[] p2) {
        return Math.abs((double)(p2[1] - p1[1]) / (p2[0] - p1[0]));
        
    }
}
