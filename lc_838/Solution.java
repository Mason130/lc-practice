class Solution {
    /*
    The direction of a domino will change iff: 
    1) the nearest falling domino on its left is falling right, and the nearest falling domino on its right is falling left; 
    2) the distance to left falling domino is different from the distance to right falling domino.
    */
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        char[] d = dominoes.toCharArray();
        StringBuilder ret = new StringBuilder();
        
        for(int i=0; i<len; i++){
            char lC = ' ', rC = ' '; // the falling direction of the nearest falling domino on left/right
            int lD = len, rD = len;  // the distance to nearest falling domino on left/right
            
            for(int j=i; j>=0; j--){
                if(d[j] == 'L'){
                    lC = 'L';
                    lD = i - j;
                    break;
                }
                else if(d[j] == 'R'){
                    lC = 'R';
                    lD = i - j;
                    break;
                }
            }
            for(int j=i; j<len; j++){
                if(d[j] == 'L'){
                    rC = 'L';
                    rD = j - i;
                    break;
                }
                else if(d[j] == 'R'){
                    rC = 'R';
                    rD = j - i;
                    break;
                }
            }
            
            if(lC == 'R'){
                if(rC == 'L'){
                    if(rD < lD) ret.append('L');
                    else if(lD < rD) ret.append('R');
                    else ret.append('.');
                } 
                else ret.append('R');
            } 
            else{
                if(rC == 'L') ret.append('L'); 
                else ret.append('.'); // edge case
            }
        }
        
        return ret.toString();
    }
}
