class Solution {
    //  Euclid's Algorithm to find the GCD
    public int gcd(int a, int b){
        return b==0 ? a : gcd(b, a%b);
    }
    
    public int subarrayGCD(int[] nums, int k) {
        int ret = 0;
        
        for(int i=0; i<nums.length; i++){
            int subGCD = nums[i];
            for(int j=i; j<nums.length; j++){
                if(subGCD < k)
                    break;
                subGCD = gcd(subGCD, nums[j]);
                if(subGCD == k)
                    ret++;
            }
        }
        
        return ret;
    }
}
