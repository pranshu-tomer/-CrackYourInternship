class Solution {
    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    char ch = board[i][j];
                    board[i][j] = '&';
                    boolean ans = help(board,word.substring(1,word.length()),
                    i,j,n,m);
                    board[i][j] = ch;
                    if(ans) return ans;
                }
            }
        }

        return false;
    }

    public boolean help(char arr[][],String word,int i,int j,int n,int m){

        if(word.length() == 0){
            return true;
        }
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }

        for(int x = -1; x <= 1; x++){
            if(i+x >= 0 && j >= 0 && i+x < n && j < m && 
                arr[i+x][j] == word.charAt(0)){
                    char ch = arr[i+x][j];
                    arr[i+x][j] = '&';
                    boolean ans = help(arr,word.substring(1,word.length()),
                    i+x,j,n,m);
                    arr[i+x][j] = ch;
                    if(ans) return ans;
                }
        }

        for(int x = -1; x <= 1; x++){
            if(i >= 0 && j+x >= 0 && i < n && j+x < m && 
                arr[i][j+x] == word.charAt(0)){
                    char ch = arr[i][j+x];
                    arr[i][j+x] = '&';
                    boolean ans = help(arr,word.substring(1,word.length()),
                    i,j+x,n,m);
                    arr[i][j+x] = ch;
                    if(ans) return ans;
                }
        }

        return false;
    }
}