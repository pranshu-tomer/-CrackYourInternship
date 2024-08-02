class Solution {
    public int coinChange(int[] coins, int amount) {

        int dp[][] = new int[coins.length][amount+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        int ans = help(0,coins,amount,dp);
        return (ans > 10000000)?-1:ans;
    }

    public int help(int idx,int arr[],int rem,int dp[][]){

        if(idx == arr.length){
            return 100000007;
        }
        if(rem == 0){
            return 0;
        }

        if(dp[idx][rem] != -1){
            return dp[idx][rem];
        }

        int take = 100000007;
        if(rem - arr[idx] >= 0){
            take = 1 + help(idx,arr,rem-arr[idx],dp);
        }

        int notTake = help(idx+1,arr,rem,dp);

        return dp[idx][rem] = Math.min(take,notTake);
    }
}