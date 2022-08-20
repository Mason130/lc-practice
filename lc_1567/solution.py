class Solution(object):
    def getMaxLen(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #### the product is positive if the number of negatives in the sublist is even
        max_len = 0
        # start index of sublist
        start_index = 0
        # the index first negative 
        first_negative = -1
        # number of negatives
        num_negatives = 0
        
        ## greedy approach
        
        for i in range(len(nums)):
            if nums[i] < 0:
                num_negatives += 1
                # update the indext of the first negative
                if first_negative == -1:
                    first_negative = i
                else:
                    if num_negatives % 2 == 0:
                        max_len = max(max_len, i-start_index+1)
                   
            elif nums[i] > 0:
                if num_negatives % 2 == 0:
                    max_len = max(max_len, i-start_index+1)
                # drop elements before the fist negative (included) if total negatives is odd
                else:
                    max_len = max(max_len, i-first_negative)
            # reset sublist if encounter a zero
            else:
                start_index = i+1
                first_negative = -1
                num_negatives = 0
        
        
        return max_len    
            
                    
                
                
                    
                
        
        
