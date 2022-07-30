class Solution(object):
    def getDescentPeriods(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        #### approach 1
        ## sliding window approach
        ret = 1
        # start index
        s = 0
        
        for i in range(1, len(prices)):
            # one day is a smooth descent period by the definition
            ret += 1
            if prices[i] == prices[i-1] - 1:
                # new periods that consists of at least 2 days is (i-s)
                ret += (i - s)
            # update start index
            else:
                s = i 
        
        return ret


