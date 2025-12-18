import java.security.Key;
import java.util.HashMap;
import java.util.TreeMap;

class LRUCache {
    int cnt=0;
    HashMap<Integer,int [] >  map;
    TreeMap<Integer,Integer> leastRecent; // by key
    int cap;
    public LRUCache(int capacity) {
        map=new HashMap<>(capacity);
        leastRecent=new TreeMap<>();
        cap=capacity;
    }

    public int get(int key) {
        int[] node = map.getOrDefault(key, new int[]{-1,-1});
        if(node[1]==-1 )
            return  -1;
        // make it the least recent
        leastRecent.remove(node[1]); // is node ki last occurance ko least recent se remove kro 
        leastRecent.put(cnt,key);
        map.put(key,new int []{node[0],cnt});
        cnt++;
        return  node[0];
    }

    public void put(int key, int value) {
        // if map size is
        int[] orDefault = map.getOrDefault(key, new int[]{-1,-1});
        if(orDefault[1]!=-1)
        {
            leastRecent.remove(orDefault[1]);
        }
        map.put(key,new int[]{value,cnt});
        leastRecent.put(cnt,key);
        cnt++;
        // if least recent
        int mpSize=map.size();
        if(mpSize>cap) {
            // remove the most unused
            int thatKey = leastRecent.firstEntry().getValue();
            map.remove(thatKey);
            leastRecent.remove(leastRecent.firstEntry().getKey());
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */