#include<string>
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int max = 0, cnt;
        string str;
        for (int i = 0; i < s.size(); i++)
        {
            for (int j = i ; (j)<s.size(); j++)
            {
                if (str.empty() || find(str.begin(), str.end(), s[j]) == str.end())
                {
                    str.push_back(s[j]);
                }
                else
                {
                    break;
                }
            }
            int size = str.size();
            max = max < size ? size : max;
            str.clear();
        }
        return max;
    }
};