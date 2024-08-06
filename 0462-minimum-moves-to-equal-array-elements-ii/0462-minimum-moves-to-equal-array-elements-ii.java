class Solution {
    public int minMoves2(int[] nums) {
    
        Arrays.sort(nums);

        int n = nums.length;
        // int median = (n%2 == 0)?(nums[n/2]+nums[n/2-1])/2:nums[n/2];
        int ans = 0;
        // for(int a : nums){
        //     ans += Math.abs(median - a);
        // }

        for(int i=0; i<n/2; i++){
            ans += (nums[n-i-1] - nums[i]);
        }

        return ans;
    }
}