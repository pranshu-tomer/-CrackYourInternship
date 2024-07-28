class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        int ans = Integer.MIN_VALUE;
        PriorityQueue<Pair> temp = new PriorityQueue<>();

        for(int i=0; i<points.length; i++){

            while(!temp.isEmpty() && (points[i][0] - temp.peek().x) > k){
                temp.remove();
            }

            if(!temp.isEmpty()){
                ans = Math.max(temp.peek().val+(points[i][0]+points[i][1]),ans);
            }

            temp.add(new Pair(points[i][1] - points[i][0],points[i][0]));
        }

        return ans;
    }

    class Pair implements Comparable<Pair>{
        int val;
        int x;

        public Pair(int v,int x){
            this.val = v;
            this.x = x;
        }

        public int compareTo(Pair p){
            return p.val-this.val;
        }
    }
}