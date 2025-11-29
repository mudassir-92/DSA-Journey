class Solution {
    public String longestPalindrome(String s) {
        String res="";
        int max=0;
        int l=s.length();
        int si=0,ei=0;
        
        char[] str = s.toCharArray();
        // for odd  check
        for (int i = 0; i <l ; i++) {
            int rp=i;
            int fp=i;
            while (rp>= 0 && fp<l)
            {
                if(str[rp]==str[fp])
                {
                    fp++;
                    rp--;
                }else{
                    break;
                }
            }
                fp--;
                rp++;
            if((fp-rp)>max)
            {
                max=fp-rp;
                si=rp;
                ei=fp+1;
//                res=s.substring(rp,fp+1);
            }

        }
        // for even lenght
        for (int i = 0; i < l - 1; i++) {
            int fp=i+1;
            int rp=i;
            while (rp>= 0 && fp<l)
            {
                if(str[rp]==str[fp])
                {
                    fp++;
                    rp--;
                }else{
                    break;
                }
            }
            fp--;
            rp++;
            if((fp-rp)>max)
            {
                max=fp-rp;
                si=rp;
                ei=fp+1;
//                res=s.substring(rp,fp+1);
            }
        }
        return s.substring(si,ei==si?si+1:ei);
    }
}