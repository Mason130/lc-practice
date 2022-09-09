import bisect


class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        ret = []
        products.sort()
        l = len(products)
        
        for i in range(len(searchWord)):
            cell = []
            word = searchWord[:i+1]
            index = bisect.bisect_left(products, word)
            
            if index <= (l-1):
                if products[index][:i+1] == word:
                    cell.append(products[index])
            if (index+1) <= (l-1):
                if products[index+1][:i+1] == word:
                    cell.append(products[index+1]) 
            if (index+2) <= (l-1):
                if products[index+2][:i+1] == word:
                    cell.append(products[index+2])
            
            ret.append(cell)
        
        return ret
    
