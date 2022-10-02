class Solution {
    public int minimizeXor(int num1, int num2) {
        String s1 = Integer.toBinaryString(num1);
        String s2 = Integer.toBinaryString(num2);
        StringBuilder temp = new StringBuilder();
        int ret = 0;
        
        for(int i=0; i<s2.length(); i++){
            if(s2.charAt(i) == '1')
                temp.append('1');
        }
        
        int l = temp.length(); // number of ones
        if(l >= s1.length())
            ret = Integer.parseInt(temp.toString(), 2);
        else{
            temp = new StringBuilder();
            for(int i=0; i<s1.length(); i++){
                if(s1.charAt(i) == '1' && l>0){
                    temp.append('1');
                    l--;
                }
                else
                    temp.append('0');
            }
            
            int i = temp.length()-1;
            while(l>0){
                if(s1.charAt(i) == '0'){
                    temp.setCharAt(i, '1');
                    l--;
                }
                i--;
            }
            
            ret = Integer.parseInt(temp.toString(), 2);
        }
        
        return ret;
    }
}
