class Solution {
    public int firstMissingPositive(int[] nums) {
        /* position swap.
        e.g., 1 should be placed at index 0, 7 should be placed at index 6.
        if num-1 out of the index range 
        or num is placed at index num - 1 
        or num = current index + 1, stop swap
        */
        int l = nums.length;
        
        for(int i=0; i<l; i++){
            while(nums[i]<=l && nums[i]>=1 && nums[i] != i+1 && nums[nums[i]-1] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
        
        for(int i=0; i<l; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        
        return l+1;
    }
}
