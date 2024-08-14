class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> temp = new Stack<>();

        for(int i=0; i<tokens.length; i++){
            char ch = tokens[i].charAt(0);
            if((ch - '0' >=0 && ch - '0' <= 9) || tokens[i].length() > 1){
                int j = 0;
                boolean negative = false;
                if(tokens[i].charAt(j) == '-'){
                    negative = true;
                    j++;
                }
                String curr = tokens[i];
                int num = 0;
                for(; j<curr.length(); j++){
                    num = (num*10) + (curr.charAt(j) - '0');
                }
                if(negative){
                    num = -num;
                }
                temp.push(num);
            }else{
                int a = temp.pop();
                int b = temp.pop();
                if(ch == '*'){
                    temp.push(b*a);
                }else if(ch == '/'){
                    temp.push(b/a);
                }else if(ch == '+'){
                    temp.push(b+a);
                }else if(ch == '-'){
                    temp.push(b-a);
                }
            }
        }

        return temp.pop();

    }
}