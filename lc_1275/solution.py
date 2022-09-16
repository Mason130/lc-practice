from collections import defaultdict


class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        diagonal1 = [[0,2], [1,1], [2,0]]
        diagonal2 = [[0,0], [1,1], [2,2]]
        a = []
        b = []
        a_r = defaultdict(int)
        a_c = defaultdict(int)
        b_r = defaultdict(int)
        b_c = defaultdict(int)
        
        for i in range(len(moves)):
            row = moves[i][0]
            col = moves[i][1]
            
            if (i % 2) == 0:
                a.append([row,col])
                a_r[row] += 1
                a_c[col] += 1
                #if (3 in a_r.values()) or (3 in a_c.values()):
                if a_r[row] == 3 or a_c[col] == 3:
                    return "A"
                elif all(x in a for x in diagonal1) or all(x in a for x in diagonal2):
                    return "A"
                
            else:
                b.append([row,col])
                b_r[row] += 1
                b_c[col] += 1
                #if 3 in b_r.values() or 3 in b_c.values():
                if b_r[row] == 3 or b_c[col] == 3:
                    return "B"
                elif all(x in b for x in diagonal1) or all(x in b for x in diagonal2):
                    return "B"
         
        if len(moves) == 9:
            return "Draw"
        else:
            return "Pending"
        
