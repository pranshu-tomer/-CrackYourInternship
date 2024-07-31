class Solution {
    public String reverseWords(String s) {

        int n = s.length();
        Stack<String> temp = new Stack<>();

        int i = 0;
        while(i < n){
            while(i<n && s.charAt(i) == ' '){
                i++;
            }
            if(i == n){
                break;
            }
            int j = i;
            while(i<n && s.charAt(i) != ' '){
                i++;
            }
            temp.push(s.substring(j,i));
            i++;
        }

        s = "";
        while(!temp.isEmpty()){
            s += " ";
            s += temp.pop();
        }

        return s.substring(1,s.length());
    }
}