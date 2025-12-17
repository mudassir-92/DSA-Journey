import java.util.PriorityQueue;

class Solution {
    public class DisjointSet {

        int [] parent;
        int []  rnk;
        public DisjointSet(int n)
        {
            parent=new int[n+1];
            for (int i = 0; i <= n; i++) {
                parent[i]=i;
            }
            rnk=new int[n+1]; // all ranks as zeros
        }
        int findParent(int node)
        {
            if(node==parent[node])
                return  node;
            parent[node]=findParent(parent[node]);
            return  parent[node];
        }
        void unionByRank(int u,int v)
        {
            int upu=findParent(u);
            int upv=findParent(v);
            if(upv==upu) // already same component
                return;
            if(rnk[upu]<rnk[upv]) {
                // rnk if U is less
                parent[upu]=upv; // rnk of upv is increases? // no bcz on less hair do not increase len
            } else if (rnk[upu] > rnk[upv]) {
                parent[upv]=upu;
            }else{
                // both rnks are equal
                parent[upv]=upu;
                rnk[upu]++;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int cnt=0;
        for (int[] edge : edges) {
            cnt++;
            pq.add(new int[]{edge[0],edge[1],cnt});
        }
        DisjointSet set=new DisjointSet(edges.length);
        while (!pq.isEmpty())
        {
            int[] node = pq.poll();
            int x=node[0],y=node[1];
            int upx=set.findParent(x);
            int upv=set.findParent(y);
            if(upv==upx)
                return  new int []{x,y};
            else{
                set.unionByRank(x,y);
            }
        }
        return  new int[]{-1,-1};
    }
}