import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long  diff=Long.MAX_VALUE;
        int ret=0;
        int sum=0;
        int l= nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                sum=nums[i]+nums[j];
                for (int k = j+1; k < l; k++) {
                    sum+=nums[k];
                    if(Math.abs(sum-target)<diff) {
                        ret = sum;
                        diff = Math.abs(sum - target);
                    }
                    sum-=nums[k];
                    // if(sum>target)
                    //     break;
                }
            }
        }
        return  ret;
    }
}