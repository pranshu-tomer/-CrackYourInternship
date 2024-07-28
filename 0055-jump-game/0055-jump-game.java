class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        int val = nums[0];

        for(int i=1; i<n; i++){
            val--;
            if(val < 0){
                return false;
            }
            if(nums[i] > val){
                val = nums[i];
            }
        }

        return true;
    }
}