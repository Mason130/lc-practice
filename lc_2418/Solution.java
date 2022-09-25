class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // bubble sorting
        int l = heights.length;
        for(int i=0; i<l-1; i++){
            for(int j=0; j<l-1-i; j++){
                if(heights[j]<heights[j+1]){
                    int h = heights[j];
                    String temp = names[j];
                    
                    heights[j] = heights[j+1];
                    names[j] = names[j+1];
                    
                    heights[j+1] = h;
                    names[j+1] = temp;
                }
            }
        }
        
        return names;
    }
}
