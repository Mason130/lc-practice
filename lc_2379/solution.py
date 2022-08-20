class Solution(object):
    def minimumRecolors(self, blocks, k):
        """
        :type blocks: str
        :type k: int
        :rtype: int
        """
        
        ## sliding window
        n = len(blocks)
        ret = n
        
        for i in range(n):
            # number of 'W's within the window of length k
            num_w = 0
            if i + k > n:
                break
            for j in range(i, i + k):
                if blocks[j] == 'W':
                    num_w += 1
            ret = min(ret, num_w)
            
        return ret
