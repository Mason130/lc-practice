class TrieNode{
    public HashMap<Character, TrieNode> children;
    public boolean isTail;
    public TrieNode(){
        this.children = new HashMap<>();
        this.isTail = false;
    }
}

class Trie {
    public TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(Character ch: word.toCharArray()){
            if(cur.children.get(ch) == null){
                TrieNode newNode = new TrieNode();
                cur.children.put(ch, newNode);
            }
            cur = cur.children.get(ch);
        }
        cur.isTail = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(Character ch: word.toCharArray()){
            if(cur.children.get(ch) == null)
                return false;
            cur = cur.children.get(ch);
        }
        return cur.isTail;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(Character ch: prefix.toCharArray()){
            if(cur.children.get(ch) == null)
                return false;
            cur = cur.children.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
