class Solution {
    public int splitArray(int[] nums, int k) {
        
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int a : nums){
            sum += a;
            max = Math.max(max,a);
        }

        while(max < sum){
            int mid = max + (sum-max)/2;
            int array = count(nums,mid);

            if(array > k){
                max = mid+1;
            }else{
                sum = mid;
            }
        }

        return max;
    }

    public int count(int[] arr,int target){
         
        int curr = 1;
        int sum = 0;
        for(int a : arr){
            sum += a;
            if(sum > target){
                sum = a;
                curr++;
            }
        }

        return curr;
    }
}