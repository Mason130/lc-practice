class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        l = len(cost)
        dp = [1000]*l
        
        for i in range(l):
            if i == 0:
                dp[i] = cost[i]
            elif i == 1:
                dp[i] = min(dp[0]+cost[1], cost[1])
            else:
                dp[i] = min(dp[i-1]+cost[i], dp[i-2]+cost[i])
            
        min_cost = min(dp[l-1], dp[l-2])
        return min_cost
    
