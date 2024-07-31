class Solution {
    public boolean isNumber(String s) {
        boolean digit=false,dot=false,exponent=false;
        int plus = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                digit = true;
            }else if(ch == '+' || ch ==  '-'){
                if(plus == 2){
                    return false;
                }
                if(i > 0 && (s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')){
                    return false;
                }
                if(i == s.length()-1){
                    return false;
                }
                plus++;
            }else if(ch == '.'){
                if(exponent || dot){
                    return false;
                }
                if(i == s.length()-1 && !digit){
                    return false;
                }
                dot = true;
            }else if(ch == 'E' || ch == 'e'){
                if(exponent || !digit || i == s.length() - 1){
                    return false;
                }
                exponent = true;
            }else{
                return false;
            }

        }

        return true;
    }
}