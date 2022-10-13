class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) == null) map.put(nums[i], 1);
            else map.replace(nums[i], map.get(nums[i]) + 1);
            if(map.get(nums[i]) > nums.length/2) return nums[i];
        }
        
        return 0;
    }
}
