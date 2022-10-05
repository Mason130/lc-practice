class TrieNode{
    public HashMap<Character, TrieNode> children;
    public boolean isTail;
    public TrieNode(){
        this.children = new HashMap<>();
        this.isTail = false;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String s : dictionary) {
            TrieNode cur = root;
            for (Character ch : s.toCharArray()) {
                if (cur.children.get(ch) == null) {
                    TrieNode newNode = new TrieNode();
                    cur.children.put(ch, newNode);
                }
                cur = cur.children.get(ch);
            }
            cur.isTail = true;
        }        
        
        String[] words = sentence.split(" ");
        StringBuilder ret = new StringBuilder();
        for(String word: words){
            TrieNode cur = root;
            for(Character ch: word.toCharArray()){
                ret.append(ch);
                if(cur != null){
                    cur = cur.children.get(ch);
                    if(cur != null && cur.isTail)
                        break;
                }
            }
            ret.append(" ");
        }
        
        ret.deleteCharAt(ret.length() - 1);
        return ret.toString();
    }
}
