class Solution {
    public boolean isPalindrome(int x)
    {
       if(x<0)
            return false;
        ArrayList <Integer> arr=new ArrayList <> ();
        while(x!=0)
        {
            arr.add(x%10);
            x=x/10;
        }

        int start=0,end=arr.size()-1;
        while(start<end)
        {
            if(arr.get(start)!=arr.get(end))
                return  false;
            start++;
            end--;
        }
        return true;
    }
}