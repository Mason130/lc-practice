# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def pairSum(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: int
        """
        
        ## reverse the list first, then add the elements with the same index in the original and 
        # reversed lists to get a new list sums[], the maximum twin sum is the maximum value of the
        # first or second half sums[], that is, we only need to keep the first half of sums[] 
        
        sums = []
        # store values of the original list
        origin = []
        # reverse the list
        prev = None
        cur = head
        while cur is not None:
            origin.append(cur.val)
            nex = cur.next
            cur.next = prev
            prev = cur
            cur = nex
         
        # calculate sums[]
        for i in range(len(origin)/2):
            twin_sum = origin[i] + prev.val
            sums.append(twin_sum)
            prev = prev.next
        
        max_twin_sum = max(sums)
        
        return max_twin_sum
        
