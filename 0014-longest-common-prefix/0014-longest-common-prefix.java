class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String ans = strs[0];

        for(int i=1; i<strs.length; i++){
            int n = ans.length();
            String curr = strs[i];
            int m = curr.length();

            int j = 0;
            while(j<n && j<m && curr.charAt(j) == ans.charAt(j)){
                j++;
            }
            if(n < m){
                ans = ans.substring(0,j);
            }else{
                ans = curr.substring(0,j);
            }
        }

        return ans;
    }
}