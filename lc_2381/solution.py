class Solution(object):
    def shiftingLetters(self, s, shifts):
        """
        :type s: str
        :type shifts: List[List[int]]
        :rtype: str
        """
        ## prefix sum
        N = len(s)
        prefix = [0]*(N+1)
        
        for shift in shifts:
            if shift[2] == 0:
                prefix[shift[0]] -= 1
                prefix[shift[1]+1] += 1
                
            else:
                prefix[shift[0]] += 1
                prefix[shift[1]+1] -= 1
        
        for i in range(1, N):
            prefix[i] = prefix[i] + prefix[i-1]
        
        s = list(s)
        for i in range(len(s)):
            x = (ord(s[i]) + prefix[i] - 97) % 26 + 97 
            s[i] = chr(x)
        
        return "".join(s)
      
