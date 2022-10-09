class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] temp = s.toCharArray();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
                temp[i] = '#';
            }
            else if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    int index = stack.pop();
                    temp[index] = '(';
                }
                else
                    temp[i] = '#'; 
            }
        }
        
        StringBuilder ret = new StringBuilder();
        for(int i=0; i<temp.length; i++){
            if(temp[i] != '#')
                ret.append(temp[i]);
        }
        return ret.toString();
    }
}
