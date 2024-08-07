class Solution {
    public int maximumProduct(int[] nums) {
        
        Arrays.sort(nums);

        int i = 0;
        int n = nums.length-1;

        int mul = nums[i]*nums[i+1]*nums[n];
        int last = nums[n]*nums[n-1]*nums[n-2];

        if(mul > last){
            return mul;
        }else{
            return last;
        }
    }
}