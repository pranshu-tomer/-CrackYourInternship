class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String curr = "";

        help(0,0,n,ans,curr);

        return ans;
    }

    public void help(int open,int close,int n,List<String> ans,String curr){
        if(open == n && close == n){
            ans.add(curr);
            return;
        }

        if(open < n){
            help(open+1,close,n,ans,curr+"(");
        }

        if(close < open){
            help(open,close+1,n,ans,curr+")");
        }
    }
}