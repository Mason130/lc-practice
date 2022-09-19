from collections import defaultdict


## Trie solution
#class TrieNode:
#    def __init__(self):
#        self.children = defaultdict(TrieNode)
#        self.weight = 0

        
#class Solution:
#    def sumPrefixScores(self, words: List[str]) -> List[int]:
#        root = TrieNode()
#        ret = []

#        for word in words:
#            cur = root
#            for ch in word:
#                cur = cur.children[ch]
#                cur.weight += 1
        
#        for word in words:
#            score = 0
#            cur = root
#            for ch in word:
#                cur = cur.children[ch]
#                score += cur.weight
#            ret.append(score)
        
#        return ret

class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        prefix = {}
        ret = []
        
        for word in words:
            s = ""
            for ch in word:
                s += ch
                if s in prefix:
                    prefix[s] += 1
                else:
                    prefix[s] = 1
                    
        for word in words:
            score = 0
            s = ""
            for ch in word:
                s += ch
                score += prefix[s]
            ret.append(score)
        
        return ret
        
