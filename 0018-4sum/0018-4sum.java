class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int i = 0;

        while(i+3 < n){
            int j = i+1;
            while(j+2 < n){
                int k = j+1;
                int l = n-1;
                while(k < l){
                    long sum = nums[i]+(long)nums[j]+nums[k]+nums[l];
                    if(sum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        int curr = nums[k];
                        while(k < n && curr == nums[k]){
                            k++;
                        }
                        curr = nums[l];
                        while(l > 0 && curr == nums[l]){
                            l--;
                        }
                    }else if(sum < target){
                        int curr = nums[k];
                        while(k < n && curr == nums[k]){
                            k++;
                        }
                    }else{
                        int curr = nums[l];
                        while(l > 0 && curr == nums[l]){
                            l--;
                        }
                    }
                }
                int curr = nums[j];
                while(j < n && curr == nums[j]){
                    j++;
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