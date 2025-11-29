class Solution {
    public int myAtoi(String s) {
        long num=0;
        char[] str = s.toCharArray();
        int l= str.length;
        int index=0;
        while(index<l && str[index]==' ')
        {
            index++;
        }
        if(index>=l)
            return 0;
        boolean pos=true;
        if(str[index]=='-')
        {
            pos=false;
            index++;
        }else if(str[index]=='+'){
            index++;
        }
        if(index>=l)
            return 0;
        while (index<l)
        {
            if(str[index]>='0' && str[index]<='9')
            {
                num=num*10+(str[index]-'0');
                if(pos && num>=Integer.MAX_VALUE)
                    return  Integer.MAX_VALUE;
                if(-num<Integer.MIN_VALUE && !pos)
                    return  Integer.MIN_VALUE;
            }
            else
            {
                break;
            }
            index++;
        }

        if(pos && num>=Integer.MAX_VALUE)
            return  Integer.MAX_VALUE;
        if(-num<Integer.MIN_VALUE && !pos)
            return  Integer.MIN_VALUE;
        return (int)(pos?num:-1*num);
    }
}