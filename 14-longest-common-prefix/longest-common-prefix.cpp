class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        bool flag = true;
        int index = 0;
        int minSize = 0;
        minSize = strs[0].size();
        for (int i = 1; i < strs.size(); i++)
        {
            if (strs[i].size() < minSize)
                minSize = strs[i].size();
        }
        while(flag)
        {
            int i = 0;
            for (; i < strs.size() && index<minSize ; i++)
            {
                if (strs[0][index] != strs[i][index])
                    flag = false;
            }
            if (index == minSize)
                flag = false;
            index++;
        }
        string str;
        for (int i = 0; i < index-1; i++)
        {
            str.push_back(strs[0][i]);
        }
        return str;
    }
};