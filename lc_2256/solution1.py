class Solution(object):
    def minimumAverageDifference(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # the length of list
        n = len(nums)
        # the sum of entire list
        sum_all = sum(nums)
        # the sum of the first sublist
        first_sum = 0
        
        # empty list to store each absolute difference 
        diff = []
        
        # outer loop traverse elements nums[0] to nums[n-2]
        for i in range(n-1):
            first_sum += nums[i]
            # the average of the first sublist
            ave_first = first_sum/(i+1)
            
            # the sum of the last sublist
            last_sum = sum_all - first_sum
            # the average of the last sublist
            ave_last = last_sum/(n-(i+1))          
            
            # absolute difference
            abs_diff = abs(ave_first - ave_last)
            diff.append(abs_diff)
        
        # the absolute difference of the last index (n-1)
        diff_n = sum_all/n
        diff.append(diff_n)
        
        # minimum average difference
        mini = min(diff)
        ret = diff.index(mini)
        
        return ret
        
