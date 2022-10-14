class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int modulo = (int) 1e9+7, n = binary.length();
        int endWithOne = 0, endWithZero = 0;
        boolean hasZero = false;
        
        for(int i=0; i<n; i++){
            if(binary.charAt(i) == '0'){
                hasZero = true;
                endWithZero = (endWithOne + endWithZero) % modulo;
            }
            else{
                endWithOne = (endWithOne + endWithZero + 1) % modulo;
            }
        }
        
        if(hasZero)
            return (endWithOne + endWithZero + 1) % modulo;
        return (endWithOne + endWithZero) % modulo;
    }
}
