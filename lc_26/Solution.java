class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[k]){
                int temp = nums[k+1];
                nums[k+1] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
        return k+1;
    }
}
