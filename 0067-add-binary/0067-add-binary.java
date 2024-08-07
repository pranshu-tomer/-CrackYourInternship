class Solution {
    public String addBinary(String a, String b) {
        
        char rem = '0';
        String ans = "";

        int n = a.length();
        int m = b.length();
        int i = n-1;
        int j = m-1;

        while(i >= 0 && j >= 0){
            char ch = '1';
            char newRem = '0';
            if(a.charAt(i) == b.charAt(j)){
                ch = '0';
                newRem = (a.charAt(i) == '1')?'1':'0';
            }

            if(rem == '1'){
                newRem = (ch == '1')?'1':newRem;
                ch = (ch == '1')?'0':'1';
            }
            rem = newRem;
            ans = ch + ans;
            i--;
            j--;
        }

        while(i >= 0){
            char ch = '1';
            char newRem = '0';
            if(a.charAt(i) == rem){
                ch = '0';
                newRem = (a.charAt(i) == '1')?'1':'0';
            }
            rem = newRem;
            ans = ch + ans;
            i--;
        }

        while(j >= 0){
            char ch = '1';
            char newRem = '0';
            if(b.charAt(j) == rem){
                ch = '0';
                newRem = (b.charAt(j) == '1')?'1':'0';
            }
            rem = newRem;
            ans = ch + ans;
            j--;
        }

        if(rem == '1'){
            ans = '1' + ans;
        }

        return ans;
    }
}