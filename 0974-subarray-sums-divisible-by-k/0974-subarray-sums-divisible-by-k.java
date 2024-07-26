class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> temp = new HashMap<>();

        temp.put(0,1);

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int curr = sum%k;
            if(curr < 0){
                curr += k;
            }
            if(temp.containsKey(curr)){
                int val = temp.get(curr);
                ans += val;
                temp.put(curr,val+1);
            }else{
                temp.put(curr,1);
            }
            
        }

        return ans;
    }
}