class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        ## Sliding window approach
        # start index of the non-repeating string
        start_index = 0
        
        # dictionary to store the non-repeating char and its last index
        non_char = {}
        
        # maximum length
        max_len = 0
        
        for i in range(len(s)):
            # if a char repeats
            if s[i] in non_char:
                # update the start index, to start a new non-repeating string
                # window cannot slide back
                if (non_char[s[i]] + 1) > start_index:
                    start_index = non_char[s[i]] + 1
            
            # update dictionary
            non_char[s[i]] = i
            
            # update maximum length
            if (i - start_index + 1) > max_len:
                max_len = i - start_index + 1
        
        return max_len
                
        
