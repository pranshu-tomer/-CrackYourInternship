class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> temp = new HashMap<>();
        int ans = 0;

        int sum = 0;
        temp.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            ans += temp.getOrDefault(sum-k,0);
            temp.put(sum,temp.getOrDefault(sum,0)+1);
        }

        return ans;
    }
}