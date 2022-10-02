class Solution {
    public int maxSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int max = 0;
        
        for(int i=0; i<=r-3; i++){
            for(int j=1; j<c-1; j++){
                int sum = grid[i][j-1] + grid[i][j] + grid[i][j+1] + grid[i+1][j] + grid[i+2][j] + grid[i+2][j-1] + grid[i+2][j+1];
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
}
