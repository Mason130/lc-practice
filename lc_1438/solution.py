class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        ## sliding window
        # the max_abs = max_val - min_val, 
        # if max_abs of subarray <= limit, then any two elements of this subarray <= limit
        max_len = 0
        # the start index
        s=0
        max_q = []
        min_q = []
        
        for i in range(len(nums)):
            while max_q and (nums[max_q[-1]] < nums[i]):
                max_q.pop()
            max_q.append(i)
            
            while min_q and (nums[min_q[-1]] > nums[i]):
                min_q.pop()
            min_q.append(i)
            
            max_val = nums[max_q[0]]
            min_val = nums[min_q[0]]
            
            if (max_val - min_val) <= limit:
                max_len = max(max_len, i-s+1)
            else:
                if s == max_q[0]:
                    max_q.pop(0)
                if s == min_q[0]:
                    min_q.pop(0)
                s += 1
                
        return max_len

