class Solution {
    public int numDecodings(String s) {
        int l = s.length();
        int[] dp = new int[l+1];
        
        if(s.charAt(0) == '0')
            return 0;
        
        dp[0] = 1;
        for(int i=1; i<=l; i++){
            if(s.charAt(i-1) != '0'){
                dp[i] = dp[i-1];
                
                if(i>1){
                    if(s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')
                        dp[i] += dp[i-2];
                }
            }
            else{
                if(s.charAt(i-2) != '1' && s.charAt(i-2) != '2' )
                    return 0;
                else
                    dp[i] = dp[i-2];
            }
        }
        
        return dp[l];
    }
}
