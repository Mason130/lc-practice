from collections import defaultdict
class Solution(object):
    def validPath(self, n, edges, source, destination):
        """
        :type n: int
        :type edges: List[List[int]]
        :type source: int
        :type destination: int
        :rtype: bool
        """
        
        # adjacent list representation of the graph
        G = defaultdict(list)
        for [v, u] in edges:
            G[v].append(u)
            G[u].append(v)
        
        # s: the source
        # v: vertices have been visited      
        def dfs(s, v):
            if s == destination:
                return True
            v.add(s)
            for vertex in G[s]:
                if vertex not in v:
                    if dfs(vertex, v):
                        return True
            return False
        
        visited = set()
        ret = dfs(source, visited)
        
        return ret
        
