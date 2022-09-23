from collections import defaultdict
class Solution:
    def maximumSegmentSum(self, nums: List[int], removeQueries: List[int]) -> List[int]:
        #### reverse adding
        # N[i] = [s, e, sum]
        # where s is the start index of the segment that contains nums[i], e is the end index, and sum is the summation of segment
        N = defaultdict(list)
        ret = [0]       # result after all elements are removed
        max_seg = 0
        
        removeQueries.reverse()
        # Taking example 1 as instance: removeQueries = [1,4,2,3,0]
        # before iterations: [0 0 0 0 0] ==> max = 0
        # after iteration 0: [0 2 0 0 0] ==> max = max(0, 2) = 2                                    : sum_seg(2) = 2
        # after iteration 1: [0 2 0 0 1] ==> max = max(2, 1) = 2                                    : sum_seg(1) = 1
        # after iteration 2: [0 2 5 0 1] ==> max = max(2, sum_seg(2)+5) = 7                         : sum_seg(2,5) = 7
        # after iteration 3: [0 2 5 6 1] ==> max = max(7, sum_seg(2,5) + 6 + sum_seg(1)) = 14       : sum_seg(2,5,6,1) = 14
        # after iteration 4: [1 2 5 6 1] ==> max = max(14, 1 + sum_seg(2,5,6,1)) = 15               : sum_all = 15
        
        for i in removeQueries:
            # segment that only contains nums[i]
            cur = nums[i]
            N[i] = [i, i, cur]
            
            # concatenate segment(nums[i]) with its nearby segments if exist
            if N[i-1] != []:
                cur += N[i-1][2]
                s = N[i-1][0]
                e = N[i][1]
                # update segment
                N[s] = [s, e, cur]
                N[e] = [s, e, cur]
            
            if N[i+1] != []:
                cur += N[i+1][2]
                s = N[i][0]
                e = N[i+1][1]
                N[s] = [s, e, cur]
                N[e] = [s, e, cur]
                
            max_seg = max(max_seg, cur)
            ret.append(max_seg)
         
        ret.reverse()
        ret = ret[1:]
        return ret
                
