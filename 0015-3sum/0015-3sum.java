import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls=new ArrayList<>();
        Arrays.sort(nums);
        int sum=0;
        int l= nums.length;
        for (int i = 0; i < l; i++) {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            sum=nums[i];
            // we need all those pairs whose sum is target-sum == -sum
            int fp=i+1,sp=l-1;
            int target=-sum;
            while (fp<sp)
            {
                while (fp<sp && nums[fp]+nums[sp]<target)
                    fp++;
                while (sp>fp && nums[fp]+nums[sp]>target)
                    sp--;
                if(fp>=sp)
                    break;
                 if(nums[fp]+nums[sp]==target)
                    ls.add(List.of(nums[i],nums[fp],nums[sp]));
                // to remove duplicacy do 
                while (fp+1<sp && nums[fp+1]==nums[fp])
                    fp++;
                // while (fp<sp && nums[sp-1]==nums[sp])
                //     sp--;
                fp++;
            }
        }
        return ls;
    }
}