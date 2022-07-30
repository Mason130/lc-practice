class Solution(object):
    def getDescentPeriods(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        #### approach 1
        ## dp approach
        ret = 1
        dp = 1
        
        for i in range(1, len(prices)):
            if prices[i] == prices[i-1] - 1:
                dp += 1
            else:
                dp = 1
            ret += dp
            
        return ret
                
            
