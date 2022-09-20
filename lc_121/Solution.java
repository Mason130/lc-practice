class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int temp = 0;
        
        for(int i=1; i<prices.length; i++){
            int profit = prices[i] - prices[i-1];
            temp += profit;
            if(temp<0)
                temp = 0;
            max = Math.max(max, temp);
            
        }
        
        return max;
    }
}
