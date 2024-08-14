class StockSpanner {

    Stack<Pair> temp;
    int index;
    public StockSpanner() {
        temp = new Stack<>();
        index = -1;
    }
    
    public int next(int price) {
        
        index++;
        while(!temp.isEmpty() && temp.peek().val <= price){
            temp.pop();
        }

        if(temp.isEmpty()){
            temp.push(new Pair(price,index));
            return (index+1);
        }

        int curr = temp.peek().idx;
        temp.push(new Pair(price,index));
        return (index-curr);
    }
}

class Pair{
    int val;
    int idx;

    public Pair(int v,int i){
        this.val = v;
        this.idx = i;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */