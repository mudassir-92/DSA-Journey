class Solution {

    public:
    std::string getThousands(int &num)
{
    std::string str;
    int rem=num/1000;
    num %= 1000;
    for (int i = 0; i < rem; i++)
    {
        str += 'M';
    }
    return str;
}
std::string getHundred(int &num)
{
    std::string str;
    int rem = num / 100;
    num %= 100;
    switch (rem)
    {
    case 1:
    case 2:
    case 3:
    {
        for (int i = 0; i < rem; i++)
        {
            str += 'C';
        }
        return str;
    }
    case 4:
        return "CD";
    case 5:
    case 6:
    case 7:
    case 8:
    {
        str += 'D';
        for (int i = 5; i < rem; i++)
            str += 'C';
        return str;
    }
    case 9:
        return "CM";
    case 0:
        return "";
    }
    return"";
}
std::string getTens(int& num)
{
    std::string str;
    int rem = num / 10;
    num %= 10;
    switch (rem)
    {
    case 1:
    case 2:
    case 3:
    {
        for (int i = 0; i < rem; i++)
        {
            str += 'X';
        }
        return str;
    }
    case 4:
        return "XL";
    case 5:
    case 6:
    case 7:
    case 8:
    {
        str += 'L';
        for (int i = 5; i < rem; i++)
            str += 'X';
        return str;
    }
    case 9:
        return "XC";
    case 0:
        return "";
    }
    return "";
}
std::string getOnes(int& num)
{
    std::string str;
    int rem = num ;
    num %= 10;
    switch (rem)
    {
    case 1:
    case 2:
    case 3:
    {
        for (int i = 0; i < rem; i++)
        {
            str += 'I';
        }
        return str;
    }
    case 4:
        return "IV";
    case 5:
    case 6:
    case 7:
    case 8:
    {
        str += 'V';
        for (int i = 5; i < rem; i++)
            str += 'I';
        return str;
    }
    case 9:
        return "IX";
    case 0:
        return "";
    }
    return "";
}
    string intToRoman(int number) 
    {
    std::string res;
    res += getThousands(number);
    res  +=getHundred(number);
    res += getTens(number);
    res += getOnes(number);
    return res;
    }
};