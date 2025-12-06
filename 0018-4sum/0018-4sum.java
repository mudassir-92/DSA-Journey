import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        // Need at least 4 elements
        if (n < 4) return result;
        
        // Sort the array
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) 
            continue;
            
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1]) 
                continue;
                int left = j + 1;
                int right = n - 1;
                long target2 = (long)target - (long)nums[i] - (long)nums[j];
                while (left < right) 
                {
                    long sum = (long)nums[left] + (long)nums[right];
                    
                    if (sum < target2) 
                    {
                        left++;
                    } else if (sum > target2) 
                    {
                        right--;
                    } else 
                    {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for left
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // right
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}