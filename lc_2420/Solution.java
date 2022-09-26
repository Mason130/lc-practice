class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ret= new ArrayList<>();
        int l = nums.length;
        
        int[] dp1= new int[l];  
        Arrays.fill(dp1,1);
        
        int[] dp2= new int[l];  
        Arrays.fill(dp2,1);
        
        for(int i=1; i<l; i++){
            if(nums[i] <= nums[i-1]){
                dp1[i] = dp1[i-1]+1;
            }
        }
        
        for(int i=l-2; i>=0; i--){
            if(nums[i] <= nums[i+1]){
                dp2[i] = dp2[i+1]+1;;
            }
        }
        
        for(int i=k; i<l-k; i++){
            if(dp1[i-1]>=k && dp2[i+1]>=k)
                ret.add(i);
        }
        
        return ret;
    }
}
