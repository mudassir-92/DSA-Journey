class Solution {
    public int maxArea(int[] height) {
        int sp=0,ep=height.length-1; // start pointer end pointer
        int maxWater=0,water;
        while (sp<ep)
        {
            int min=Math.min(height[sp],height[ep]);
            water=min*(ep-sp);
            maxWater=Math.max(maxWater,water);
            if(height[sp]<height[ep])
                sp++;
            else if(height[sp]>height[ep])
                ep--;
            else if (height[sp]==height[ep]) 
            {
                sp++;
                ep--;
            }
        }
        return maxWater;
    }
}