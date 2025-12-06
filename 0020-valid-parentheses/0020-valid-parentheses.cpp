#include<stack>
using namespace std;
class Solution {
public:
    bool isValid(string s) 
    {
        stack<char> stk;
        char top;
        for(int i=0;i<s.size();i++)
        {
            if(s[i]=='('|| s[i]=='{'|| s[i]=='[' || stk.empty())
                stk.push(s[i]);
            else if(!stk.empty())
            {
                top=stk.top();
                switch(top)
                {
                    case '(':
                        {
                            if(s[i]!=')')
                                return false;
                                stk.pop();
                            break;
                        }
                   case '{':
                        {
                            if(s[i]!='}')
                                return false;
                            stk.pop();
                            break;
                        }
                    case '[':
                        {
                            if(s[i]!=']')
                                return false;
                            stk.pop();
                            break;
                        }         
                }
            }
        }
        if(!stk.empty())
            return false;
            return true;
    }
};