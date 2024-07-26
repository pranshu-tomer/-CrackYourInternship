class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i=0; i<n; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return help(prices,0,1,dp);
    }

    public int help(int price[],int idx,int buy,int dp[][]){

        if(idx == price.length){
            return 0;
        }

        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }

        int take = 0;
        int notTake = 0;
        if(buy == 1){
            take = -price[idx] + help(price,idx+1,0,dp);
            notTake = help(price,idx+1,1,dp);
        }else{
            take = price[idx] + help(price,idx+1,1,dp);
            notTake = help(price,idx+1,0,dp);
        }
        
        return dp[idx][buy] = Math.max(take,notTake);
    }
}