class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;

        transpose(matrix,n);
        switchArr(matrix,n);
    }

    public void transpose(int arr[][],int n){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public void switchArr(int arr[][],int n){
        for(int i=0; i<n; i++){
            int k = 0;
            int j = n-1;
            while(k<j){
                int temp = arr[i][k];
                arr[i][k] = arr[i][j];
                arr[i][j] = temp;
                k++;
                j--;
            }
        }
    }
}