class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Pair> temp = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!temp.isEmpty() && temp.peek().ch == ch){
                if(temp.peek().val + 1 == k){
                    temp.pop();
                }else{
                    Pair p = temp.pop();
                    p.val = p.val + 1;
                    temp.push(p);
                }
            }else{
                temp.push(new Pair(1,ch));
            }
        }

        s = "";
        while(!temp.isEmpty()){
            Pair p = temp.pop();
            int v = p.val;
            while(v >= 1){
                s = p.ch + s;
                v--;
            }
        }

        return s;
    }

    class Pair{
        int val;
        char ch;

        public Pair(int v,char c){
            this.val = v;
            this.ch = c;
        }
    }
}