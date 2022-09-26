class Solution {
    // finding the length of subarray that repeating max element.
    // sliding window approach
    public int longestSubarray(int[] nums) {
        int s = 0;
        int maxLen = 1;
        int maxVal = nums[0];
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] == maxVal){
                maxLen = Math.max(maxLen, i-s+1);
            }
            else if(nums[i] > maxVal){
                maxLen = 1;
                maxVal = nums[i];
                s = i;
            }
            // if nums[i] < maxVal, the window should slide to the position after i
            else{
                s = i + 1;
            }
        }
        
        return maxLen;
    }
}
