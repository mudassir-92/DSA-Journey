class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        dic = {'2': "abc", '3': "def", '4': "ghi", '5': "jkl", '6': "mno", '7': "pqrs", '8': "tuv", '9': "wxyz"}
        unpro=digits
        pro=""
        def permutations(pro:str,unpro:str,res:list,dic:dict[str:str]):
            if len(unpro)==0:
                res.append(pro)
                return

            # ab iske pass dictionary hai
            # we will make three processed strings
            # it wiil call that digtimes
            char=unpro[0]
            for alp in dic[char]:
                permutations(pro+alp,unpro[1:],res,dic)
        res=[]
        if len(unpro)==0:
            return res
        permutations(pro,unpro,res,dic)
        return res