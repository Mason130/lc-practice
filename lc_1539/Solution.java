class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] p = new int[2000];
        for(int i=0; i<arr.length; i++){
            p[arr[i]-1] = arr[i];
        }
        
        int i = 0;
        while(k>0){
           if(p[i] != i+1)
               k--;
            i++;
        }
        
        return i;
    }
}
