class Solution:
    def largestPalindromic(self, num: str) -> str:
        ## greedy approach
        num = list(num)
        num.sort(reverse=True)
        first_half = []
        # the largest digit that cannot form palindromic
        largest_digit = ''
        ret = []
        
        if len(num) == 1:
            ret.append(num[0])
        
        else:
            i = 0
            l = len(num)
            while l > 1:
                if num[i+1] == num[i]:
                    first_half.append(num[i])
                    i += 2
                    l -= 2
                else:
                    largest_digit = max(largest_digit, num[i])
                    i += 1
                    l -= 1
                    
            if l == 1:
                largest_digit = max(largest_digit, num[len(num)-1])
            
            last_half = first_half.copy()
            last_half.reverse()
            first_half.append(largest_digit)
            if first_half[0] == '0':
                if largest_digit != '':
                    ret.append(largest_digit)
                else:
                    ret.append('0')
            else:
                ret = first_half + last_half
        
        return "".join(ret)

