class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, h = nums.length-1;
        
        while(l <= h){
            int m = (l+h)/2;
            if(nums[m] == target)
                return true;
            if(nums[m] > nums[l]){
                if(nums[m] > target && nums[l] <= target) 
                    h = m-1;
                else
                    l = m+1;
                
            }
            else if(nums[m] < nums[l]){
                if(nums[m] < target && nums[h] >= target)
                    l = m+1;
                else
                    h = m-1;
            }
            else
                l++;
            
        }
        return false;
    }
}
