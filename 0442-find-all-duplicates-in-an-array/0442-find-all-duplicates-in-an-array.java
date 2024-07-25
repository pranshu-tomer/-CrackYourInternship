class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0){
                nums[val] = -nums[val];
            }else{
                ans.add(val+1);
            }
        }

        return ans;
    }
}