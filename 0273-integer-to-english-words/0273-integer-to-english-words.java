class Solution {
    String [] units={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String []  elTo19={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String [] tenFolds={"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    //2,147,483,647 ; 2147483647th (two billion one hundred forty-seven million four hundred eighty-three thousand six hundred forty-seventh)
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        if(num>=1000000000)
        {
            String res= numberToWords(num/1000000000)+" Billion";
            if(num%1000000000==0)
                return  res;
            return  res+" "+numberToWords(num%1000000000);
        }else if (num>=1000000)
        {
            String res = "";
            if(num>=1000000)
            {
                res+=numberToWords(num/(1000000));
                num=num%(1000000*100);
            }
            res=res+" Million";
            if(num%1000000==0)
                return  res;
            return res+" "+numberToWords(num%1000000);
        }
        else if(num>=1000)
        {
            String res="";
            res=numberToWords(num/1000)+" ";
            res+="Thousand";
            if(num%1000==0)
                return  res;
            return  res+" "+numberToWords(num%1000);
        }
        else if(num>=100 && num<=999)
        {
            String res="";
            res=numberToWords(num/100)+" Hundred";
            if(num%100==0)
                return res;
            return  res+" "+numberToWords(num%100);
        }
        else if(num<100 && num>=10)
        {
            String res="";
            if(num<20)
                return  elTo19[num-10];
            if(num%10!=0)
            {
                res=tenFolds[num/10-1]+" "+numberToWords(num%10) ;
            }else{
                res=tenFolds[num/10-1];
            }
            return  res;

        } else if (num<10 && num>0) {
            return  units[num-1];

        }
        return  "";
    }
}