import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('M', 1000, 'D', 500, 'C', 100, 'L', 50,
                'X', 10, 'V', 5, 'I', 1);
        // System.out.println(map.keySet());
        char[] arr = s.toCharArray();
        int sum=0;
        int last=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int num=map.get(arr[i]);
            if(last<num)
                sum-=(2*last);
            last=num;
            sum+=num;
        }
        return  sum;
    }
}