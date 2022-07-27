class Solution(object):
    def numberOfBeams(self, bank):
        """
        :type bank: List[str]
        :rtype: int
        """
        ## assume we have x devices in ith row, y in jth row, and z in kth row
        ## the number of laser beams = x*y + y*z
        
        # number of security devices in each non-empty row
        num_devices = []
        
        for i in range(len(bank)):
            # count the number if '1's in current row
            n = bank[i].count('1')
            if n != 0:
                num_devices.append(n)
        
        # the number of laser beams
        num_beams = 0
        
        for j in range(len(num_devices)-1):
            num_beams += num_devices[j] * num_devices[j+1]
        
        return num_beams
            
            
