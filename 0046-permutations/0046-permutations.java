import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans;
    void permutate(int [] nums,int curr)
    {
        if(curr== nums.length-1) 
        {
            List<Integer> ls=new ArrayList<>(nums.length);
            for (int num : nums) {
                ls.add(num);
            }
            ans.add(ls);
            return;
        }
        for (int i = curr; i < nums.length; i++) {
            int temp=nums[i];
            nums[i]=nums[curr];
            nums[curr]=temp;
            permutate(nums,curr+1);
            temp=nums[i];
            nums[i]=nums[curr];
            nums[curr]=temp;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
            ans=new ArrayList<>((int) Math.pow(2,nums.length));
            permutate(nums,0);
            return  ans;
    }
}