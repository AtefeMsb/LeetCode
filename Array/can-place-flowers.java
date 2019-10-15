class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int count = 0;
        int l = flowerbed.length;
        for (int i = 0; i < flowerbed.length; i++) {
            
            // if spot is 0
            if (flowerbed[i] == 0 &&
                // the spot before is zero OR it is index 0
                (i == 0 || flowerbed[i - 1] == 0) &&
                // the spot after is zero OR it is last index
                (i == l - 1 || flowerbed[i + 1] == 0)) {
                count++;
                flowerbed[i] = 1;
            }
        }
        
        return (count >= n);
    }
}
