class Solution(object):
    def secondsToRemoveOccurrences(self, s):
        """
        :type s: str
        :rtype: int
        """
        ## brute force
        #ret = 0
        #while "01" in s:
            #s = s.replace("01", "10")
            #ret += 1
        #return ret
        
        ## DP
        dp = 0
        num_zero = 0
        N = len(s)
        for i in range(N):
            if s[i] == '0':
                num_zero += 1
            else:
                if num_zero > 0:
                    dp += 1
                    dp = max(dp, num_zero)
        
        return dp     
        
