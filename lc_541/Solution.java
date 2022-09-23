class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder ret = new StringBuilder();
        // start index of sub-string that needs to be reversed.
        int start = 0;
            
        for(int i=0; i<s.length(); i++){
            // update start index when finishing up with the sub-string of length 2k
            if(i%(2*k) == 0)
                start = i;
            if(i < (start+k))
                ret.insert(start, s.charAt(i));
            else{
                ret.append(s.charAt(i));
            }
        }
        
        return ret.toString();
    }
}
