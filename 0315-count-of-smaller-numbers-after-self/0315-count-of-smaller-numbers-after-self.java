class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int temp[] = new int[n];
        for(int i=0; i<n; i++){
            temp[i] = i;
        }
        int tempAns[] = new int[n];
        mergeSort(nums,0,n-1,temp,tempAns);

        for(int i=0; i<n; i++){
            ans.add(tempAns[i]);
        }
        return ans;
    }

    public void mergeSort(int arr[],int s,int e,int temp[],int[] ans){
        if(s >= e){
            return;
        }

        int mid = s + (e-s)/2;
        mergeSort(arr,s,mid,temp,ans);
        mergeSort(arr,mid+1,e,temp,ans);

        count(arr,s,mid,e,ans,temp);
        merge(arr,s,mid,e,temp);
    }

    public void merge(int arr[],int s,int mid,int e,int temp[]){

        int i = s;
        int j = mid+1;

        int k = 0;
        int arr1[] = new int[e-s+1];

        while(i <= mid && j <= e){
            if(arr[temp[i]] < arr[temp[j]]){
                arr1[k++] = temp[j++];
            }else{
                arr1[k++] = temp[i++];
            }
        }

        while(i <= mid){
            arr1[k++] = temp[i++];
        }

        while(j <= e){
            arr1[k++] = temp[j++];
        }

        j = s;
        for(i=0; i<arr1.length; i++){
            temp[j++] = arr1[i];
        }
    }

    public void count(int arr[],int s,int mid,int e,int[] ans,int temp[]){

        int i = s;
        int j = mid+1;

        while(i <= mid && j <= e){
            if(arr[temp[i]] > arr[temp[j]]){
                int total = e-j+1;
                ans[temp[i]] = ans[temp[i]] + total;
                i++;
                continue;
            }
            j++;
        }
    }
}