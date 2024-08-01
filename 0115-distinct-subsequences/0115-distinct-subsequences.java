class Solution {
    public int numDistinct(String s, String t) {
        
        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                dp[i][j] = -1;
            }
        }

        return help(s,t,n-1,m-1,dp);
    }

    public int help(String s,String t,int idx,int idx1,int dp[][]){

        if(idx1 < 0){
            return 1;
        }
        if(idx < 0){
            return 0;
        }

        if(dp[idx][idx1] != -1){
            return dp[idx][idx1];
        }

        int take = 0;
        if(s.charAt(idx) == t.charAt(idx1)){
            take = help(s,t,idx-1,idx1-1,dp);
        }

        int notTake = help(s,t,idx-1,idx1,dp);

        return dp[idx][idx1] = (take+notTake);
    }
}