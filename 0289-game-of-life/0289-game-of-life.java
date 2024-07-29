class Solution {
    public void gameOfLife(int[][] board) {
        
        int n = board.length;
        int m = board[0].length;

        int ans[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                help(board,n,m,i,j,ans);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = ans[i][j];
            }
        }
    }

    public void help(int arr[][],int n,int m,int x,int y,int ans[][]){

        int num0 = 0;
        int num1 = 0;

        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                if(x+i>=0 && x+i<n && y+j>=0 && y+j<m && !(i==0 && j==0)){
                    if(arr[x+i][y+j] == 1){
                        num1++;
                    }else{
                        num0++;
                    }
                }
            }
        }

        if(arr[x][y] == 0){
            if(num1 == 3){
                ans[x][y] = 1;
            }else{
                ans[x][y] = 0;
            }
        }else{
            if(num1 == 2 || num1 == 3){
                ans[x][y] = 1;
            }else{
                ans[x][y] = 0;
            }
        }
    }
}