# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseBetween(self, head, left, right):
        """
        :type head: ListNode
        :type left: int
        :type right: int
        :rtype: ListNode
        """        
        # the begin and end node of the part of list needs to be reversed
        beginNode = None
        endNode = None
        # the nodes at the left of begin node and right of end node
        leftNode = None
        rightNode = None
        
        # current node
        cur = head
        # record  the position
        count = 1
        while cur:
            if count == left:
                beginNode = cur
                break
            leftNode = cur
            cur = cur.next
            count += 1
        
        # current node
        #cur = head
        #count = 1
        while cur:
            if count == right:
                endNode = cur
                break
            cur = cur.next
            count += 1
        rightNode = endNode.next
        
        ## reverse the list from begin node to end node
        # previous node
        prev = None
        cur_1 = beginNode
        while cur_1 is not rightNode:
            nex = cur_1.next
            cur_1.next = prev
            prev = cur_1
            cur_1 = nex
        
        if leftNode is not None:
            leftNode.next = endNode
            beginNode.next = rightNode
            return head
        # reverse from the head node
        else:
            head.next = rightNode   
            return prev
