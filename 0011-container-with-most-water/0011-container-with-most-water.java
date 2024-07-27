class Solution {
    public int maxArea(int[] height) {
        
        int n = height.length;
        int left = 0;
        int right = n-1;

        int ans = 0;
        while(left < right){
            int min = Math.min(height[left],height[right]);
            min = min*(right-left);
            ans = Math.max(ans,min);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return ans;
    }
}