class Solution {
    public boolean isValid(String s) {
        Stack<Character> temp = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                temp.push(s.charAt(i));
            }else{
                if(s.charAt(i) == ')'){
                    if(temp.isEmpty() || temp.pop() != '(') return false;
                }
                if(s.charAt(i) == '}'){
                    if(temp.isEmpty() || temp.pop() != '{') return false;
                }
                if(s.charAt(i) == ']'){
                    if(temp.isEmpty() || temp.pop() != '[') return false;
                }
            }
        }

        return temp.isEmpty();
    }
}