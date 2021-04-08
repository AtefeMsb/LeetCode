package DfsBfs;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // if there is no work to do
        if (image[sr][sc] == newColor) return image;
        
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int color, int newColor) {
        
        // base case
        // if out of boundries or the color is the same as the starting color
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != color) {
            return;
        }
        
        image[i][j] = newColor;
        
        dfs(image, i + 1, j, color, newColor);
        dfs(image, i - 1, j, color, newColor);
        dfs(image, i, j + 1, color, newColor);
        dfs(image, i, j - 1, color, newColor);
            
    }
}