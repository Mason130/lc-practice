class Solution(object):
    def slowestKey(self, releaseTimes, keysPressed):
        """
        :type releaseTimes: List[int]
        :type keysPressed: str
        :rtype: str
        """
        
        slowest_time = releaseTimes[0]
        slowest_index = 0
        
        for i in range(1, len(releaseTimes)):
            time = releaseTimes[i] - releaseTimes[i-1]
            if time > slowest_time:
                slowest_time = time
                slowest_index = i
            elif time == slowest_time:
                if keysPressed[i] > keysPressed[slowest_index]:
                    slowest_time = time
                    slowest_index = i
        
        return keysPressed[slowest_index]
        
