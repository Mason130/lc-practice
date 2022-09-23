class Solution {
    public int concatenatedBinary(int n) {
        int modulo = (int) 1e9+7;
        int shift;
        long ret = 1;

        for(int i=2; i<=n; i++){
            shift = Integer.toBinaryString(i).length();
            ret = ((ret << shift) + i) % modulo;
        }
        
        return (int) ret;
    }
}
