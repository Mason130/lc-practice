class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        // xy means the number of strings with different chars, 
        // whereas xx means the number of strings with the same chars
        int xy = 0, xx = 0;
        for(int i=0; i<words.length; i++){
            char[] arr = new char[2];
            arr[0] = words[i].charAt(1);
            arr[1] = words[i].charAt(0);
            
            String reverse = new String(arr);
            if(map.containsKey(reverse) && map.get(reverse) > 0){
                if(arr[0] == arr[1]) xx--;
                xy++;
                map.put(reverse, map.get(reverse) - 1);
            }
            else{
                if(arr[0] == arr[1]) xx++;
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
        }
        int ret = xx>0 ? xy*4+2 : xy*4;  
        return ret;
    }
}
