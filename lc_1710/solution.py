class Solution(object):
    def maximumUnits(self, boxTypes, truckSize):
        """
        :type boxTypes: List[List[int]]
        :type truckSize: int
        :rtype: int
        """
        
        ## gready searching approach
        
        # sort the box types array by units size in descending order
        boxTypes.sort(key=lambda x: x[1], reverse=True)
        
        # maximum units
        maximum_unit = 0
        
        #### approach 1
        
        #for box in boxTypes:
            # take one box each time
        #    for i in range(1, box[0]+1):
        #        maximum_unit += box[1]
        #        truckSize -= 1
        #       # truck is full
        #        if truckSize == 0:
        #            return maximum_unit
        # case that the total number of boxes is less than truckSize
        #return maximum_unit
    
        #### approach 2
        for box in boxTypes:
            # truck is full
            if truckSize == 0:
                break
            # number of boxes taken
            n = min(box[0], truckSize)
            maximum_unit += box[1] * n
            truckSize -= n
            
        return maximum_unit
                
            
