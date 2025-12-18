import java.security.Key;
import java.util.HashMap;

class LRUCache {
    int cnt=0;
    HashMap<Integer,int []>  map;
    int cap;
    public LRUCache(int capacity) {
        map=new HashMap<>(capacity);
        cap=capacity;
    }

    public int get(int key) {
        int[] node = map.getOrDefault(key, new int[]{-1, -1});
        if(node[1]==-1 )
            return  -1;
        int diff=cnt-node[1];
        if(diff>cap) {
            map.remove(key);
            return  -1;
        }
        map.put(key,new int []{node[0],cnt});
        cnt++;
        return  node[0];
    }

    public void put(int key, int value) {
        map.put(key,new int[]{value,cnt});
        cnt++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */