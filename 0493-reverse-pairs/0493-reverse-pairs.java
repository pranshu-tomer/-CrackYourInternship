class Solution {
    public int reversePairs(int[] nums) {
        return merge(nums,0,nums.length-1);

        // int arr[] = {6,13,21,25,1,2,3,4,4,5,9,11,13};
        // return calculate(arr,0,3,arr.length-1);
    }

    public int merge(int[] arr,int start,int end){
        if(start >= end){
            return 0;
        }

        int mid = (start+end)/2;
        int left = merge(arr,start,mid);
        int right = merge(arr,mid+1,end);
        int curr = calculate(arr,start,mid,end);
        mergeSort(arr,start,mid,end);

        return left+right+curr;
    }

    public void mergeSort(int arr[],int start,int mid,int end){

        int i = start;
        int j = mid+1;
        int k = 0;
        int temp[] = new int[end-start+1];

        while(i <= mid && j <= end){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= end){
            temp[k++] = arr[j++];
        }

        j = start;
        for(i=0; i<temp.length; i++){
            arr[j++] = temp[i];
        }
    }

    public int calculate(int arr[],int start,int mid,int end){

        int ans = 0;
        int i = start;
        int j = mid+1;

        while(i <= mid && j <= end){
            if((long)arr[i] > (long)2*arr[j]){
                j++;
            }else{
                ans += (j-mid-1);
                i++;
            }
        }

        if(i <= mid){
            ans += ((end-mid)*(mid-i+1));
        }

        return ans;
    }
}