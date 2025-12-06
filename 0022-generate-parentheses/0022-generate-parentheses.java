import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> ans;
    int es;
    void dfs(StringBuilder path,int open,int close)
    {
        if(path.length()==es*2)
            ans.add(path.toString());
        if(open<es)
        {
            path.append('(');
            dfs(path, open+1, close);
            path.deleteCharAt(path.length()-1);
        }
        if(close<open)
        {
            path.append(')');
            dfs(path, open, close+1);
            path.deleteCharAt(path.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>(n*3);
        StringBuilder str=new StringBuilder();
        es=n;
        dfs(str,0,0);
        return ans;
    }
}