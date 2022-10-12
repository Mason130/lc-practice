class Solution {
    public int numDistinct(String s, String t) {
        char[] T = t.toCharArray(), S = s.toCharArray();
        int r = T.length, c = S.length;
        int[][] dp = new int[r+1][c+1];
        Arrays.fill(dp[0], 1);
        
        for(int i=1; i<r+1; i++){
            for(int j=1; j<c+1; j++){
                if(T[i-1] == S[j-1])
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                else
                    dp[i][j] = dp[i][j-1];
            }
        }
        
        return dp[r][c];
    }
}
