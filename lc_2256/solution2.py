import sys
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
        
        # the minimum ave diff
        mini = sys.maxint
        # the index of the minimum average difference
        index = -1
        # absolute difference
        abs_diff = sys.maxint
        
        # outer loop traverse elements nums[0] to nums[n-2]
        for i in range(n):
            first_sum += nums[i]
            # the average of the first sublist
            ave_first = first_sum/(i+1)
            
            # the sum of the last sublist
            last_sum = sum_all - first_sum
            # the average of the last sublist
            if i < n-1:
                ave_last = last_sum/(n-(i+1))
            else:
                ave_last = 0
            
            # absolute difference
            abs_diff = abs(ave_first - ave_last)
            if abs_diff < mini:
                mini = abs_diff
                index = i
                
        return index
        
