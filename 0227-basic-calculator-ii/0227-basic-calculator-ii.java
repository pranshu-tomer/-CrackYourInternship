class Solution {
    public int calculate(String s) {
        
        Stack<Integer> temp = new Stack<>();

        int curr = 0;
        char op = '+';
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                curr = (curr*10) + (ch-'0');
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == s.length()-1){
                if(op == '*'){
                    temp.push(temp.pop()*curr);
                }
                if(op == '/'){
                    temp.push(temp.pop()/curr);
                }
                if(op == '+'){
                    temp.push(curr);
                }
                if(op == '-'){
                    temp.push(-curr);
                }
                op = ch;
                curr = 0;
            }
        }

        int ans = 0;
        while(!temp.isEmpty()){
            ans += temp.pop();
        }

        return ans;
    }
}