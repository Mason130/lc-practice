class Solution:
    def kthFactor(self, n: int, k: int) -> int:
        ret = -1
        order = 0
        for i in range(1, n+1):
            if n % i == 0:
                order += 1
                if order == k:
                    ret = i
        
        return ret
        
