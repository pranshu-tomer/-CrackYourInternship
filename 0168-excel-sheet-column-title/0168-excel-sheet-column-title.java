class Solution {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder ans = new StringBuilder("");

        while(columnNumber > 0){
            int temp = (columnNumber-1)%26;
            ans.append((char)(temp + 'A'));
            columnNumber = (columnNumber-1)/26;
        }

        return ans.reverse().toString();
    }
}