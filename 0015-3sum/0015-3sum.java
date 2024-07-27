class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int i = 0;

        while(i+2 < n){
            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    int curr = nums[j];
                    while(j < n && curr == nums[j]){
                        j++;
                    }
                }else if(sum < 0){
                    int curr = nums[j];
                    while(j < n && curr == nums[j]){
                        j++;
                    }
                }else{
                    int curr = nums[k];
                    while(k > 0 && curr == nums[k]){
                        k--;
                    }
                }
            }
            int curr = nums[i];
            while(i < n && curr == nums[i]){
                i++;
            }
        }

        return ans;
    }
}