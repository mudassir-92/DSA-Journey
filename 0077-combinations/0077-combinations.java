import java.util.ArrayList;
import java.util.List;

class Solution {
    int n,k;
    List<List<Integer>> ans;
    void dfs(List<Integer> path,int curr)
    {
        if(path.size()==k)
        {
            // System.out.println("that");
            ans.add(new ArrayList<>(path));
        }
        for (int i = curr; i <= n; i++) {
            path.add(i);
            dfs(path,i+1);
            path.removeLast();
        }
    }
    public List<List<Integer>> combine(int n1, int k1) {
        n=n1;
        k=k1;
        ans=new ArrayList<>();
        dfs(new ArrayList<>(),1);
        return  ans;
    }
}