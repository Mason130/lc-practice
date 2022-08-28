class Solution:
    def minNumberOfHours(self, initialEnergy: int, initialExperience: int, energy: List[int], experience: List[int]) -> int:
        time_energy = 0
        time_experience = 0
        
        if initialEnergy <= sum(energy):
            time_energy = sum(energy) - initialEnergy + 1
        
        for i in range(len(experience)):
            if initialExperience + time_experience > experience[i]:
                initialExperience += experience[i]
            
            else:
                time_experience = experience[i] - initialExperience + 1
                initialExperience += experience[i]
        
        return time_energy + time_experience
    
