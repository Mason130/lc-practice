class Solution {
   public String reverseWords(String s) {
        StringBuilder ret = new StringBuilder();
        int start = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' ')
                ret.insert(start, s.charAt(i));
            else {
                ret.append(s.charAt(i));
                start = i+1;
            }
        }
        return ret.toString();
    }
}
