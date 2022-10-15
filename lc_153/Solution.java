class Solution {
    public int findMin(int[] nums) {
        return findMinAux(nums, 0, nums.length-1);
    }
    
    public int findMinAux(int[] nums, int l, int h){
        if(l == h)
            return nums[l];
        if(l+1 == h)
            return Math.min(nums[l], nums[h]);
        if (nums[l]<nums[h])
            return nums[l];
        
        int m = (l+h) / 2;
        int ret = Math.min(findMinAux(nums, l, m), findMinAux(nums, m+1, h));
        return ret;
    }
}
