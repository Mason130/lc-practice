class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        
        // dp[i][j] is the length of rectangle ended with matrix[i][j] in each row
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if (j == 0)
                    dp[i][j] = matrix[i][j] - '0';
                else{
                    if (matrix[i][j] == '1')
                        dp[i][j] = dp[i][j-1] + 1;
                    else
                        dp[i][j] = 0;
                }
            }
        }
        
        int ret = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if (matrix[i][j] == '1'){
                    int l = Integer.MAX_VALUE;
                    for(int k=i; k>=0; k--){
                        if(matrix[k][j] == '0')
                            break;
                        else{
                            l = Math.min(l, dp[k][j]);
                            int w = i - k + 1; // the width of rectangle
                            ret = Math.max(ret, l*w);
                        }
                    }
                }
            }
        }
        
        return ret;
    }
}
