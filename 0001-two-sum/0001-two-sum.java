class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int n = nums.length;
        int ans[] = new int[2];

        int temp[][] = new int[n][2];
        for(int i=0; i<n; i++){
            temp[i][0] = nums[i];
            temp[i][1] = i;
        }

        Arrays.sort(temp, Comparator.comparingInt(a -> a[0]));
        
        int i=0;
        int j=n-1;
        while(i<j){
            int curr = temp[i][0]+temp[j][0];
            if(curr == target){
                ans[0] = temp[i][1];
                ans[1] = temp[j][1];
                break;
            }else if(curr < target){
                i++;
            }else {
                j--;
            }
        }

        return ans;
    }
}