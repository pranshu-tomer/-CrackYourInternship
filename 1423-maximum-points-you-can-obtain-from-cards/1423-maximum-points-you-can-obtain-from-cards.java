class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int ans = 0;
        int left = 0;

        for(int i=0; i<k; i++){
            left += cardPoints[i];
        }
        ans = left;

        int j = n-1;
        int right = 0;
        for(int i = k-1; i>=0; i--){
            left -= cardPoints[i];
            right += cardPoints[j];
            j--;
            ans = Math.max(left+right,ans);
        }

        return ans;
    }
}