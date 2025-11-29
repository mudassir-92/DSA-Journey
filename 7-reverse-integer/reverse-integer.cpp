#include<vector>
using namespace std;
class Solution {
public:
    int  reverse(int x) 
    {   
        if(x==-2147483648)
        return 0;
        bool flag=false;
        flag=x<0?true:false;
        if(flag)
        {
            x=-x;
        }
        double num=0;
        while(x!=0)
        {
            double rem=x%10;
            num=num*10+rem;
            x=x/10;
        }
        if(num>2147483647 || num<-2147483648)
            return 0;
        return !flag?num:-num;
    }
};